package alpha.rip.permissions.commands;

import alpha.rip.permissions.utilities.CC;
import com.jonahseguin.drink.annotation.Command;
import com.jonahseguin.drink.annotation.Require;
import com.jonahseguin.drink.annotation.Sender;
import org.bukkit.command.CommandSender;

public class RankCommands {

    @Command(name = "rank", aliases = "rank help", desc = "")
    @Require("*")
    public void help(@Sender CommandSender sender){
        sender.sendMessage(CC.translate("&e&m-------------------&r &6&lRank &e&m-------------------"));
        sender.sendMessage(CC.translate("&bRank:"));
        sender.sendMessage(CC.translate("&6/rank create <name> &7- Creates a new rank."));
        sender.sendMessage(CC.translate("&6/rank prefix <name> <prefix> &7- Updates a rank's prefix."));
        sender.sendMessage(CC.translate("&6/rank suffix <name> <prefix> &7- Updates a rank's prefix."));
        sender.sendMessage(CC.translate("&6/rank weight <name> <weight> &7- Updates a rank's weight."));
        sender.sendMessage(CC.translate("&bInheritance:"));
        sender.sendMessage(CC.translate("&6/rank inherit <parent> <child> &7- Adds an inheritance to a parent rank."));
        sender.sendMessage(CC.translate("&6/rank uninherit <parent> <child> &7- Removes an inheritance of a parent rank."));
        sender.sendMessage(CC.translate("&bPermission:"));
        sender.sendMessage(CC.translate("&6/rank addperm <name> <permission> &7- Adds a permission to a rank."));
        sender.sendMessage(CC.translate("&6/rank removeperm <name> <permission> &7- Removes a permission from a rank."));
        sender.sendMessage(CC.translate("&e&m--------------------------------------------"));
    }

}
