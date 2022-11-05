package alpha.rip.permissions.rank.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

@Getter
@Setter
public class RankUpdateSuffixEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private UUID uuid;
    private String suffix;

    public RankUpdateSuffixEvent(UUID uuid, String suffix){
        this.uuid = uuid;
        this.suffix = suffix;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
