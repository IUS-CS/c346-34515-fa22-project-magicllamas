package responder.prototype.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CurrentTimeTest extends CurrentTime {


    private MessageReceivedEvent botIgnoredEvent() { //method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        User user = mock(User.class); // mocking the user object
        when(user.isBot()).thenReturn(true); // setting up what each method should return
        when(event.getAuthor()).thenReturn(user);
        return event;
    }

    /**
     * Due to how my code was set up I decided to test my code in two ways
     * 1) Does my code is getting the code information it was supposed to get from the CSV files
     * 2) Does my code was sends the correctly formatted message into the discord channel after the user uses
     * the command
     *
     * The tests for number 1 I chose the first and last zipcodes in the csv file and a random zipcode from csv
     */
    @Test
    void CurrentTimeCorrectDataTest_1NNNN_10001() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "40.75064";
        String test_Longitude = "-73.99728";
        String test_City = "New York";
        String test_File = "doc/CSV Files/Zipcodes_1NNNN.csv";
        String test_Zipcode = "10001";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_1NNNN_19980() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "39.07349";
        String test_Longitude = "-75.57008";
        String test_City = "Woodside";
        String test_File = "doc/CSV Files/Zipcodes_1NNNN.csv";
        String test_Zipcode = "19980";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_1NNNN_16141() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "40.87237";
        String test_Longitude = "-80.3968";
        String test_City = "New Galilee";
        String test_File = "doc/CSV Files/Zipcodes_1NNNN.csv";
        String test_Zipcode = "16141";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_2NNNN_20001() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "38.91002";
        String test_Longitude = "-77.018";
        String test_City = "Washington";
        String test_File = "doc/CSV Files/Zipcodes_2NNNN.csv";
        String test_Zipcode = "20001";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_2NNNN_29945() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "32.68694";
        String test_Longitude = "-80.80912";
        String test_City = "Yemassee";
        String test_File = "doc/CSV Files/Zipcodes_2NNNN.csv";
        String test_Zipcode = "29945";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_2NNNN_23934() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "37.17613";
        String test_Longitude = "-78.62373";
        String test_City = "Cullen";
        String test_File = "doc/CSV Files/Zipcodes_2NNNN.csv";
        String test_Zipcode = "23934";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_3NNNN_30002() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "33.77309";
        String test_Longitude = "-84.26093";
        String test_City = "Avondale Estates";
        String test_File = "doc/CSV Files/Zipcodes_3NNNN.csv";
        String test_Zipcode = "30002";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_3NNNN_39897() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "30.91234";
        String test_Longitude = "-84.33297";
        String test_City = "Whigham";
        String test_File = "doc/CSV Files/Zipcodes_3NNNN.csv";
        String test_Zipcode = "39897";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_3NNNN_35984() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "34.52781";
        String test_Longitude = "-85.56594";
        String test_City = "Mentone";
        String test_File = "doc/CSV Files/Zipcodes_3NNNN.csv";
        String test_Zipcode = "35984";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_4NNNN_40003() {
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "38.26863";
        String test_Longitude = "-85.04367";
        String test_City = "Bagdad";
        String test_File = "doc/CSV Files/Zipcodes_4NNNN.csv";
        String test_Zipcode = "40003";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_4NNNN_49999() { //Why is there 5NNNN in the 4NNNN is odd but that's how the info was organized
        String test_Location_TimeZone = "America/New_York";
        String test_Latitude = "42.57315643";
        String test_Longitude = "-85.00507588";
        String test_City = "Louisville";
        String test_File = "doc/CSV Files/Zipcodes_4NNNN.csv";
        String test_Zipcode = "49999";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_4NNNN_47392() {
        String test_Location_TimeZone = "America/Indiana/Indianapolis";
        String test_Latitude = "39.91005";
        String test_Longitude = "-84.94394";
        String test_City = "Webster";
        String test_File = "doc/CSV Files/Zipcodes_4NNNN.csv";
        String test_Zipcode = "47392";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_5NNNN_50001() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "41.3611";
        String test_Longitude = "-93.43321";
        String test_City = "Ackworth";
        String test_File = "doc/CSV Files/Zipcodes_5NNNN.csv";
        String test_Zipcode = "50001";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_5NNNN_59937() { //Why is there 5NNNN in the 4NNNN is odd but that's how the info was organized
        String test_Location_TimeZone = "America/Denver";
        String test_Latitude = "48.43893";
        String test_Longitude = "-114.49769";
        String test_City = "Whitefish";
        String test_File = "doc/CSV Files/Zipcodes_5NNNN.csv";
        String test_Zipcode = "59937";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_5NNNN_54669() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "43.91171";
        String test_Longitude = "-91.09046";
        String test_City = "West Salem";
        String test_File = "doc/CSV Files/Zipcodes_5NNNN.csv";
        String test_Zipcode = "54669";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_6NNNN_60002() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "42.4674";
        String test_Longitude = "-88.09419";
        String test_City = "Antioch";
        String test_File = "doc/CSV Files/Zipcodes_6NNNN.csv";
        String test_Zipcode = "60002";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_6NNNN_69367() { //Why is there 5NNNN in the 4NNNN is odd but that's how the info was organized
        String test_Location_TimeZone = "America/Denver";
        String test_Latitude = "42.81651";
        String test_Longitude = "-103.32332";
        String test_City = "Whitney";
        String test_File = "doc/CSV Files/Zipcodes_6NNNN.csv";
        String test_Zipcode = "69367";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_6NNNN_63967() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "36.94867";
        String test_Longitude = "-90.47721";
        String test_City = "Williamsville";
        String test_File = "doc/CSV Files/Zipcodes_6NNNN.csv";
        String test_Zipcode = "63967";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_7NNNN_70001() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "29.98272";
        String test_Longitude = "-90.16881";
        String test_City = "Metairie";
        String test_File = "doc/CSV Files/Zipcodes_7NNNN.csv";
        String test_Zipcode = "70001";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_7NNNN_79938() { //Why is there 5NNNN in the 4NNNN is odd but that's how the info was organized
        String test_Location_TimeZone = "America/Denver";
        String test_Latitude = "31.85764";
        String test_Longitude = "-106.03895";
        String test_City = "El Paso";
        String test_File = "doc/CSV Files/Zipcodes_7NNNN.csv";
        String test_Zipcode = "79938";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_7NNNN_75759() {
        String test_Location_TimeZone = "America/Chicago";
        String test_Latitude = "32.03617";
        String test_Longitude = "-95.41573";
        String test_City = "Cuney";
        String test_File = "doc/CSV Files/Zipcodes_7NNNN.csv";
        String test_Zipcode = "75759";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_8NNNN_80002() {
        String test_Location_TimeZone = "America/Denver";
        String test_Latitude = "39.79405";
        String test_Longitude = "-105.10845";
        String test_City = "Arvada";
        String test_File = "doc/CSV Files/Zipcodes_8NNNN.csv";
        String test_Zipcode = "80002";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_8NNNN_89883() { //Why is there 5NNNN in the 4NNNN is odd but that's how the info was organized
        String test_Location_TimeZone = "America/Los_Angeles";
        String test_Latitude = "40.84711";
        String test_Longitude = "-114.18217";
        String test_City = "West Wendover";
        String test_File = "doc/CSV Files/Zipcodes_8NNNN.csv";
        String test_Zipcode = "89883";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_8NNNN_81657() {
        String test_Location_TimeZone = "America/Denver";
        String test_Latitude = "39.64864";
        String test_Longitude = "-106.32608";
        String test_City = "Vail";
        String test_File = "doc/CSV Files/Zipcodes_8NNNN.csv";
        String test_Zipcode = "81657";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }

    @Test
    void CurrentTimeCorrectDataTest_9NNNN_90001() {
        String test_Location_TimeZone = "America/Los_Angeles";
        String test_Latitude = "33.97365";
        String test_Longitude = "-118.24904";
        String test_City = "Los Angeles";
        String test_File = "doc/CSV Files/Zipcodes_9NNNN.csv";
        String test_Zipcode = "90001";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_8NNNN_99929() { //Why is there 5NNNN in the 4NNNN is odd but that's how the info was organized
        String test_Location_TimeZone = "America/Sitka";
        String test_Latitude = "56.36089";
        String test_Longitude = "-132.00635";
        String test_City = "Wrangell";
        String test_File = "doc/CSV Files/Zipcodes_9NNNN.csv";
        String test_Zipcode = "99929";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
    @Test
    void CurrentTimeCorrectDataTest_9NNNN_96777() {
        String test_Location_TimeZone = "Pacific/Honolulu";
        String test_Latitude = "19.23137";
        String test_Longitude = "-155.4705";
        String test_City = "Pahala";
        String test_File = "doc/CSV Files/Zipcodes_9NNNN.csv";
        String test_Zipcode = "96777";
        String current_Time = CurrentTime(test_Zipcode);//Not used cause tested else where
        String[] test_returnArray = getReturnArray();
        String file = getFile();
        assertEquals(test_Latitude, test_returnArray[0]);
        assertEquals(test_Longitude, test_returnArray[1]);
        assertEquals(test_City, test_returnArray[2]);
        assertEquals(test_Location_TimeZone, test_returnArray[3]);
        assertEquals(test_File, file);
    }
}
