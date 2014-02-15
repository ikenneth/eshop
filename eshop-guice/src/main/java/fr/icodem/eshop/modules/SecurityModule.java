package fr.icodem.eshop.modules;

import com.google.inject.Provides;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

public class SecurityModule extends ShiroWebModule {

    public SecurityModule(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {
        try {
            //bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
            bindRealm().to(JdbcRealm.class);
        } catch (Exception e) {
            addError(e);
        }

        addFilterChain("/rest/account/**", AUTHC_BASIC);
        addFilterChain("/**", ANON);

        /*
        addFilterChain("/public/**", ANON);
        addFilterChain("/stuff/allowed/**", AUTHC_BASIC, config(PERMS, "yes"));
        addFilterChain("/stuff/forbidden/**", AUTHC_BASIC, config(PERMS, "no"));
        addFilterChain("/**", AUTHC_BASIC);
        */

    }

    @Provides
    Ini loadShiroIni() {
        return Ini.fromResourcePath("classpath:shiro.ini");
    }

    @Provides
    JdbcRealm provideJdbcRealm() {
        JdbcRealm realm = new JdbcRealm();

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EShopDS");
            realm.setDataSource(ds);
        } catch (Exception e) {
            addError(e);
        }

        return realm;
    }
}
