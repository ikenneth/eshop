package fr.icodem.eshop.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import fr.icodem.eshop.rest.AccountResource;
import fr.icodem.eshop.rest.ProductFamilyResource;
import fr.icodem.eshop.rest.ProductResource;

import javax.sql.DataSource;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ProductResource.class);
        bind(ProductFamilyResource.class);
        bind(AccountResource.class);
    }

}
