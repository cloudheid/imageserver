package de.cloudheid.imageserver.repository;


import de.cloudheid.imageserver.model.Album;
import de.cloudheid.imageserver.model.Picture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by cloudheid on 14.07.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Before
    public void initTest() {
        albumRepository.deleteAll();
    }

    @Test
    public void addAlbumEntry() {

        Album album = new Album("Testalbum");

        albumRepository.insert(album);

        assertEquals(albumRepository.findAll().get(0).getAlbumname(),album.getAlbumname());
    }

    @Test
    public void deleteAlbumEntry() {

        Album album = new Album("Testalbum");

        albumRepository.insert(album);

        assertEquals(albumRepository.findAll().size(),1);

        albumRepository.delete(album);

        assertEquals(albumRepository.findAll().size(),0);
    }

    @Test
    public void addAlbumWithPictureEntry() {
        Album album = new Album("Testalbum");
        Picture picture = new Picture("test-filename");

        album.addPicture(picture);

        albumRepository.insert(album);

        assertEquals(albumRepository.findAll().get(0).getAlbumname(),album.getAlbumname());
        assertEquals(albumRepository.findAll().get(0).getPicture(0).getFilename(),album.getPicture(0).getFilename());
    }

    @Test
    public void addAlbumWithMultiplePictureEntry() {
        Album album = new Album("Testalbum");
        Picture picture1 = new Picture("test-filename");
        Picture picture2 = new Picture("test-filename1");
        Picture picture3 = new Picture("test-filename2");

        album.addPicture(picture1);
        album.addPicture(picture2);
        album.addPicture(picture3);


        albumRepository.insert(album);

        assertEquals(albumRepository.findAll().get(0).getAlbumname(),album.getAlbumname());
        assertEquals(albumRepository.findAll().get(0).getAllPictures().size(),3);
    }

}