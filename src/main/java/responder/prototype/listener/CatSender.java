package responder.prototype.listener;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class CatSender extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
    if(event.getName().equals("CatLauncher")){
        event.reply("https://purepng.com/public/uploads/large/purepng.com-catcat-animal-981524644802hvred.png");

    }
    }
}
