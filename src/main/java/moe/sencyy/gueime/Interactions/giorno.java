package moe.sencyy.gueime.Interactions;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class giorno extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equals("buenios giornos")) {
            event.getChannel().asTextChannel().sendMessage("bueneime").queue();
        }


    }
}
