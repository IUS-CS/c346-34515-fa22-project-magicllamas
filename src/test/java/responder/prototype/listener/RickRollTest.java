package responder.prototype.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class RickRollTest {

    private RickRoll slashCommand;
    private SlashCommandInteractionEvent scEvent() {
        SlashCommandInteractionEvent event = mock(SlashCommandInteractionEvent.class);
        ReplyCallbackAction callback = mock(ReplyCallbackAction.class);
        when(event.getName()).thenReturn("icecream");
        String content = "TikToks that are straight bussin.\n<https://www.youtube.com/watch?v=dQw4w9WgXcQ>";
        when(event.reply(content)).thenReturn(callback);
        return event;
    }

    @Test
    public void testSlashCommandRickRoll (){
        slashCommand = new RickRoll();
        var event = scEvent();
        slashCommand.onSlashCommandInteraction(event);
    }
}