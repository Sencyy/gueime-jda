package moe.sencyy.gueime.Interactions;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class bueneime extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String messageContent = event.getMessage().getContentRaw();
        TextChannel messageChannel = event.getChannel().asTextChannel();

        if (!event.getAuthor().isBot()) {
            if (messageContent.equals("buenias noitches")) {
                messageChannel.sendMessage("bueneime").queue();
            }
        }
    }
}
