package org.example.controller;

import org.example.model.entity.Summary;
import org.example.service.DeveloperConsoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DeveloperConsole/TCApp")
public class DeveloperConsoleController {

    DeveloperConsoleService developerConsoleService;

    DeveloperConsoleController(DeveloperConsoleService developerConsoleService) {
        this.developerConsoleService = developerConsoleService;
    }

    @GetMapping("/listSummaries")
    public List<Summary> getSummary() {
        return developerConsoleService.listAllSummary();
    }

    @GetMapping("/initialize")
    public void initialize() {
        developerConsoleService.initialize();
    }

    @GetMapping("/reinitialize")
    public void reinitialize() {
        developerConsoleService.reinitialize();
    }

}
