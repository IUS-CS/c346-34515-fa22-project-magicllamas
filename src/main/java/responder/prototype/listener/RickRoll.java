package responder.prototype.listener;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.entities.Member;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
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
    }



    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("icecream", "???"));
        commandData.add(Commands.slash("nickname", "Nickname goes in option newname.")
                .addOption(OptionType.STRING, "newname", "Nickname goes here."));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
