package alpha.rip.permissions.rank.events;

import alpha.rip.permissions.rank.Rank;
import alpha.rip.permissions.rank.RanksHandler;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankRemoveInheritanceEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private String inheritance;

    public RankRemoveInheritanceEvent(UUID uuid, String inheritance){
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
