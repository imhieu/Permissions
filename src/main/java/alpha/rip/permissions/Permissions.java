package alpha.rip.permissions;

import alpha.rip.permissions.listeners.PlayersListener;
import alpha.rip.permissions.mongo.MongoEventsListener;
import alpha.rip.permissions.mongo.MongoConnection;
import alpha.rip.permissions.mongo.events.CreateConnectionEvent;
import alpha.rip.permissions.mongo.events.RemoveConnectionEvent;
import alpha.rip.permissions.profile.ProfileEventsListener;
import alpha.rip.permissions.rank.RankEventsListener;
import alpha.rip.permissions.rank.RanksHandler;
import alpha.rip.permissions.utilities.CC;
import com.jonahseguin.drink.CommandService;
import com.jonahseguin.drink.Drink;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Permissions extends JavaPlugin {

    @Getter
    public static Permissions instance;

    @Getter
    public static MongoDatabase mongoDatabase;

    @Override
    public void onEnable() {
        instance = this;
        registerListeners();
        setupMongo();
        registerCommands();
        RanksHandler.loadRanks();
    }

    public void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new PlayersListener(), this);
        Bukkit.getPluginManager().registerEvents(new MongoEventsListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProfileEventsListener(), this);
        Bukkit.getPluginManager().registerEvents(new RankEventsListener(), this);
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aSuccessfully registered all server listeners."));
    }

    public void registerCommands(){
        CommandService drink = Drink.get(this);
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aSuccessfully registered all server commands."));
    }

    public void setupMongo(){
        CreateConnectionEvent createConnectionEvent = new CreateConnectionEvent(MongoConnection.getHost(), MongoConnection.getPort(), MongoConnection.getDatabase());
        Bukkit.getPluginManager().callEvent(createConnectionEvent);
    }

    public void destroyMongo(){
        RemoveConnectionEvent removeConnectionEvent = new RemoveConnectionEvent(MongoEventsListener.getMongoDatabase());
        Bukkit.getPluginManager().callEvent(removeConnectionEvent);
    }

    @Override
    public void onDisable() {
        destroyMongo();
    }
}
