package fr.icodem.eshop.dto;

public class FigureDto {
    private int id;
    private String name;

    public FigureDto() {}

    public FigureDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FigureDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
