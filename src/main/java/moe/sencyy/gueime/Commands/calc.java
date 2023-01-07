package moe.sencyy.gueime.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class calc extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("calc")) {

            OptionMapping num1 = event.getOption("num1");
            OptionMapping sinal = event.getOption("sinal");
            OptionMapping num2 = event.getOption("num2");

            int firstNumber = num1.getAsInt();
            int secondNumber = num2.getAsInt();
            String operator = sinal.getAsString();
            String result = "";

            if (operator.equals("+")) {
                int tempResult = firstNumber + secondNumber;
                result = Integer.toString(tempResult);
                event.reply(Integer.toString(firstNumber) + " - " + Integer.toString(secondNumber) + "=" + result).queue();
            } else if (operator.equals("-")) {
                int tempResult = firstNumber - secondNumber;
                result = Integer.toString(tempResult);
                event.reply(Integer.toString(firstNumber) + " - " + Integer.toString(secondNumber) + "=" + result).queue();
            } else if (operator.equals("x")) {
                int tempResult = firstNumber * secondNumber;
                result = Integer.toString(tempResult);
                event.reply(Integer.toString(firstNumber) + " x " + Integer.toString(secondNumber) + " = " + result).queue();
            } else if (operator.equals("/")) {
                int tempResult = firstNumber / secondNumber;
                result = Integer.toString(tempResult);
                event.reply(Integer.toString(firstNumber) + " / " + Integer.toString(secondNumber) + " = " + result).queue();
            } else {
                result = "Operador Inválido!";
                event.reply(result).setEphemeral(true).queue();
            }


        }

    }
}
