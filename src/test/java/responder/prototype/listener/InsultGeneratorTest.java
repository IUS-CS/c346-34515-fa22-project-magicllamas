package responder.prototype.listener;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsultGeneratorTest {
    private InsultGenerator insultGenerator;  // insult generator constructor

    private MessageReceivedEvent botIgnoredEvent() { //method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        User user = mock(User.class); // mocking the user object
        when(user.isBot()).thenReturn(true); // setting up what each method should return
        when(event.getAuthor()).thenReturn(user);


        return event;
    }
    @Test
    public void botIgnoredTest() { //can tell if user with event is bot
        insultGenerator = new InsultGenerator();
        var event = botIgnoredEvent();
        insultGenerator.onMessageReceived(event);

    }


    private MessageReceivedEvent oldSaltEvent() {//method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        Message getMessage= mock(Message.class);
        User user = mock(User.class); // mocking the user object
        MessageChannelUnion channel = mock(MessageChannelUnion.class);
        MessageCreateAction callback = mock(MessageCreateAction.class);
        when(event.getAuthor()).thenReturn(user);
        when(event.getMessage()).thenReturn(getMessage);
        when(getMessage.getContentRaw()).thenReturn("!");
        when(event.getChannel()).thenReturn(channel);
        when(channel.sendMessage("I can't hear ye! Scream a bit louder ye old salt!")).thenReturn(callback);

        return event;
    }
    @Test
    public void onExclamation () { //Does the bot respond with an exclamation mark

        insultGenerator = new InsultGenerator();
        var event = oldSaltEvent();
        insultGenerator.onMessageReceived(event);
    }
    private MessageReceivedEvent crustyExplorerEvent() {//method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        Message getMessage= mock(Message.class);
        User user = mock(User.class); // mocking the user object
        MessageChannelUnion channel = mock(MessageChannelUnion.class);
        MessageCreateAction callback = mock(MessageCreateAction.class);
        when(event.getAuthor()).thenReturn(user);
        when(event.getMessage()).thenReturn(getMessage);
        when(getMessage.getContentRaw()).thenReturn("try");
        when(event.getChannel()).thenReturn(channel);
        when(channel.sendMessage("You Crusty Nut Explorer!")).thenReturn(callback);

        return event;
    }
    @Test
    public void onTry () { //Does the bot respond with channel.sendMessage(...)

        insultGenerator = new InsultGenerator();
        var event = crustyExplorerEvent();
        insultGenerator.onMessageReceived(event);
    }

    private MessageReceivedEvent weinerWizardEvent() {//method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        Message getMessage= mock(Message.class);
        User user = mock(User.class); // mocking the user object
        MessageChannelUnion channel = mock(MessageChannelUnion.class);
        MessageCreateAction callback = mock(MessageCreateAction.class);
        when(event.getAuthor()).thenReturn(user);
        when(event.getMessage()).thenReturn(getMessage);
        when(getMessage.getContentRaw()).thenReturn("pull");
        when(event.getChannel()).thenReturn(channel);
        when(channel.sendMessage("Pull harder, You Silly Wiener Wizard!")).thenReturn(callback);

        return event;
    }
    @Test
    public void onPull () { //Does the bot respond with channel.sendMessage(...)

        insultGenerator = new InsultGenerator();
        var event = weinerWizardEvent();
        insultGenerator.onMessageReceived(event);
    }
    private MessageReceivedEvent nutDoctorEvent() {//method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        Message getMessage= mock(Message.class);
        User user = mock(User.class); // mocking the user object
        MessageChannelUnion channel = mock(MessageChannelUnion.class);
        MessageCreateAction callback = mock(MessageCreateAction.class);
        when(event.getAuthor()).thenReturn(user);
        when(event.getMessage()).thenReturn(getMessage);
        when(getMessage.getContentRaw()).thenReturn("md");
        when(event.getChannel()).thenReturn(channel);
        when(channel.sendMessage("Ok nut doctor!")).thenReturn(callback);
        return event;
    }
    @Test
    public void onMd () {//Does the bot respond with channel.sendMessage(...)

        insultGenerator = new InsultGenerator();
        var event = nutDoctorEvent();
        insultGenerator.onMessageReceived(event);
    }

    private MessageReceivedEvent mergeRequest() {//method allows me to mock objects and test our version of the code.
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        Message getMessage= mock(Message.class);
        User user = mock(User.class); // mocking the user object
        MessageChannelUnion channel = mock(MessageChannelUnion.class);
        MessageCreateAction callback = mock(MessageCreateAction.class);
        when(event.getAuthor()).thenReturn(user);
        when(event.getMessage()).thenReturn(getMessage);
        when(getMessage.getContentRaw()).thenReturn("request");
        when(event.getChannel()).thenReturn(channel);
        when(channel.sendMessage("You are a request and I will not merge you")).thenReturn(callback);

        return event;
    }
    @Test
    public void onRequest () {//Does the bot respond with channel.sendMessage(...)

        insultGenerator = new InsultGenerator();
        var event = mergeRequest();
        insultGenerator.onMessageReceived(event);
    }


}