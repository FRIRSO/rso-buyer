package si.fri.rso.projekt.buyers.services.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
@ConfigBundle("app-properties")
public class InfoProperties {

    @ConfigValue(value = "external-services.enabled", watch = true)
    private boolean externalServicesEnabled;

    @ConfigValue(watch = true)
    private boolean healthy;

    private String member1;

    public boolean isExternalServicesEnabled() {
        return externalServicesEnabled;
    }

    public void setExternalServicesEnabled(boolean externalServicesEnabled) {
        this.externalServicesEnabled = externalServicesEnabled;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }
}