package com.tmf.Repositories;

import com.tmf.Models.Patch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatchRepository {
    Patch save(Patch patch);

    List<Patch> saveAll(List<Patch> patches);

    List<Patch> findAll();

    List<Patch> findAll(List<String> ids);

    Patch findOne(String id);

    long count();

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    Patch update(String id, Patch patch);

    long update(List<Patch> patches);
}
