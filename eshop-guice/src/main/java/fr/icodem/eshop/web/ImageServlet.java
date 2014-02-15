package fr.icodem.eshop.web;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.icodem.eshop.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Singleton
public class ImageServlet extends HttpServlet {

    @Inject
    private CatalogService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("image/png");

            int imageId = Integer.parseInt(req.getParameter("productId"));
            boolean small = req.getParameter("small") != null;

            byte[] image = service.findProductImage(imageId);


            OutputStream os = resp.getOutputStream();
            os.write(image);

        } catch (Exception e) {}

    }
}
