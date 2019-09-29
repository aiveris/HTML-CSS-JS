package mongodriver;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.function.Consumer;

public class WorkingWDocsNoAuth {

    public static void main(String[] args) throws InterruptedException {
        // 0. Create the client and establish the connection
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // 1. Create or select a collection and database
        MongoCollection coll = mongoClient
                .getDatabase("customer_db").getCollection("customer_coll");

        // 2. Create a document
        Document document = new Document()
                .append("name", "Mindaugas")
                .append("middle name", "Jonas")
                .append("surname", "Bernatavičius");

        // 3. insert the document to the collection
        coll.insertOne(document);

        // 4. Wait a bit, inspect what was inserted
        Thread.sleep(5000);

        // 5. Edit the document that was created just now
        // db.products.update({ _id: 100 },
        //    { $set:
        //       {
        //         quantity: 500,
        //         details: { model: "14Q3", make: "xyz" },
        //         tags: [ "coats", "outerwear", "clothing" ]
        //       }
        //    }
        // )
        BasicDBObject searchQuery = (new BasicDBObject()).append("name", "Mindaugas");
        coll.updateOne(searchQuery, new Document("$set", new Document("middle name", "Jonas")));
        coll.updateOne(searchQuery, new Document("$set", new Document("surname", "Jonaitis")));

        mongoClient.close();
    }
}