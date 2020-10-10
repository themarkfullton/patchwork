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
    public Collection<Patch> getPatch() {
        return patchService.getPatch();
    }

    @PostMapping
    public Patch postPatch(@RequestBody Patch patch) {
        return patchService.createPatch(patch);
    }


}
