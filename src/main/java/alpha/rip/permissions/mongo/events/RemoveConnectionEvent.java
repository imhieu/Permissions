package alpha.rip.permissions.mongo.events;

import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter @Setter
public class RemoveConnectionEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private MongoDatabase mongoDatabase;

    public RemoveConnectionEvent(MongoDatabase mongoDatabase){
        this.mongoDatabase = mongoDatabase;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
