package alpha.rip.permissions.profile;

import alpha.rip.permissions.Permissions;
import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.UUID;

public class ProfilesHandler {

    @Getter
    public static ArrayList<Profile> profiles = new ArrayList<>();

    @Getter
    public static MongoCollection<Document> profilesCollection = Permissions.getMongoDatabase().getCollection("Profiles");

    public static Profile getProfileByUUID(UUID uuid){
        for (Profile profile : profiles){
            if (profile.getUuid().equals(uuid)){
                return profile;
            }
        } return null;
    }

}
