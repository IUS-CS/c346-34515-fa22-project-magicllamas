package responder.prototype.listener;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

/**
 * This is similar to the main class. This is the executable run file for the bot
 */
public class Responder {
    private final Dotenv config;
    private final ShardManager shardManager;


    /**
     * This method holds permissions and token information for the specific bot.
     * @throws LoginException
     */
    public Responder() throws LoginException{
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder= DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.listening(" your conversation"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.DIRECT_MESSAGES);
        shardManager = builder.build();

        shardManager.addEventListener(new InsultGenerator(), new RickRoll(), new CurrentTime(), new CatSender());

    }

    /**
     * @return the configuration information of the bot
     */
    public Dotenv getConfig() {
        return config;
    }

    /**
     * @return takes care of shard
     */
    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {

        try {
            Responder bot = new Responder();

        } catch (LoginException e) {
            System.out.println("UH, invalid bot token");
        }
    }
}

