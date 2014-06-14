package fr.icodem.eshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Movie extends Product implements Serializable {
    private Date releaseDate;
    private int length;

    private List<Figure> actors;

    // TODO add Hibernate mapping Movie.director
//    @ManyToOne
//    @JoinTable(name = "movie_director",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private Figure director;

    private List<String> languages;

    @Override
    public String toString() {
        return "Movie{" +
                "releaseDate=" + releaseDate +
                ", length=" + length +
                "} " + super.toString();
    }

    // getters and setters
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

    public List<Figure> getActors() {
        return actors;
    }

    public void setActors(List<Figure> actors) {
        this.actors = actors;
    }

    public Figure getDirector() {
        return director;
    }

    public void setDirector(Figure director) {
        this.director = director;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
