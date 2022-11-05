package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankUpdateWeightEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private Integer weight;

    public RankUpdateWeightEvent(UUID uuid, Integer weight){
        this.uuid = uuid;
        this.weight = weight;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
