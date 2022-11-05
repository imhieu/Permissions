package alpha.rip.permissions.rank;

import alpha.rip.permissions.Permissions;
import alpha.rip.permissions.rank.events.*;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RanksHandler {

    @Getter
    public static ArrayList<Rank> ranks = new ArrayList<>();

    @Getter
    public static MongoCollection<Document> ranksCollection = Permissions.getMongoDatabase().getCollection("Ranks");

    public static Rank getRankByName(String name){
        for (Rank rank : ranks){
            if (rank.getName().equals(name)){
                return rank;
            }
        }
        return null;
    }

    public static Rank getRankByUUID(UUID uuid){
        for (Rank rank : ranks){
            if (rank.getUuid().equals(uuid)){
                return rank;
            }
        }
        return null;
    }

    public static void loadRanks(){
        RanksHandler.getRanksCollection().find().forEach((Block<? super Document>) document -> {
            String name = document.getString("name");
            UUID uuid = UUID.fromString(document.getString("uuid"));
            String prefix = document.getString("prefix");
            String suffix = document.getString("suffix");
            Integer weight = document.getInteger("weight");
            List<String> inheritances = document.getList("inheritances", String.class);
            List<String> permissions = document.getList("permissions", String.class);

            RankCreateEvent rankCreateEvent = new RankCreateEvent(uuid, name);
            Bukkit.getPluginManager().callEvent(rankCreateEvent);

            RankUpdatePrefixEvent rankUpdatePrefixEvent = new RankUpdatePrefixEvent(uuid, prefix);
            Bukkit.getPluginManager().callEvent(rankUpdatePrefixEvent);

            RankUpdateSuffixEvent rankUpdateSuffixEvent = new RankUpdateSuffixEvent(uuid, suffix);
            Bukkit.getPluginManager().callEvent(rankUpdateSuffixEvent);

            RankUpdateWeightEvent rankUpdateWeightEvent = new RankUpdateWeightEvent(uuid, weight);
            Bukkit.getPluginManager().callEvent(rankUpdateWeightEvent);

            RankUpdateInheritancesListEvent rankUpdateInheritancesListEvent = new RankUpdateInheritancesListEvent(uuid, inheritances);
            Bukkit.getPluginManager().callEvent(rankUpdateInheritancesListEvent);

            RankUpdatePermissionsListEvent rankUpdatePermissionsListEvent = new RankUpdatePermissionsListEvent(uuid, permissions);
            Bukkit.getPluginManager().callEvent(rankUpdatePermissionsListEvent);
        });
        if (ranks.size() == 0){
            RankCreateEvent rankCreateEvent = new RankCreateEvent(UUID.randomUUID(), "Default");
            Bukkit.getPluginManager().callEvent(rankCreateEvent);

            Rank rank = RanksHandler.getRankByName("Default");

            RankUpdatePrefixEvent rankUpdatePrefixEvent = new RankUpdatePrefixEvent(rank.getUuid(), "&a");
            Bukkit.getPluginManager().callEvent(rankUpdatePrefixEvent);

            rank.save();
        }
    }

}
