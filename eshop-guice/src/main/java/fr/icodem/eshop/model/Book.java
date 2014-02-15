package fr.icodem.eshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @PrimaryKeyJoinColumn(name = "id")
public class Book extends Product {
    @Temporal(TemporalType.DATE) @Column(name = "release_date")
    private Date releaseDate;
    private String isbn;
    private String language;
    private int pages;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Figure> authors;

    @Override
    public String toString() {
        return "Book{" +
                "releaseDate=" + releaseDate +
                ", isbn='" + isbn + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                "} " + super.toString();
    }

    // getters and setters
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date date) {
        this.releaseDate = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Figure> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Figure> authors) {
        this.authors = authors;
    }
}
