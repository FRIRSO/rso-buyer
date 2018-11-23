package si.fri.rso.projekt.buyers.models.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("db-properties")
public class DBProperties {


    private String dbUser;

    private String dbPass;

    private String dbName;

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getdbName() {
        return dbName;
    }

    public void setdbName(String dbName) {
        this.dbName = dbName;
    }
}
