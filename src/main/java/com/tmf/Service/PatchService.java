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

    public Optional<Patch> getPatchById(int id) {
        return patchDAO.getPatchById(id);
    }

    public Optional<Patch> deletePatchById(int id){
        return patchDAO.deletePatchById(id);
    }

    public Optional<Patch> updatePatchById(int id, PatchUpdatePayload patchUpdatePayload) {
        return patchDAO.updatePatchById(id, patchUpdatePayload);
    }
}
