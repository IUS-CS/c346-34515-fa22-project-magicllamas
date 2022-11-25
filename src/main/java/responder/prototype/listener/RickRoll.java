package responder.prototype.listener;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RickRoll extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("icecream")) {
            // /icecream command
            ReplyCallbackAction action = event
                    .reply("TikToks that are straight bussin.\n<https://www.youtube.com/watch?v=dQw4w9WgXcQ>");
            action.queue();
        }
        else if(command.equals("nickname")){
            String nickname = event.getOption("newname").getAsString();
            Objects.requireNonNull(event.getMember()).modifyNickname(nickname).queue();
            event.reply("Your nickname on this server has been changed to: " + nickname).queue();
        }
        else if(command.equals("monkey")){
            User user = event.getOption("username").getAsUser();
            event.reply(event.getOption("username").getAsUser().getName()
                    + ", you've been monkeyed with!").queue();
           for(int i = 0; i < 10; i ++){
                user.openPrivateChannel()
                        .flatMap(channel -> channel.sendMessage("Hey? Oh, hi! Hey. How are you?"))
                        .queue();
            }
        }
        else if(command.equals("picture")){
            User user = event.getOption("username").getAsUser();
            String link = event.getOption("link").getAsString();
            event.reply(event.getOption("username").getAsUser().getName()
                    + ", have you seen this before?").queue();
            for(int i = 0; i < 10; i ++){
                user.openPrivateChannel()
                        .flatMap(channel -> channel.sendMessage(link))
                        .queue();
            }
        }
    }


    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("icecream", "???"));
        commandData.add(Commands.slash("nickname", "Nickname goes in option newname.")
                .addOption(OptionType.STRING, "newname", "Nickname goes here."));
        OptionData option = new OptionData(OptionType.USER, "username", "Select the user to monkey with."
                , true);
        commandData.add(Commands.slash("monkey", "Choose a user to monkey with.").addOptions(option));
        OptionData pictureOption1 = new OptionData(OptionType.USER, "username"
                , "Select the user to monkey with.", true);
        OptionData pictureOption2 = new OptionData(OptionType.STRING, "link"
                , "Paste photo link here.", true);
        commandData.add(Commands.slash("picture", "Send a friend a funny photo.")
                .addOptions(pictureOption1, pictureOption2));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
