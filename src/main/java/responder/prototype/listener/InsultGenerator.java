package responder.prototype.listener;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


/**
 * This is the insult genetator.
 * This class is tested in the Test directory
 */
public class InsultGenerator extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //do not respond to other bots
        if (event.getAuthor().isBot()) {return;};
        //get message as string
        String content = event.getMessage().getContentRaw();

        //your message contains "!"?
        if (content.equals("!")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("I can't hear ye! Scream a bit louder ye old salt!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        } else if (content.contains("try")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("You Crusty Nut Explorer!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }else if (content.contains("pull")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("Pull harder, You Silly Wiener Wizard!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        else if (content.contains("md")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("Ok nut doctor!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        else if (content.contains("request")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("You are a request and I will not merge you").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }

    }
}

