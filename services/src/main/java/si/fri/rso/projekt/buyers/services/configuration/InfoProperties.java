package si.fri.rso.projekt.buyers.services.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
@ConfigBundle("info-properties")
public class InfoProperties {

//    @ConfigValue(value = "external-services.enabled", watch = true)
//    private boolean externalServicesEnabled;
//
//    @ConfigValue(watch = true)
//    private boolean healthy;

    private String member1;
    private String member2;
    private String description;
    private String serviceBuyer;
    private String serviceOrder;
    private String githubBuyer;
    private String githubOrder;
    private String travisBuyer;
    private String travisOrder;
    private String dockerBuyer;
    private String dockerOrder;


//    public boolean isExternalServicesEnabled() {
//        return externalServicesEnabled;
//    }
//
//    public void setExternalServicesEnabled(boolean externalServicesEnabled) {
//        this.externalServicesEnabled = externalServicesEnabled;
//    }
//
//    public boolean isHealthy() {
//        return healthy;
//    }
//
//    public void setHealthy(boolean healthy) {
//        this.healthy = healthy;
//    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceBuyer() {
        return serviceBuyer;
    }

    public void setServiceBuyer(String serviceBuyer) {
        this.serviceBuyer = serviceBuyer;
    }

    public String getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(String serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public String getGithubBuyer() {
        return githubBuyer;
    }

    public void setGithubBuyer(String githubBuyer) {
        this.githubBuyer = githubBuyer;
    }

    public String getGithubOrder() {
        return githubOrder;
    }

    public void setGithubOrder(String githubOrder) {
        this.githubOrder = githubOrder;
    }

    public String getTravisBuyer() {
        return travisBuyer;
    }

    public void setTravisBuyer(String travisBuyer) {
        this.travisBuyer = travisBuyer;
    }

    public String getTravisOrder() {
        return travisOrder;
    }

    public void setTravisOrder(String travisOrder) {
        this.travisOrder = travisOrder;
    }

    public String getDockerBuyer() {
        return dockerBuyer;
    }

    public void setDockerBuyer(String dockerBuyer) {
        this.dockerBuyer = dockerBuyer;
    }

    public String getDockerOrder() {
        return dockerOrder;
    }

    public void setDockerOrder(String dockerOrder) {
        this.dockerOrder = dockerOrder;
    }
}