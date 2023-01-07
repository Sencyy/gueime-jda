package moe.sencyy.gueime.Interactions;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class join extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        Dotenv dotenv = Dotenv.load();
        String announceChannel = dotenv.get("ANNOUNCE_CHANNEL");
        String user = event.getUser().getAsMention();
        JDA client = event.getJDA();

        TextChannel channel = client.getTextChannelById(announceChannel);

        channel.sendMessage(user + " virou um gueime").queue();


    }
}
