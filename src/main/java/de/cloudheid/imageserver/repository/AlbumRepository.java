package de.cloudheid.imageserver.repository;

import de.cloudheid.imageserver.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Created by cloudheid on 14.07.2017.
 */

public interface AlbumRepository extends MongoRepository<Album, Long> {

}
