package de.cloudheid.imageserver.model;

import org.springframework.data.annotation.Id;

/**
 * Created by cloudheid on 16.07.2017.
 */
public class Picture {

    @Id
    private  long id;

    private String filename;

    public Picture(String filename) {
        this.filename=filename;
    }

    public long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return String.format(
                "Picture[id=%s, filename='%s']",
                id, filename);
    }
}
