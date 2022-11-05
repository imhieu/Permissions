package alpha.rip.permissions.mongo;

import alpha.rip.permissions.Permissions;
import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;

public class MongoConnection {

    @Getter public static String host = "localhost";
    @Getter public static Integer port = 27017;
    @Getter public static String database = "Permissions";

}
