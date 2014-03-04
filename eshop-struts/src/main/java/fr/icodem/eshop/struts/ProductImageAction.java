package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import fr.icodem.eshop.model.ProductImage;
import fr.icodem.eshop.service.CatalogService;

import javax.annotation.Resource;

public class ProductImageAction extends ActionSupport {
    private int imageId;

    @Resource
    private CatalogService service;

    public byte[] getContent() {
        ProductImage image = service.findProductImage(imageId);
        return image.getContent();
    }

    @Override
    public String execute() {
        return SUCCESS;
    }

    // getters and setters
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
