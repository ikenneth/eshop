package fr.icodem.eshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album extends Product implements Serializable {
    private Date releaseDate;
    private int length;

    private List<Figure> artists;

    @Override
    public String toString() {
        return "Album{" +
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

    public List<Figure> getArtists() {
        return artists;
    }

    public void setArtists(List<Figure> artists) {
        this.artists = artists;
    }
}
