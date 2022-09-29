package responder.prototype.listener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import responder.prototype.listener.InsultGenerator;

import javax.security.auth.login.LoginException;

public class Responder {
    private final Dotenv config;
    private final ShardManager shardManager;


    public Responder() throws LoginException{
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder= DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.listening("to your conversation"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.DIRECT_MESSAGES);
        shardManager = builder.build();
        shardManager.addEventListener(new InsultGenerator());

    }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args){

        try{
            Responder bot = new Responder();

        }catch (LoginException e){
            System.out.println("UH, invalid bot token");
        }

    }
}

