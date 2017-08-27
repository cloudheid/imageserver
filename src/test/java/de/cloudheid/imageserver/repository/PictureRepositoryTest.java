package de.cloudheid.imageserver.repository;

import de.cloudheid.imageserver.model.Picture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jv on 16.07.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureRepositoryTest {
    @Autowired
    private PictureRepository pictureRepository;

    @Before
    public void initTest() {
        pictureRepository.deleteAll();
    }

    @Test
    public void addPictureEntry() {

        Picture picture = new Picture("test-filename");

        pictureRepository.insert(picture);

        assertEquals(pictureRepository.findAll().get(0).getFilename(),picture.getFilename());
    }

    @Test
    public void deletepictureEntry() {

        Picture picture = new Picture("Testpicture");

        pictureRepository.insert(picture);

        assertEquals(pictureRepository.findAll().size(),1);

        pictureRepository.delete(picture);

        assertEquals(pictureRepository.findAll().size(),0);
    }
}
