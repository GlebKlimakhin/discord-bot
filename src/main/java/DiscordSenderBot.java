import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

public class DiscordSenderBot extends ListenerAdapter {
    public static void main(String[] args) throws Exception{
        JDA bot = JDABuilder.createDefault("")
                .setActivity(Activity.listening("MGMT - Little Dark Age"))
                .disableCache(CacheFlag.ACTIVITY, CacheFlag.EMOTE, CacheFlag.ONLINE_STATUS, CacheFlag.VOICE_STATE, CacheFlag.EMOTE)
                .addEventListeners(new DiscordSenderBot())
                .build();

    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent ev) {
        if(ev.getAuthor().getAsTag().equals("coldrii | LonelyPop#5463")) {
            if (ev.getMessage().getContentRaw().contains("color")) {
                ev.getTextChannel().sendMessage("pink").queue();
            }
        }
    }

    @Override
    public void onHttpRequest(@NotNull HttpRequestEvent event) {
        super.onHttpRequest(event);
    }
}
