package alpha.rip.permissions.grant.menus;

import alpha.rip.permissions.grant.Grant;
import alpha.rip.permissions.profile.Profile;
import alpha.rip.permissions.profile.ProfilesHandler;
import alpha.rip.permissions.rank.RanksHandler;
import io.github.damt.menu.buttons.Button;
import io.github.damt.menu.pagination.PaginatedMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class GrantMenu extends PaginatedMenu {

    public GrantMenu(Player player, String title, int size) {
        super(player, title, size);
    }

    @Override
    public Map<Integer, Button> getButtons() {
        final Map<Integer, Button> buttonMap = new HashMap<>();

        Profile profile = ProfilesHandler.getProfileByUUID(Bukkit.getPlayer(title).getUniqueId());

        for (Grant grant : profile.getGrants()){
            if (grant.getPardoned()){
                buttonMap.put(buttonMap.size(), new Button(new ItemStack(Material.BOOK))
                        .setLore(new String[]{
                                  "&c" + grant.getGrantDate(), "", "&eBy: " + Bukkit.getOfflinePlayer(grant.getGrantBy()).getName(), "&eRank: " + RanksHandler.getRankByUUID(grant.getGrantRank()).getName(), "&eReason: " + grant.getGrantReason(), "", "&ePardoned By: " + Bukkit.getOfflinePlayer(grant.getPardonedBy()).getName(), "&ePardoned Date: " + grant.getPardonedDate(), "&ePardoned Reason: " + grant.getPardonedReason()
                        }).setClickAction(event -> {
                            event.setCancelled(true);
                        }));
            } else {
                buttonMap.put(buttonMap.size(), new Button(new ItemStack(Material.BOOK))
                        .setLore(new String[]{
                                "&c" + grant.getGrantDate(), "", "&eBy: " + Bukkit.getOfflinePlayer(grant.getGrantBy()).getName(), "&eRank: " + RanksHandler.getRankByUUID(grant.getGrantRank()).getName(), "&eReason: " + grant.getGrantReason()
                        }).setClickAction(event -> {
                            event.setCancelled(true);
                        }));
            }
        }

        return buttonMap;
    }
}
