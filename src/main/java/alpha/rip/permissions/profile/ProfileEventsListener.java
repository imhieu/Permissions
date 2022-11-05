package alpha.rip.permissions.profile;

import alpha.rip.permissions.profile.Profile;
import alpha.rip.permissions.profile.ProfilesHandler;
import alpha.rip.permissions.profile.events.ProfileCreateEvent;
import alpha.rip.permissions.profile.events.ProfileRemoveEvent;
import alpha.rip.permissions.profile.events.ProfileUpdateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class ProfileEventsListener implements Listener {

    @EventHandler
    public void onProfileCreateEvent(ProfileCreateEvent event){
        UUID uuid = event.getUuid();
        Profile profile = new Profile(uuid);
        ProfilesHandler.getProfiles().add(profile);
        profile.load();
    }

    @EventHandler
    public void onProfileRemoveEvent(ProfileRemoveEvent event){
        UUID uuid = event.getUuid();
        Profile profile = ProfilesHandler.getProfileByUUID(uuid);
        profile.save();
        ProfilesHandler.getProfiles().remove(profile);
    }

    @EventHandler
    public void onProfileUpdateEvent(ProfileUpdateEvent event){
        UUID uuid = event.getProfile();
        UUID rank = event.getRank();
        Profile profile = ProfilesHandler.getProfileByUUID(uuid);
        profile.setRank(rank);
        profile.save();
        profile.load();
    }

}
