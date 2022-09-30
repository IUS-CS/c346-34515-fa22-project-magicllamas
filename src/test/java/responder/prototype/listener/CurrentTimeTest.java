package responder.prototype.listener;

import org.junit.jupiter.api.Test;

public class CurrentTimeTest extends CurrentTime{
    @Test
    void Test1_UMT(){
        String Location = "UMT";
        String thing = CurrentTime(Location);
        System.out.println(thing);
    }
    @Test
    void Test1_PST(){
        String Location = "PST";
        String thing = CurrentTime(Location);
        System.out.println(thing);
    }
    @Test
    void Test1_Europe_Madrid(){
        String Location = "Europe/Madrid";
        String thing = CurrentTime(Location);
        System.out.println(thing);
    }
}
