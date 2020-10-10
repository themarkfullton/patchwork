package com.tmf.DAO;

import com.tmf.Models.Patch;
import com.tmf.Models.PatchUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class PatchDAO {
    @Autowired
    private PatchRepository repository;

    public Collection<Patch> getPatches(){
        return repository.findAll();
    }
}
