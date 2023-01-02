package com.javatechie.respository;

import com.javatechie.entity.ImageData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StorageRepository extends MongoRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);
}
