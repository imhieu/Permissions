package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankAddInheritanceEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private String inheritance;

    public RankAddInheritanceEvent(UUID uuid, String inheritance){
        this.uuid = uuid;
        this.inheritance = inheritance;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
