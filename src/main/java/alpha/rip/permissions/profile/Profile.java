package alpha.rip.permissions.profile;

import alpha.rip.permissions.Permissions;
import alpha.rip.permissions.mongo.MongoConnection;
import alpha.rip.permissions.rank.Rank;
import alpha.rip.permissions.rank.RanksHandler;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Profile {

    private UUID uuid;
    private UUID rank;

    private Boolean existsInDatabase;

    private List<String> totalPermissions;

    public Profile(UUID uuid){
        this.uuid = uuid;
        this.rank = null;

        existsInDatabase = false;

        totalPermissions = new ArrayList<>();

        ProfilesHandler.getProfiles().add(this);
    }

    public void recalculatePlayerPermissions(){
        for (PermissionAttachmentInfo attachmentInfo : Bukkit.getPlayer(uuid).getEffectivePermissions()) {
            if (attachmentInfo.getAttachment() == null || attachmentInfo.getAttachment().getPlugin() == null ||
                    !attachmentInfo.getAttachment().getPlugin().equals(Permissions.getInstance())) {
                continue;
            }

            attachmentInfo.getAttachment().getPermissions().forEach((permission, value) -> {
                attachmentInfo.getAttachment().unsetPermission(permission);
            });
        }

        PermissionAttachment attachment = Bukkit.getPlayer(uuid).addAttachment(Permissions.getInstance());

        for (String permission : totalPermissions) {
            attachment.setPermission(permission, true);
        }
        Bukkit.getPlayer(uuid).recalculatePermissions();
    }

    public void load(){
        Document document = ProfilesHandler.getProfilesCollection().find(Filters.eq("uuid", uuid.toString())).first();
        if (document == null){
            Rank defaultRank = RanksHandler.getRankByName("Default");
            setRank(defaultRank.getUuid());
            save();
        } else {
            existsInDatabase = true;
            UUID rankUUID = UUID.fromString(document.getString("rank"));
            setRank(rankUUID);
            Rank profileRank = RanksHandler.getRankByUUID(rankUUID);

            totalPermissions.clear();

            for (String eachUUID : profileRank.getInheritances()){
                Rank rank = RanksHandler.getRankByUUID(UUID.fromString(eachUUID));
                totalPermissions.addAll(rank.getPermissions());
            }

            totalPermissions.addAll(profileRank.getPermissions());
        }
    }

    public void save(){
        Document document = new Document();
        document.put("uuid", uuid.toString());
        document.put("rank", rank.toString());

        ProfilesHandler.getProfilesCollection().replaceOne(Filters.eq("uuid", uuid.toString()), document, new ReplaceOptions().upsert(true));
    }

}
