package de.cloudheid.imageserver.repository;

import de.cloudheid.imageserver.model.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cloudheid on 16.07.2017.
 */
public interface PictureRepository extends MongoRepository<Picture, Long> {
}
