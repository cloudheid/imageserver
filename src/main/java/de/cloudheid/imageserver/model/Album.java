package de.cloudheid.imageserver.model;

/**
 * Created by cloudheid on 14.07.2017.
 */

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Album {

    @Id
    private  long id;

    private String albumname;

    private List<Picture> pictures = new ArrayList<>();

    public Album(String albumname) {
        this.albumname=albumname;
    }

    public long getId() {
        return id;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public void addPicture(Picture picture) {
        pictures.add(picture);
    }

    public Picture getPicture(int index) {
        return pictures.get(index);
    }

    public List<Picture> getAllPictures() {
        return pictures;
    }

    @Override
    public String toString() {
        return String.format(
                "Album[id=%s, albumname='%s']",
                id, albumname);
    }

}
