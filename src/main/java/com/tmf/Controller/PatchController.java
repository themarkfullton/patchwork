package com.tmf.Controller;

import com.tmf.Models.Patch;
import com.tmf.Models.PatchUpdatePayload;
import com.tmf.Service.PatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/patch")
public class PatchController {
    @Autowired
    private PatchService patchService;

    @GetMapping
    public Collection<Patch> getPatches() {
        return patchService.getPatches();
    }

    @PostMapping
    public Patch postPatch(@RequestBody Patch patch) {
        return patchService.createPatch(patch);
    }

    @GetMapping(value="/{id}")
    public Optional<Patch> getPatchById(@PathVariable("id") int id) {
        return patchService.getPatchById(id);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Patch> deletePatchById(@PathVariable("id") int id) {
        return patchService.deletePatchById(id);
    }

//    @PutMapping(value="/{id}")
//    public Optional<Patch> updatePatchById(@PathVariable("id") int id, @RequestBody PatchUpdatePayload patchUpdatePayload){
//        return patchService.updatePatchById(id, patchUpdatePayload);
//    }
}
