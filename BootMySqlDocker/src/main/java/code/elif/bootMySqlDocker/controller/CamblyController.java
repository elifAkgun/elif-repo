package code.elif.bootMySqlDocker.controller;

import code.elif.bootMySqlDocker.model.Cambly;
import code.elif.bootMySqlDocker.service.CamblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CamblyController {

    private final CamblyService camblyService;

    @Autowired
    public CamblyController(CamblyService camblyService) {
        this.camblyService = camblyService;
    }

    @GetMapping("/cambly")
    public List<Cambly> index(){
        return camblyService.getAll();
    }
}
