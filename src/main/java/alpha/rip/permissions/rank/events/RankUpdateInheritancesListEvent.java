package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RankUpdateInheritancesListEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private List<String> inheritances;

    public RankUpdateInheritancesListEvent(UUID uuid, List<String> inheritances){
        this.uuid = uuid;
        this.inheritances = inheritances;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
