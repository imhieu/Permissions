package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankCreateEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private String name;

    public RankCreateEvent(UUID uuid, String name){
        this.uuid = uuid;
        this.name = name;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
