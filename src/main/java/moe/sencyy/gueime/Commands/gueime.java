package moe.sencyy.gueime.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class gueime extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("gueime")) {
            OptionMapping option = event.getOption("gueime");
            String whoisGueime = option.getAsString();

            event.reply(whoisGueime + " ser um gueime").queue();

        }
    }
}
