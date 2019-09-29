package mongodriver;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

import java.util.function.Consumer;

public class ConnectingWithoutAuth {

    // If you will need to configure logging:
    // ... mongo will use slf4j if it can find it, else will default to JUL (java.util.logging).
    // ... ref: https://mongodb.github.io/mongo-java-driver/3.11/
    // ... non slf4j: https://stackoverflow.com/a/12394790/1964707
    // ... slf4j: https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html

    public static void main(String[] args) {
        // 0. Connecting to the mongo server
        // "C:\Program Files\MongoDB\Server\4.2\bin\mongod.cfg" --> edit the config to disable the authentication
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Get all database names to verify connectivity
        MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
        dbNames.forEach((Consumer<? super String>) System.out::println);
        mongoClient.close();
    }
}