package responder.prototype.listener;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsultGeneratorTest{

    @Test
    public void botIgnoredTest() { //wait until a message is sent on discord

        MessageReceivedEvent event = mock(MessageReceivedEvent.class); //mocking the event object
        User user = mock(User.class); // mocking the user object
        when(user.isBot()).thenReturn(true); // setting up what each method should return
        when(event.getAuthor()).thenReturn(user);

        //ignore bot messages?
        //do not respond to other bots
        if (event.getAuthor().isBot()) {
            assertTrue(event.getAuthor().isBot());
        }
    }
}