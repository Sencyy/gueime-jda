package moe.sencyy.gueime;

import io.github.cdimascio.dotenv.Dotenv;
import moe.sencyy.gueime.Commands.calc;
import moe.sencyy.gueime.Commands.gueime;
import moe.sencyy.gueime.Commands.pergunta;
import moe.sencyy.gueime.Interactions.bueneime;
import moe.sencyy.gueime.Interactions.join;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;





public class Main extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");
        long devGuild = Long.parseLong(dotenv.get("GUILD_ID"));

        JDA bot = JDABuilder.createDefault(token)
                .setActivity(Activity.playing("sexo 2 the game"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new bueneime())
                .addEventListeners(new gueime())
                .addEventListeners(new calc())
                .addEventListeners(new join())
                .addEventListeners(new pergunta())
                .build().awaitReady();

        // Declaring slash commands
        Guild guild = bot.getGuildById(devGuild);

        if (guild != null) {
            guild.upsertCommand("gueime", "vose gueime")
                    .addOption(OptionType.STRING, "gueime", "quem e gueime", true)
                    .queue();

            guild.upsertCommand("calc", "calculadora gueime")
                    .addOption(OptionType.INTEGER, "num1", "numero 1", true)
                    .addOption(OptionType.STRING, "sinal", "sinal de mais menos etc", true)
                    .addOption(OptionType.INTEGER, "num2", "numero 2", true)
                    .queue();

            guild.upsertCommand("pergunta", "faça uma pergunta ao bot")
                    .addOption(OptionType.STRING, "pergunta", "sua pergunta", true)
                    .queue();
        } else {
            System.out.println("ERROR: Invalid guild ID!");
        }



    }


}
