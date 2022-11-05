package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankUpdatePrefixEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private String prefix;

    public RankUpdatePrefixEvent(UUID uuid, String prefix){
        this.uuid = uuid;
        this.prefix = prefix;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
