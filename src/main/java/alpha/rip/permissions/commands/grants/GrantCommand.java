package alpha.rip.permissions.commands;

import alpha.rip.permissions.grant.Grant;
import alpha.rip.permissions.grant.events.GrantCreateEvent;
import alpha.rip.permissions.profile.Profile;
import alpha.rip.permissions.profile.ProfilesHandler;
import alpha.rip.permissions.profile.events.ProfileAddGrantEvent;
import alpha.rip.permissions.rank.Rank;
import alpha.rip.permissions.rank.RanksHandler;
import alpha.rip.permissions.utilities.CC;
import alpha.rip.permissions.utilities.DateUtility;
import com.mongodb.client.model.Filters;
import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GrantCommand {

    @Command(names = {"grant"}, permission = "*")
    public static void command(CommandSender sender, @Param(name = "player") String player, @Param(name = "rank") String rank, @Param(name = "reason", concated = true) String reason){
        UUID playerUUID = Bukkit.getPlayer(player).getUniqueId();
        Rank grantRank = RanksHandler.getRankByName(rank);
        Profile profile = ProfilesHandler.getProfileByUUID(playerUUID);

        Player commandSender = (Player) sender;
        GrantCreateEvent grantCreateEvent;
        UUID randomUUID = UUID.randomUUID();
        if (commandSender == null){
            grantCreateEvent = new GrantCreateEvent(profile.getUuid(), randomUUID, DateUtility.getCurrentDate(), randomUUID, grantRank.getUuid(), reason, false, commandSender.getUniqueId(), DateUtility.getCurrentDate(), "NONE");
        } else {
            grantCreateEvent = new GrantCreateEvent(profile.getUuid(), randomUUID, DateUtility.getCurrentDate(), commandSender.getUniqueId(), grantRank.getUuid(), reason, false, commandSender.getUniqueId(), DateUtility.getCurrentDate(), "NONE");
        }
        Bukkit.getPluginManager().callEvent(grantCreateEvent);

        sender.sendMessage(CC.translate("&7Successfully granted a player with the name &a" + player + "&7 with the rank named &r" + grantRank.getColour() + grantRank.getName() + "&7."));

    }

}
