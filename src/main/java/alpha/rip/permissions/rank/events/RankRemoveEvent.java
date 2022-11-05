package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankRemoveEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;

    public RankRemoveEvent(UUID uuid){
        this.uuid = uuid;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
