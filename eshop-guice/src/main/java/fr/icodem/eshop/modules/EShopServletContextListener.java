package fr.icodem.eshop.modules;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import fr.icodem.eshop.web.ImageServlet;
import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.HashMap;
import java.util.Map;

public class EShopServletContextListener extends GuiceServletContextListener {

    private static Logger log = LoggerFactory.getLogger(EShopServletContextListener.class);

    private ServletContext servletContext;

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {

                //filter("*").through(GuiceShiroFilter.class);
                ShiroWebModule.guiceFilterModule();

                install(new SecurityModule(servletContext));

                /*try {
                    Class klass = UriBuilder.class;
                    CodeSource codeSource = klass.getProtectionDomain().getCodeSource();
                    if ( codeSource != null) {
                        System.out.println(codeSource.getLocation());
                        log.info("LOCATION => " + codeSource.getLocation());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }       */
                // service layer module
                install(new ServiceModule());

                // web config
                //serve("/hello", "/hello-world").with(HelloServlet.class);
                //serveRegex("(.)*bonjour(.)*").with(HelloServlet.class);
                // cf https://code.google.com/p/google-guice/wiki/ServletRegexKeyMapping
                serve("/image", "/img").with(ImageServlet.class);

                // hook Jersey into Guice Servlet
                bind(GuiceContainer.class);

                // hook Jackson into Jersey as the POJO <-> JSON mapper
                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

                serve("/rest/*").with(GuiceContainer.class);

                // JPA
                //Map p = new HashMap();
                //p.put( Environment.DATASOURCE, ds );
                //JpaPersistModule jpaPersistModule = new JpaPersistModule("myapp-db").properties(p);

                install(new JpaPersistModule("eshop"));
                filter("/*").through(PersistFilter.class);
            }
        });
    }

    /**
     * Servlet context registered for Shiro
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        super.contextInitialized(servletContextEvent);
    }
}
