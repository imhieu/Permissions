package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankAddPermissionEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private String permission;

    public RankAddPermissionEvent(UUID uuid, String permission){
        this.uuid = uuid;
        this.permission = permission;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
