package responder.prototype.listener;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CurrentTime extends ListenerAdapter {
    //Used to find Zipcode in one of CSV files and their TimeZone with a binary search
    private static String[] returnArray = new String[4];
    private static String file = "";

    public static String getFile() {
        return file;
    }

    public static String[] getReturnArray() {
        return returnArray;
    }

    public static String[] binarySearch(List<String[]> stringList, int first, int last, int key){
        double double_Mid = Math.ceil((Double.valueOf(first) + Double.valueOf(last))/2.0);
        int mid = (int)double_Mid;
        String[] temp;
        String[] errorArray = {"Error"};
        try {
            while (first <= last) {
                temp = stringList.get(mid-2);//reduce mid by 2 cause of how the size of the Zipcode file and first zipcode in that file are sent to method and how the math works out
                if (Integer.parseInt(temp[0]) < key) {
                    first = mid + 1;
                } else if (Integer.parseInt(temp[0]) == key) {
                    returnArray[0] = temp[1];
                    returnArray[1] = temp[2];
                    returnArray[2] = temp[3];
                    returnArray[3] = temp[4];
                    return returnArray;
                } else {
                    last = mid - 1;
                }
                mid = (first + last) / 2;
            }
            if (first > last) {
                return errorArray; //Sends Error back so code and can send proper response to user
            }
        } catch (Exception ex){
            return errorArray;//Sends Error back so code and can send proper response to user
        }
        return errorArray;//Sends Error back so code and can send proper response to user
    }
    //CurrentTime will find the current time and date for the timezone you ask for, but it is limited
    public static String CurrentTime(String Zipcode){
        /**String variables for the location(Area for which the time zone is being looked up),
         * localtime (time to be returned), file (file to be searched) */
        String[] location;
        String localTime;
        //List of Arrays for Zipcode CSV file
        List<String[]> ZipcodeFile;
        //Removes whitespace if needed
        Zipcode = Zipcode.trim();
        //Pulls date library to get proper date of Location
        Date date = new Date();
        //Formats the Date Formatter to the String in the parentheses of SimpleDateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //All zipcodes below 1000 are in puerto rican time zone
        try {
            //Any Zipcode below 1000 is in the Puerto Rican TimeZone
            if (Integer.parseInt(Zipcode) < 1000) {
                df.setTimeZone(TimeZone.getTimeZone("America/Puerto_Rico"));
                localTime = df.format(date);
                return localTime;
            }
            //This Temp variable gets the first char from zipcode
            char temp = Zipcode.charAt(0);
            //This Switch statement checks what temp is and then sets variable file accordingly
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
                default: file = " ";break;//If something is not correct with zipcode sets file to nothing so it causes an error
            }
            //File reader from Java library to read correct CSV file in variable file
            FileReader fileReader = new FileReader(file);
            /**CSVreader is a class to specifically read csv files from OpenCSV (Open Source Software from Maven)
             * CSVReaderBuilder is a class that allows for more functionality in CSVReader
             * Also skips the first line in CSV file cause the first line in files is the headers
             */
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            //readAll is a class in OpenCSV that reads all lines in CSV file to a list of arrays
            ZipcodeFile = csvReader.readAll();
            //Temp zipcode to be sent to binary Search cause Zipcode is a String in List
            int tempZipcode = Integer.parseInt(Zipcode);
            //location is TimeZone location from Zipcode (Example: America/New_York)
            location = binarySearch(ZipcodeFile, 2, (ZipcodeFile.size()+1), tempZipcode);
            //If error don't try to do stuff and actually cause an error
            if (location[0] == "Error"){
                return "Error";
            }
            //Uses TimeZone Library to get time of variable location and sets it to variable df
            df.setTimeZone(TimeZone.getTimeZone(location[3]));
            //Sets localTime to date and time of searched timeZone with format date
            localTime = df.format(date);
            //Returns localTime
            return localTime;
        } catch (Exception ex){
            return "Error";
        }
    }


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        try {
            //Tells bot to not respond to other bots
            if (event.getAuthor().isBot()) return;

            //Splits message into command and inputted zipcode
            String[] content = event.getMessage().getContentRaw().split(" ");
            //Checks to see if time command was used
            if (content[0].equalsIgnoreCase("!time")||content[0].equalsIgnoreCase("!Time")){
                String currentTime = CurrentTime(content[1]);
                //If command is not correct or zipcode is not found, outputs error message below
                if (currentTime == "Error"){
                    event.getChannel().sendMessage("Error: Unable to get the time and/or date of Zipcode please check that " +
                            "you have inputted the correct zipcode and/or typed the command correctly (!time <Zipcode>)").queue();
                }
                else { //Output for proper zipcode
                    event.getChannel().sendMessage("The current date and time for the Zipcode " +
                            content[1] + " is " + currentTime).queue();
                }
            }

        } catch (Exception ex){
            //If command is not correct or zipcode is not found, outputs error message below
            event.getChannel().sendMessage("Error: Unable to get the time and/or date of Zipcode please check that " +
                    "you have inputted the correct zipcode and/or typed the command correctly (!time <Zipcode>)").queue();
        }
    }
}
