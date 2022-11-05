package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RankUpdatePermissionsListEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private List<String> permissions;

    public RankUpdatePermissionsListEvent(UUID uuid, List<String> permissions){
        this.uuid = uuid;
        this.permissions = permissions;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
