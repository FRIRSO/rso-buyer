package si.fri.rso.projekt.buyers.api.v1.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped

//dev->1.0->config->rest-properties->healthy-> enabled : true / false
@ConfigBundle("rest-properties")
public class RestProperties {
    @ConfigValue(value = "faultTolerance.enabled", watch = true)
    private boolean faultTolerance;

    public boolean isFaultTolerance() {
        return faultTolerance;
    }

    public void setFaultTolerance(boolean healthy) {
        this.faultTolerance = healthy;
    }
}
