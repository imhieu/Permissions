package alpha.rip.permissions.rank;

import alpha.rip.permissions.rank.events.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.UUID;

public class RankEventsListener implements Listener {

    @EventHandler
    public void onRankAddInheritanceEvent(RankAddInheritanceEvent event){
        UUID uuid = event.getUuid();
        String inheritance = event.getInheritance();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.getInheritances().add(inheritance);
    }

    @EventHandler
    public void onRankAddPermissionEvent(RankAddPermissionEvent event){
        UUID uuid = event.getUuid();
        String permission = event.getPermission();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.getPermissions().add(permission);
    }

    @EventHandler
    public void onRankCreateEvent(RankCreateEvent event){
        UUID uuid = event.getUuid();
        String name = event.getName();
        Rank rank = new Rank(uuid);
        rank.setName(name);
    }

    @EventHandler
    public void onRankRemoveEvent(RankRemoveEvent event){
        UUID uuid = event.getUuid();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        RanksHandler.getRanks().remove(rank);
    }

    @EventHandler
    public void onRankRemoveInheritanceEvent(RankRemoveInheritanceEvent event){
        UUID uuid = event.getUuid();
        String inheritance = event.getInheritance();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.getInheritances().remove(inheritance);
    }

    @EventHandler
    public void onRankRemovePermissionEvent(RankRemovePermissionEvent event){
        UUID uuid = event.getUuid();
        String permission = event.getPermission();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.getPermissions().remove(permission);
    }

    @EventHandler
    public void onRankUpdateInheritancesList(RankUpdateInheritancesListEvent event){
        UUID uuid = event.getUuid();
        List<String> inheritances = event.getInheritances();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.setInheritances(inheritances);
    }

    @EventHandler
    public void onRankUpdatePermissionsList(RankUpdatePermissionsListEvent event){
        UUID uuid = event.getUuid();
        List<String> permissions = event.getPermissions();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.setPermissions(permissions);
    }

    @EventHandler
    public void onRankUpdatePrefixEvent(RankUpdatePrefixEvent event){
        UUID uuid = event.getUuid();
        String prefix = event.getPrefix();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.setPrefix(prefix);
    }

    @EventHandler
    public void onRankUpdateSuffixEvent(RankUpdateSuffixEvent event){
        UUID uuid = event.getUuid();
        String suffix = event.getSuffix();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.setSuffix(suffix);
    }

    @EventHandler
    public void onRankUpdateWeightEvent(RankUpdateWeightEvent event){
        UUID uuid = event.getUuid();
        Integer weight = event.getWeight();
        Rank rank = RanksHandler.getRankByUUID(uuid);
        rank.setWeight(weight);
    }

}
