package si.fri.rso.projekt.buyers.services.beans;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import si.fri.rso.projekt.buyers.services.configuration.AppProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Optional;

@RequestScoped
public class BuyersBean {

    private Client httpClient;

    //@Inject
    //private AppProperties appProperties;

    //@Inject
    //private BuyersBean buyersBean;

    //@Inject
    //@DiscoverService("rso-orderes")
    //private Optional<String> baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }
}
