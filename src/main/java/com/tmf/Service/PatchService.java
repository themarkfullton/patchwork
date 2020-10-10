package com.tmf.Service;

import com.tmf.DAO.PatchDAO;
import com.tmf.Models.Patch;
import com.tmf.Models.PatchUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PatchService {
    @Autowired
    private PatchDAO patchDAO;

    public Collection<Patch> getPatches() {
        return patchDAO.getPatches();
    }

    public Patch createPatch(Patch patch) {
        return patchDAO.createPatch(patch);
    }
}
