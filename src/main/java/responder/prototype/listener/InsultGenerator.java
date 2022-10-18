package responder.prototype.listener;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


/**
 * This is the insult genetator. It has 3 insults so far.
 * This class is tested in the Test directory
 */
public class InsultGenerator extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //do not respond to other bots
        if (event.getAuthor().isBot()) return;
        //get message as string
        String content = event.getMessage().getContentRaw();

        //your message contains "!"?
        if (content.contains("!")) {
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
        } else if(content.contains("meet")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("Come quickly, You slow turtle!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }else if(content.contains("insult")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("Do you care for more, You silly child").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }else if(content.contains("yes")) {
            MessageChannel channel = event.getChannel();//get whatever you say
            //respond well
            channel.sendMessage("Always accepting everything, prove you have some brains snail!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
    }
}

