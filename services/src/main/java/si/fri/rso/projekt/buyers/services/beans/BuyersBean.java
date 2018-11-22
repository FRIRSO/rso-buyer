package si.fri.rso.projekt.buyers.services.beans;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.json.JSONObject;
import si.fri.rso.projekt.buyers.models.Buyer;
import si.fri.rso.projekt.buyers.models.MongoBuyer;
import si.fri.rso.projekt.buyers.services.configuration.InfoProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class BuyersBean {

    private Client httpClient;

    @Inject
    private InfoProperties infoProperties;

    @Inject
    private BuyersBean buyersBean;

    //@Inject
    //@DiscoverService("rso-orderes")
    //private Optional<String> baseUrl;

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

        if(buyerId == null) {
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

    public void getInfo() {
        String desc = infoProperties.getMember1();

        System.out.println("test");
    }
}
