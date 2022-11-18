package alpha.rip.permissions.profile.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class ProfileUpdateEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID profile;
    private UUID rank;

    public ProfileUpdateEvent(UUID profile, UUID rank){
        this.profile = profile;
        this.rank = rank;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
