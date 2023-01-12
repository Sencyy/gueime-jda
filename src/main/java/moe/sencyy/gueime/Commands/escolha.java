package moe.sencyy.gueime.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class escolha extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("escolha")) {

            OptionMapping option1 = event.getOption("escolha1");
            OptionMapping option2 = event.getOption("escolha2");

            String escolha1 = option1.getAsString();
            String escolha2 = option2.getAsString();

            event.reply("Entre " + escolha1 + " e " + escolha2).queue();

            Random rand = new Random();
            int answerNumber = rand.nextInt(2);
            String answer = "";

            if (answerNumber == 0) {
                answer = escolha1;
            } else if (answerNumber == 1) {
                answer = escolha2;
            }

            event.getChannel().asTextChannel().sendMessage("mim escolher " + answer).queue();

        }
    }
}
