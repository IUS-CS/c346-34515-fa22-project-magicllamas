package responder.prototype.listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.CacheRestAction;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RickRollTest {

    private RickRoll slashCommand;
    private SlashCommandInteractionEvent scRickRoll() {
        SlashCommandInteractionEvent event = mock(SlashCommandInteractionEvent.class);
        ReplyCallbackAction callback = mock(ReplyCallbackAction.class);
        when(event.getName()).thenReturn("icecream");
        String content = "TikToks that are straight bussin.\n<https://www.youtube.com/watch?v=dQw4w9WgXcQ>";
        when(event.reply(content)).thenReturn(callback);
        return event;
    }

    @Test
    public void testRickRoll1 (){
        slashCommand = new RickRoll();
        var event = scRickRoll();
        slashCommand.onSlashCommandInteraction(event);
        verify(event).reply("TikToks that are straight bussin.\n<https://www.youtube.com/watch?v=dQw4w9WgXcQ>");
    }

    @Test
    public void testRickRoll2 (){
        slashCommand = new RickRoll();
        var event = scRickRoll();
        slashCommand.onSlashCommandInteraction(event);
        verify(event, never()).reply("Something wrong.");
    }

    private SlashCommandInteractionEvent scNickname() {
        SlashCommandInteractionEvent event = mock(SlashCommandInteractionEvent.class);
        OptionMapping optionMapping = mock(OptionMapping.class);
        Member member = mock(Member.class);
        AuditableRestAction auditableRestAction = mock(AuditableRestAction.class);
        ReplyCallbackAction callback = mock(ReplyCallbackAction.class);

        String nickname = "bertANDernie";
        String content = "Your nickname on this server has been changed to: " + nickname;

        when(event.getName()).thenReturn("nickname");
        when(event.getOption("newname")).thenReturn(optionMapping);
        when(optionMapping.getAsString()).thenReturn(nickname);
        when(event.getMember()).thenReturn(member);
        when(member.modifyNickname(nickname)).thenReturn(auditableRestAction);
        when(event.reply(content)).thenReturn(callback);
        return event;
    }

    @Test
    public void testNickname1 (){
        slashCommand = new RickRoll();
        var event = scNickname();
        slashCommand.onSlashCommandInteraction(event);
        verify(event).reply("Your nickname on this server has been changed to: bertANDernie");
    }

    @Test
    public void testNickname2 (){
        slashCommand = new RickRoll();
        var event = scNickname();
        slashCommand.onSlashCommandInteraction(event);
        verify(event, never()).reply("Something wrong.");
    }

    /*private SlashCommandInteractionEvent scMonkeyText() {
        SlashCommandInteractionEvent event = mock(SlashCommandInteractionEvent.class);
        OptionMapping optionMapping = mock(OptionMapping.class);
        User user = mock(User.class);
        AuditableRestAction auditableRestAction = mock(AuditableRestAction.class);
        ReplyCallbackAction callback = mock(ReplyCallbackAction.class);
        CacheRestAction cacheRestAction = mock(CacheRestAction.class);
        PrivateChannel privateChannel = mock(PrivateChannel.class);
        RestAction restAction = mock(RestAction.class);
        WebhookMessageCreateAction webhookMessageCreateAction = mock(WebhookMessageCreateAction.class);
        MessageCreateAction messageCreateAction = mock(MessageCreateAction.class);

        String content = user.getName() + ", you've been monkeyed with! :speak_no_evil:";

        when(event.getName()).thenReturn("monkey");
        when(event.getOption("username")).thenReturn(optionMapping);
        when(optionMapping.getAsUser()).thenReturn(user);
        when(event.reply(content)).thenReturn(callback);
        when(user.openPrivateChannel()).thenReturn(cacheRestAction);
        when(cacheRestAction.flatMap(channel -> privateChannel.sendMessage(":hear_no_evil: Hey? Oh, hi! Hey. How are you?")))
                .thenReturn(restAction);
        return event;
    }

    @Test
    public void testMonkey1 (){
        slashCommand = new RickRoll();
        var event = scMonkeyText();
        slashCommand.onSlashCommandInteraction(event);
        verify(event, never()).reply("Something wrong.");
    }*/
}
