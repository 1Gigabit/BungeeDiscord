package onegigabit.discord.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import onegigabit.discord.Discord;

import java.io.IOException;

public class reloader extends Command {
    public reloader() {
        super("Discord reload");

    }
    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            try {
                Discord.reload();
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendMessage(new ComponentBuilder("Plugin Successfully reloaded").create());
        }
    }
}
