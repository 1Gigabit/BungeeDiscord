package onegigabit.discord.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import onegigabit.discord.Discord;
public class discord extends Command {
    public discord() {
        super("Discord");

    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            p.sendMessage(new ComponentBuilder(Discord.configuration.getString("text").replace("&","§")).create());
        }
    }
}
