package alpha.rip.permissions.mongo.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter @Setter
public class CreateConnectionEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private String host, database;
    private Integer port;

    public CreateConnectionEvent(String host, Integer port, String database){
        this.host = host;
        this.port = port;
        this.database = database;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
