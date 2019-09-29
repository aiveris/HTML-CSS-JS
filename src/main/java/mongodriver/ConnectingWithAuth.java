package mongodriver;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConnectingWithAuth {

    public static void main(String[] args) {

        // 1. Get all database names (with credentials, with Default Authentication Mechanism)'
        // Create the admin user using CLI:
        // ... C:\Program Files\MongoDB\Server\4.2\bin>mongo
        // db.createUser(
        //   {
        //         user: "root",
        //         pwd: "root",
        //         roles: [ { role: "root", db: "admin" } ]
        //   }
        // )
        //
        // db.grantRolesToUser("root",[{ role: "userAdminAnyDatabase", db: "admin" }])

        // "C:\Program Files\MongoDB\Server\4.2\bin\mongod.cfg"
        // security:
        //     authorization: "disabled"
        // ref: https://medium.com/mongoaudit/how-to-enable-authentication-on-mongodb-b9e8a924efac
        // don't get caught in this: https://stackoverflow.com/questions/23943651/mongodb-admin-user-not-authorized

        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        MongoDatabase dbAdmin = mongoClientWithAuth.getDatabase("admin");

        // Get all collection names to verify connectivity
        MongoIterable<String> adminCollections = dbAdmin.listCollectionNames();
        adminCollections.forEach((Consumer<? super String>) System.out::println);

        mongoClientWithAuth.close();
    }

}
