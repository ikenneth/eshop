package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import fr.icodem.eshop.model.ProductImage;
import fr.icodem.eshop.service.CatalogService;

import javax.annotation.Resource;

public class ProductImageAction extends ActionSupport {
    private int imageId;

    private byte[] content;

    @Resource
    private CatalogService service;

    public byte[] getContent() {
        return content;
    }

    @Override
    public String execute() {
        ProductImage image = service.findProductImage(imageId);
        content = image.getContent();
        return SUCCESS;
    }

    // getters and setters
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
