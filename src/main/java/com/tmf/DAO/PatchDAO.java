package com.tmf.DAO;

import com.tmf.Entity.Patch;
import com.tmf.Entity.PatchUpdatePayload;
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
        patch.ifPresent(p->p.setOwner(patchUpdatePayload.getOwner()));
        patch.ifPresent(p->p.setType(patchUpdatePayload.getType()));
        patch.ifPresent(p->p.setPattern(patchUpdatePayload.getPattern()));
        patch.ifPresent(p->p.setLevel(patchUpdatePayload.getLevel()));
        patch.ifPresent(p->p.setStage(patchUpdatePayload.getStage()));
        patch.ifPresent(p->p.setPersonality(patchUpdatePayload.getPersonality()));
        patch.ifPresent(p->p.setHunger(patchUpdatePayload.getHunger()));
        patch.ifPresent(p->p.setHappiness(patchUpdatePayload.getHappiness()));
        patch.ifPresent(p->p.setStrength(patchUpdatePayload.getStrength()));
        patch.ifPresent(p->p.setDefense(patchUpdatePayload.getDefense()));
        patch.ifPresent(p->p.setAgility(patchUpdatePayload.getAgility()));
        patch.ifPresent(p->p.setHp(patchUpdatePayload.getHp()));
        patch.ifPresent(p->p.setWp(patchUpdatePayload.getWp()));
        patch.ifPresent(p->repository.save(p));
        return patch;
    }
}
