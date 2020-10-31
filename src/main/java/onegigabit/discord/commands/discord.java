package onegigabit.discord.commands;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.types.PermissionNode;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import onegigabit.discord.Discord;
import java.io.IOException;

public class discord extends Command {
    public discord() {
        super("Discord");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            LuckPerms api = LuckPermsProvider.get();
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(args.length == 0) {
                p.sendMessage(new ComponentBuilder(Discord.configuration.getString("text").replace("&","§")).create());
            } else if(args[0].equals("reload") && sender.getPermissions().contains("discord.reload") || api.getGroupManager().getGroup(api.getPlayerAdapter(ProxiedPlayer.class).getUser(p).getPrimaryGroup()).getNodes().toString().contains("key=discord.reload, value=true")) {
                try {
                    Discord.reload();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.sendMessage(new ComponentBuilder(sender.getPermissions().toString()).create());
                p.sendMessage(new ComponentBuilder("Plugin reloaded successfully").create());
            }
        }
    }
}
