package alpha.rip.permissions.commands;

import alpha.rip.permissions.Locale;
import alpha.rip.permissions.rank.Rank;
import alpha.rip.permissions.rank.RanksHandler;
import alpha.rip.permissions.rank.events.RankUpdatePrefixEvent;
import alpha.rip.permissions.utilities.CC;
import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class RankUpdatePrefixCommand {

    @Command(names = {"rank prefix"}, permission = "*")
    public static void command(CommandSender sender, @Param(name = "name", required = true) String name, @Param(name = "prefix", required = true) String prefix){
        Rank rank = RanksHandler.getRankByName(name);
        if (rank == null){
            sender.sendMessage(Locale.CANNOT_FIND_RANK);
        } else {
            UUID uuid = rank.getUuid();
            RankUpdatePrefixEvent rankUpdatePrefixEvent = new RankUpdatePrefixEvent(uuid, prefix);
            Bukkit.getPluginManager().callEvent(rankUpdatePrefixEvent);
            sender.sendMessage(CC.translate("&7Successfully updated the prefix of the rank with the name &6" + name + "&7 to &6" + prefix + "&7."));
        }
    }

}
