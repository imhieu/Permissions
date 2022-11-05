package alpha.rip.permissions.listeners;

import alpha.rip.permissions.profile.events.ProfileCreateEvent;
import alpha.rip.permissions.profile.events.ProfileRemoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayersListener implements Listener {

    @EventHandler
    public void onAsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event){
        UUID uuid = event.getUniqueId();
        ProfileCreateEvent profileCreateEvent = new ProfileCreateEvent(uuid);
        Bukkit.getPluginManager().callEvent(profileCreateEvent);
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event){
        UUID uuid = event.getPlayer().getUniqueId();
        ProfileRemoveEvent profileRemoveEvent = new ProfileRemoveEvent(uuid);
        Bukkit.getPluginManager().callEvent(profileRemoveEvent);
    }

}
