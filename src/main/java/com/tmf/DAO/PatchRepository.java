package com.tmf.DAO;

import com.tmf.Models.Patch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatchRepository extends MongoRepository<Patch, Integer> {

}
