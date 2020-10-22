package com.tmf.DAO;

import com.tmf.Entity.Patch;
import com.tmf.Entity.PatchUpdatePayload;
import com.tmf.Repositories.PatchRepository;
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

    public Patch createPatch(Patch patch){
        return repository.insert(patch);
    }

    public Optional<Patch> getPatchById(int id){

        return repository.findById(id);
    }

    public Optional<Patch> deletePatchById(int id){
        Optional<Patch> patch = repository.findById(id);
        patch.ifPresent(p->repository.delete(p));
        return patch;
    }

    public Optional<Patch> updatePatchById(int id, PatchUpdatePayload patchUpdatePayload) {
        Optional<Patch> patch = repository.findById(id);
        patch.ifPresent(p->p.setName(patchUpdatePayload.getName()));
        patch.ifPresent(p->p.setCreator(patchUpdatePayload.getCreator()));
        patch.ifPresent(p->p.setPattern(patchUpdatePayload.getPattern()));
        patch.ifPresent(p->p.setFabric(patchUpdatePayload.getFabric()));
        patch.ifPresent(p->p.setTemperment(patchUpdatePayload.getTemperment()));
        patch.ifPresent(p->repository.save(p));
        return patch;
    }
}
