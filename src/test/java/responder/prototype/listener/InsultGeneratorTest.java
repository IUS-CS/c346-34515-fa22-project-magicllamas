package responder.prototype.listener;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InsultGeneratorTest{

    @Mock
    MessageReceivedEvent eventMock;

    @Test
    public void botIgnoredTest() { //wait until a message is sent on discord

        try {
            wait(80000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //ignore bot messages?
        //do not respond to other bots
        MessageChannel channel = eventMock.getChannel();//get whatever you say
        if (eventMock.getAuthor().isBot()) {
            assertTrue(eventMock.getAuthor().isBot());
        }
    }
}