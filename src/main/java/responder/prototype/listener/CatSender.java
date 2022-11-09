package responder.prototype.listener;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.io.File;

import java.util.Objects;

public class CatSender extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();


        if(command.equals("CatLauncher")){
            File file = new File("Cat.png");

            if (Objects.nonNull(file)) {
                event.getChannel().sendMessage("Here is my image !").addFile(file).queue();
            } else {
                event.getChannel().sendMessage("Sorry, I can't found the image :c").queue();
            }

        }
    }
}
