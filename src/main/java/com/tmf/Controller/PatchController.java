package com.tmf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patch")
public class PatchController {

    @GetMapping
    public String getPatches() {
        return "Hello World";
    }
}
