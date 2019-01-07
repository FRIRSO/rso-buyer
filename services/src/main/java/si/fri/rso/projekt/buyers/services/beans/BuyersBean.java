package si.fri.rso.projekt.buyers.services.beans;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.json.JSONArray;
import org.json.JSONObject;
import si.fri.rso.projekt.buyers.models.Buyer;
import si.fri.rso.projekt.buyers.models.MongoBuyer;
import si.fri.rso.projekt.buyers.services.configuration.InfoProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class BuyersBean {

    private Client httpClient;

    @Inject
    private InfoProperties infoProperties;

    @Inject
    private BuyersBean buyersBean;

    //private String billUrl = "http://localhost:8086";

    @Inject
    @DiscoverService("rso-bill")
    private Optional<String> baseUrlBill;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    public List<Buyer> allBuyers() {
        MongoBuyer mb = new MongoBuyer();

        return mb.getAllBuyers();
    }

    public Buyer getBuyer(Integer buyerId) {
        MongoBuyer mb = new MongoBuyer();

        Buyer buyer = mb.getBuyer(buyerId);

        if (buyerId == null) {
            return null;
        }

        return buyer;
    }

    public void createBuyer(JSONObject json) {
        MongoBuyer mb = new MongoBuyer();

        mb.createBuyer(json);
    }

    public void deleteBuyer(int buyerId) {
        MongoBuyer mb = new MongoBuyer();

        mb.deleteBuyer(buyerId);
    }

    public JSONObject getInfo() {
        JSONObject info = new JSONObject();
        info.put("clani", new JSONArray().put(infoProperties.getMember1()).put(infoProperties.getMember2()));
        info.put("mikrostoritve", new JSONArray().put(infoProperties.getServiceBuyer()).put(infoProperties.getServiceOrder()));
        info.put("github", new JSONArray().put(infoProperties.getGithubBuyer()).put(infoProperties.getGithubOrder()));
        info.put("travis", new JSONArray().put(infoProperties.getTravisBuyer()).put(infoProperties.getTravisOrder()));
        info.put("dockerhub", new JSONArray().put(infoProperties.getDockerBuyer()).put(infoProperties.getDockerOrder()));
        info.put("opis_projekta", infoProperties.getDescription());

        return info;
    }

    public String getMsg() {
        return "Buyers is working!";
    }

    public String getBillPrice(int orderID){
        System.out.printf("\n\n\n" + baseUrlBill.get() + "\n\n\n\n");
        if(!baseUrlBill.isPresent()) {
            try {
                String billResponse = httpClient.target(baseUrlBill.get() + "/v1/bills/" + orderID)
                                        .request()
                                        .accept(MediaType.APPLICATION_JSON)
                                        .get(String.class);

                JSONObject jsonResponse = new JSONObject(billResponse);

                double price = jsonResponse.getDouble("price");

                return "Price: " + price;
            }
            catch (WebApplicationException | ProcessingException e) {
                System.out.println("wrong");
            }
        }
        System.out.println("errror: sth went wring!");
        return "Sth went wrong!";
    }
}
