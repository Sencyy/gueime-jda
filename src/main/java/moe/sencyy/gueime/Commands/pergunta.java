package moe.sencyy.gueime.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.Random;

public class pergunta extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("pergunta")) {

            String userWhoRequested = event.getUser().getName();
            OptionMapping option = event.getOption("pergunta");
            String pergunta = option.getAsString();

            event.reply(userWhoRequested + " perguntou: " + pergunta).queue();

            Random rand = new Random();
            int answerNumber = rand.nextInt(2);
            String resposta = "";

            if (answerNumber == 0) {
                resposta = "sim";
            } else if (answerNumber == 1) {
                resposta = "não";
            }

            event.getChannel().asTextChannel().sendMessage("eu acho que " + resposta).queue();

        }
    }
}
