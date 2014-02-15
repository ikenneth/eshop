package fr.icodem.eshop.dto;

public class ProductCriteriaDto {
    private String keyword;
    private int familyId;

    public ProductCriteriaDto(String keyword, int familyId) {
        this.keyword = keyword;
        this.familyId = familyId;
    }

    @Override
    public String toString() {
        return "ProductCriteriaDto{" +
                "keyword='" + keyword + '\'' +
                ", familyId=" + familyId +
                '}';
    }

    // getters and setters
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
}
