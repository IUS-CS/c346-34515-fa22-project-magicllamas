package responder.prototype.listener;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class CurrentTime extends ListenerAdapter {
    //Used to find Zipcode in one of CSV files and their TimeZone
    public static String binarySearch(List<String[]> stringList, int first, int last, int key){
        int mid = (first + last)/2;
        String[] temp;
        try {
            while (first <= last) {
                temp = stringList.get(mid);
                if (Integer.parseInt(temp[0]) < key) {
                    first = mid + 1;
                } else if (Integer.parseInt(temp[0]) == key) {
                    String location = temp[4];
                    return location;
                } else {
                    last = mid - 1;
                }
                mid = (first + last) / 2;
            }
            if (first > last) {
                return "Error";
            }
        } catch (Exception ex){
            return "Error";
        }
        return "Error";
    }
    //CurrentTime will find the current time and date for the timezone you ask for, but it is limited
    public static String CurrentTime(String Zipcode){
        /**String variables for the location(Area for which the time zone is being looked up),
         * localtime (time to be returned), file (file to be searched) */
        String location = "";
        String localTime;
        String file = "";
        //Array for Zipcode CSV file
        List<String[]> ZipcodeFile;
        //Removes whitespace if needed
        Zipcode = Zipcode.trim();
        //Pulls date library to get proper date of Location
        Date date = new Date();
        //Formats the Date Formatter to the String in the parentheses of SimpleDateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //All zipcodes below 1000 are in puerto rican time zone
        try {
            if (Integer.parseInt(Zipcode) < 1000) {
                df.setTimeZone(TimeZone.getTimeZone("America/Puerto_Rico"));
                localTime = df.format(date);
                return localTime;
            }
            char temp = Zipcode.charAt(0);
            switch (temp) {
                case '1':
                    file = "doc/CSV Files/Zipcodes_1NNNN.csv";break;
                case '2':
                    file = "doc/CSV Files/Zipcodes_2NNNN.csv";break;
                case '3':
                    file = "doc/CSV Files/Zipcodes_3NNNN.csv";break;
                case '4':
                    file = "doc/CSV Files/Zipcodes_4NNNN.csv";break;
                case '5':
                    file = "doc/CSV Files/Zipcodes_5NNNN.csv";break;
                case '6':
                    file = "doc/CSV Files/Zipcodes_6NNNN.csv";break;
                case '7':
                    file = "doc/CSV Files/Zipcodes_7NNNN.csv";break;
                case '8':
                    file = "doc/CSV Files/Zipcodes_8NNNN.csv";break;
                case '9':
                    file = "doc/CSV Files/Zipcodes_9NNNN.csv";break;
            }
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            ZipcodeFile = csvReader.readAll();
            int tempZipcode = Integer.parseInt(Zipcode);
            location = binarySearch(ZipcodeFile, 2, ZipcodeFile.size(), tempZipcode);
            //Uses TimeZone Library to get time of variable location and sets it to variable df
            df.setTimeZone(TimeZone.getTimeZone(location));
            //Places the current time and date of variable location in variable currentTime
            localTime = df.format(date);
            return localTime;
        } catch (Exception ex){
            String error = "Error Zipcode not found";
            return error;
        }
    }

    public static void main(String[] args) {
        //Try catch just encase the user trys to break the CurrentTime function
        try {
            //Only finds the time for Greenwich mean time for testing purposes at the moment
            Scanner scanner = new Scanner(System.in);
            String  zipcode = scanner.nextLine();
            String currentTime = CurrentTime(zipcode);
            System.out.println(currentTime);
        }catch (Exception ex){
            System.out.println("Error");
        }
    }
}
