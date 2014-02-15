package fr.icodem.eshop.rest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sun.jersey.core.util.Base64;
import fr.icodem.eshop.dto.ProductCriteriaDto;
import fr.icodem.eshop.dto.ProductDetailDto;
import fr.icodem.eshop.dto.ProductDto;
import fr.icodem.eshop.dto.UserDto;
import fr.icodem.eshop.service.AccountService;
import fr.icodem.eshop.service.CatalogService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import java.nio.charset.Charset;
import java.util.List;

@Path("account") @Singleton
public class AccountResource {


    /*
    	DEFAULT_AUTHENTICATION_QUERY	"select password from users where username = ?"
protected static final String	DEFAULT_PERMISSIONS_QUERY	"select permission from roles_permissions where role_name = ?"
protected static final String	DEFAULT_SALTED_AUTHENTICATION_QUERY	"select password, password_salt from users where username = ?"
protected static final String	DEFAULT_USER_ROLES_QUERY	"select role_name from user_roles where username = ?"

     */

    /*

    CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB;

CREATE TABLE `user_roles` (
  `username` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB;


     */


    @Inject
    private AccountService service;

    @GET @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserDetail(@HeaderParam("Authorization") String auth) {

        System.out.println("AUTH => " + auth);

        if (auth != null && auth.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = auth.substring("Basic".length()).trim();
            String credentials = new String(Base64.decode(base64Credentials),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":",2);
            System.out.println(values[0] + " => " + values[1]);

            String email = values[0];
            UserDto u = service.findUser(email);
            System.out.println(u.getFirstName());
            return u;
        }

        return null;
    }

}
