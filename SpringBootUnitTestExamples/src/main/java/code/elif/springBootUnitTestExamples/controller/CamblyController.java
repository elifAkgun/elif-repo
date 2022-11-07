package code.elif.springBootUnitTestExamples.controller;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.service.CamblyService;
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
    public List<CamblyDTO> index(){
        return camblyService.getAll();
    }
}
