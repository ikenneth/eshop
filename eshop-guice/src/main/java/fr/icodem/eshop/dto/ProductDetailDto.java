package fr.icodem.eshop.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductDetailDto {

    private int id;
    private ProductType type;
    private String name;
    private String description;
    private boolean available;
    private double price;

    private Date releaseDate;
    private int length;

    // books
    private String isbn;
    private List<FigureDto> authors;
    private int pages;
    private String language;

    // movies
    private List<FigureDto> actors;
    private FigureDto director;
    private String[] languages;

    // albums
    private List<FigureDto> artists;

    public void addAuthor(FigureDto author) {
        if (authors == null) authors = new ArrayList<>();
        authors.add(author);
    }

    public void addActor(FigureDto actor) {
        if (actors == null) actors = new ArrayList<>();
        actors.add(actor);
    }

    public void addArtist(FigureDto artist) {
        if (artists == null) artists = new ArrayList<>();
        artists.add(artist);
    }

    @Override
    public String toString() {
        return "ProductDetailDto{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", length=" + length +
                ", isbn='" + isbn + '\'' +
                ", authors='" + authors + '\'' +
                ", pages=" + pages +
                ", language='" + language + '\'' +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", artists='" + artists + '\'' +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<FigureDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<FigureDto> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<FigureDto> getActors() {
        return actors;
    }

    public void setActors(List<FigureDto> actors) {
        this.actors = actors;
    }

    public FigureDto getDirector() {
        return director;
    }

    public void setDirector(FigureDto director) {
        this.director = director;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public List<FigureDto> getArtists() {
        return artists;
    }

    public void setArtists(List<FigureDto> artists) {
        this.artists = artists;
    }
}
