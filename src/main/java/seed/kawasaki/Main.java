package seed.kawasaki;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

public class Main extends ListenerAdapter {
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("MTAxMTUwMDkzMTczODc3NTU5Mg.GHEhwk.bxTwjwJV7ayHJat5iNODyCWKgWCDLrj2dgBYQ8")
                .addEventListeners(new Main())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Logged In");
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }
        String[] args = event.getMessage().getContentRaw().split(" ");
        String command = args[0];
        if(!command.startsWith("!")) {
            return;
        }
        command = command.replace("!", "");
        if(command.equalsIgnoreCase("help")) {
            event.getMessage().reply("There is nothing.").queue();
        } else if(command.equalsIgnoreCase("test")) {
            event.getMessage().reply("This is just a test command.").queue();
        } else {
            event.getMessage().reply("The command is wrong. Are you too incompetent to write the correct syntax?").queue();
        }
    }
}
