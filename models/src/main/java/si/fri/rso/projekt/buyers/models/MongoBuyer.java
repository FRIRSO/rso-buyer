package si.fri.rso.projekt.buyers.models;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import si.fri.rso.projekt.buyers.models.configuration.DBProperties;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MongoBuyer {

    @Inject
    private DBProperties dbProperties;

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
                                    address);

            results.add(buyer);
        }

        return results;
    }

    public Buyer getBuyer(Integer buyerId) {
        MongoClient client = connectDB();
        MongoDatabase db = client.getDatabase(DBName);
        MongoCollection<Document> bc = db.getCollection("rso-buyers");

        Bson filter = Filters.eq("buyerId", buyerId);

        Document result = bc.find(filter).first();

        if(result == null) {
            return null;
        }

        Document addDoc = (Document) result.get("address");
        Address address = new Address(addDoc.getString("country"),
                addDoc.getString("city"),
                addDoc.getString("street"),
                addDoc.getInteger("streetNo"));

        return new Buyer(result.getInteger("buyerId"),
                result.getString("firstName"),
                result.getString("lastName"),
                address);
    }

    public void createBuyer(JSONObject json) {
        MongoClient client = connectDB();
        MongoDatabase db = client.getDatabase(DBName);
        MongoCollection<Document> bc = db.getCollection("rso-buyers");

        Document myDoc = bc.find().sort(new BasicDBObject("buyerId",-1)).first();
        int last = myDoc.getInteger("buyerId");

        Document doc = Document.parse(json.toString());
        doc.append("buyerId", last + 1);
        bc.insertOne(doc);
    }

    public void deleteBuyer(int buyerId) {
        MongoClient client = connectDB();
        MongoDatabase db = client.getDatabase(DBName);
        MongoCollection<Document> bc = db.getCollection("rso-buyers");

        Bson filter = Filters.eq("buyerId", buyerId);
        bc.deleteOne(filter);
    }
}
