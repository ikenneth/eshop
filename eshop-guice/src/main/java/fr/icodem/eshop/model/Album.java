package fr.icodem.eshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Album extends Product {
    @Temporal(TemporalType.DATE) @Column(name = "release_date")
    private Date releaseDate;
    private int length;

    @ManyToMany
    @JoinTable(name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
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
