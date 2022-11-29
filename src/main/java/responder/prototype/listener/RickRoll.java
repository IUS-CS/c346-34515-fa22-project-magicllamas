package responder.prototype.listener;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RickRoll extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("icecream")) {
            ReplyCallbackAction action = event
                    .reply("TikToks that are straight bussin.\n<https://www.youtube.com/watch?v=dQw4w9WgXcQ>");
            action.queue();
        }
        else if(command.equals("nickname")){
            String nickname = event.getOption("newname").getAsString();
            Objects.requireNonNull(event.getMember()).modifyNickname(nickname).queue();
            event.reply("Your nickname on this server has been changed to: " + nickname).queue();
        }
        else if(command.equals("monkey")) {
            User user = event.getOption("username").getAsUser();
            OptionMapping optionMapping = event.getOption("link");
            if(optionMapping == null) {
                event.reply(user.getName() + ", you've been monkeyed with! :speak_no_evil:").queue();
                for (int i = 0; i < 10; i++) {
                    user.openPrivateChannel()
                            .flatMap(channel -> channel.sendMessage(":hear_no_evil: Hey? Oh, hi! Hey. How are you?"))
                            .queue();
                }
            }
            else {
                event.reply(user.getName() + ", have you seen this before? :see_no_evil:").queue();
                String link = event.getOption("link").getAsString();
                for (int i = 0; i < 10; i++) {
                    user.openPrivateChannel()
                            .flatMap(channel -> channel.sendMessage(link))
                            .queue();
                }
            }
        }
        else if (command.equals("catlauncher")) {
            String content = "Meow";
            File f = new File("image.png");
            event.getChannel().sendMessage("https://i0.wp.com/katzenworld.co.uk/wp-content/uploads/2019/06/funny-cat.jpeg?fit=1920%2C1920&ssl=1")
                    .queue();
            ReplyCallbackAction action = event.reply(content);
            action.queue();
        }
    }


    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        //rick roll slash command
        commandData.add(Commands.slash("icecream", "???"));
        //change name in server slash command
        commandData.add(Commands.slash("nickname", "Nickname goes in option newname.")
                .addOption(OptionType.STRING, "newname", "Nickname goes here."));
        //spam slash command-> option1:text spam, option2:photo spam
        OptionData option1 = new OptionData(OptionType.USER, "username"
                , "Select the user to monkey with.", true);
        OptionData option2 = new OptionData(OptionType.STRING, "link"
                , "Paste photo link here.", false);
        commandData.add(Commands.slash("monkey", "Choose a user to monkey with.")
                .addOptions(option1, option2));
        commandData.add(Commands.slash("catlauncher", "Launch a cat at friends"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
