package responder.prototype.listener;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsultGeneratorTest {
    private InsultGenerator insultGenerator;

    private MessageReceivedEvent scEvent() {
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        Message getMessage= mock(Message.class);
        User user = mock(User.class); // mocking the user object
        when(event.getAuthor()).thenReturn(user);
        when(event.getMessage()).thenReturn(getMessage);


        return event;
    }

    private MessageReceivedEvent scEventBIT() {
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        User user = mock(User.class); // mocking the user object
        when(event.getAuthor()).thenReturn(user);

        return event;
    }

    @Test
    public void botIgnoredTest() { //can tell if person with event is bot
        insultGenerator = new InsultGenerator();
        var event = scEvent();
        insultGenerator.onMessageReceived(event);

    }

   // @Test
   // public void onExclamation() { //Does the bot respond with an exclamation mark
       // insultGenerator = new InsultGenerator();
       // var event =scEvent();
       // insultGenerator.onMessageReceived(event);
   // }


        @Test
        public void onTry () { //Does the bot respond with an exclamation mark

            MessageReceivedEvent event = mock(MessageReceivedEvent.class); //mocking the event object
            MessageChannel channel = mock(MessageChannel.class); //mocking the channel object
            User user = mock(User.class); // mocking the user object
            when(user.isBot()).thenReturn(true); // setting up what each method should return
            when(event.getAuthor()).thenReturn(user);

            //acknowledge user messages and print them to console
            while (!(event.getAuthor().isBot())) {
                try {
                    wait();
                    String content = event.getMessage().getContentRaw();
                    Boolean botsaid = true;

                    if (content.contains("try")) { //if user sends a "try"
                        String botMessage = channel.sendMessage("You Crusty Nut Explorer!").getContent(); //this is bot response
                        if (!botMessage.isEmpty()) {
                            assertTrue(botsaid);
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }

            }
        }

        @Test
        public void onPull () { //Does the bot respond with an exclamation mark

            MessageReceivedEvent event = mock(MessageReceivedEvent.class); //mocking the event object
            MessageChannel channel = mock(MessageChannel.class); //mocking the channel object
            User user = mock(User.class); // mocking the user object
            when(user.isBot()).thenReturn(true); // setting up what each method should return
            when(event.getAuthor()).thenReturn(user);

            //acknowledge user messages and print them to console
            while (!(event.getAuthor().isBot())) {
                try {
                    wait();
                    String content = event.getMessage().getContentRaw();
                    Boolean botsaid = true;

                    if (content.contains("pull")) { //if user sends a "pull"
                        String botMessage = channel.sendMessage("Pull harder, You Silly Wiener Wizard!").getContent(); //this is bot response
                        if (!botMessage.isEmpty()) {
                            assertTrue(botsaid);
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }

            }
        }

        @Test
        public void onMd () { //Does the bot respond with an exclamation mark

            MessageReceivedEvent event = mock(MessageReceivedEvent.class); //mocking the event object
            MessageChannel channel = mock(MessageChannel.class); //mocking the channel object
            User user = mock(User.class); // mocking the user object
            when(user.isBot()).thenReturn(true); // setting up what each method should return
            when(event.getAuthor()).thenReturn(user);

            //acknowledge user messages and print them to console
            while (!(event.getAuthor().isBot())) {
                try {
                    wait();
                    String content = event.getMessage().getContentRaw();
                    Boolean botsaid = true;

                    if (content.contains("md")) { //if user sends an "md"
                        String botMessage = channel.sendMessage("Ok nut doctor!").getContent(); //this is bot response
                        if (!botMessage.isEmpty()) {
                            assertTrue(botsaid);
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }

            }
        }

        @Test
        public void onRequest () { //Does the bot respond with an exclamation mark

            MessageReceivedEvent event = mock(MessageReceivedEvent.class); //mocking the event object
            MessageChannel channel = mock(MessageChannel.class); //mocking the channel object
            User user = mock(User.class); // mocking the user object
            when(user.isBot()).thenReturn(true); // setting up what each method should return
            when(event.getAuthor()).thenReturn(user);

            //acknowledge user messages and print them to console
            while (!(event.getAuthor().isBot())) {
                try {
                    wait();
                    String content = event.getMessage().getContentRaw();
                    Boolean botsaid = true;

                    if (content.contains("request")) { //if user sends a "request"
                        String botMessage = channel.sendMessage("You are a request and I will not merge you").getContent(); //this is bot response
                        if (!botMessage.isEmpty()) {
                            assertTrue(botsaid);
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }

            }
        }
    }
