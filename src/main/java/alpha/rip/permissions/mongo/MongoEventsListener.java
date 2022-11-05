package alpha.rip.permissions.mongo;

import alpha.rip.permissions.Permissions;
import alpha.rip.permissions.mongo.events.CreateConnectionEvent;
import alpha.rip.permissions.mongo.events.RemoveConnectionEvent;
import alpha.rip.permissions.utilities.CC;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MongoEventsListener implements Listener {

    @Getter
    public static MongoDatabase mongoDatabase;

    @EventHandler
    public void onCreateConnectionEvent(CreateConnectionEvent event){
        String host = event.getHost();
        Integer port = event.getPort();
        String database = event.getDatabase();
        mongoDatabase = new MongoClient(host, port).getDatabase(database);
        Permissions.mongoDatabase = mongoDatabase;
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aSuccessfully established a connection to the mongo database."));
    }

    @EventHandler
    public void onRemoveConnectionEvent(RemoveConnectionEvent event){
        MongoDatabase mongoDatabase = event.getMongoDatabase();
        mongoDatabase.drop();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&cSuccessfully paused the connection to the mongo database."));
    }

}
