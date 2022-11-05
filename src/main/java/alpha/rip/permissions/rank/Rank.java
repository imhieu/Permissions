package alpha.rip.permissions.rank;

import alpha.rip.permissions.profile.ProfilesHandler;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Rank {

    private UUID uuid;
    private String name;
    private String prefix;
    private String suffix;
    private Integer weight;
    private List<String> inheritances;
    private List<String> permissions;

    public Rank(UUID uuid){
        this.uuid = uuid;
        this.name = "";
        this.prefix = "";
        this.suffix = "";
        this.weight = 0;
        this.inheritances = new ArrayList<>();
        this.permissions = new ArrayList<>();

        RanksHandler.getRanks().add(this);
    }

    public void save(){
        Document document = new Document();
        document.put("uuid", uuid.toString());
        document.put("name", name);
        document.put("prefix", prefix);
        document.put("suffix", suffix);
        document.put("weight", weight);
        document.put("inheritances", inheritances);
        document.put("permissions", permissions);

        RanksHandler.getRanksCollection().replaceOne(Filters.eq("uuid", uuid.toString()), document, new ReplaceOptions().upsert(true));
    }

}
