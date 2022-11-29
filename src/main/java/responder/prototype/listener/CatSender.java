package responder.prototype.listener;


import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CatSender extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        String content = "Meow";
        File f = new File("image.png");


        if (command.equals("catlauncher")) {
            event.getChannel().sendMessage("https://i0.wp.com/katzenworld.co.uk/wp-content/uploads/2019/06/funny-cat.jpeg?fit=1920%2C1920&ssl=1")
                    .queue();
            ReplyCallbackAction action = event.reply(content);
            action.queue();
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("catlauncher", "Launch a cat at friends"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
