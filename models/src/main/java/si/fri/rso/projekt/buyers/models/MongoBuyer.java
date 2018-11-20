package si.fri.rso.projekt.buyers.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MongoBuyer {

    private final String DBUser       = "root";
    private final String DBPassword   = "13tpxnxJTwUScc3V";
    private final String DBName       = "rso-projekt";

    private MongoClient connectDB() {

        MongoClientURI uri = new MongoClientURI("mongodb://"+ DBUser +":"+ DBPassword +"@gsascluster-shard-00-00-ocnkx.azure.mongodb.net:27017," +
                "gsascluster-shard-00-01-ocnkx.azure.mongodb.net:27017,gsascluster-shard-00-02-ocnkx.azure.mongodb.net:27017/test?" +
                "ssl=true&replicaSet=gsasCluster-shard-0&authSource=admin&retryWrites=true");

        return new MongoClient(uri);
    }

    public List<Buyer> getAllBuyers() {
        MongoClient client = connectDB();

        MongoDatabase db = client.getDatabase(DBName);

        MongoCollection<Document> buyerCollection = db.getCollection("rso-buyers");

        List<Buyer> results = new ArrayList<>();

        for(Document curr : buyerCollection.find()) {

            Document addDoc = (Document) curr.get("address");
            Address address = new Address(addDoc.getString("country"),
                                        addDoc.getString("city"),
                                        addDoc.getString("street"),
                                        addDoc.getInteger("streetNo"));

            Buyer buyer = new Buyer(curr.getInteger("buyerId"),
                                    curr.getString("firstName"),
                                    curr.getString("lastName"),
                                    curr.getDate("DOB"),
                                    address);

            results.add(buyer);
        }

        return results;
    }
}
