package code.elif.controller;

import code.elif.model.Cambly;
import code.elif.service.CamblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cambly")
public class CamblyController {

    private final CamblyService camblyService;

    public CamblyController(CamblyService camblyService) {
        this.camblyService = camblyService;
    }

    @RequestMapping("/list")
    public String listCambly(Model theModel) {
        List<Cambly> camblys = camblyService.getAllCamblys();
        theModel.addAttribute("camblyList", camblys);
        return "list-cambly";
    }

    @RequestMapping("/showFormForAdd")
    public String addCambly(Model theModel) {
        Cambly cambly = new Cambly();
        theModel.addAttribute("cambly", cambly);
        return "cambly-form";
    }

    @PostMapping("/saveCambly")
    public String saveCambly(@ModelAttribute("cambly") Cambly cambly) {
        if(cambly.getId()==null) {
            camblyService.createCambly(cambly);
        } else {
            camblyService.updateCambly(cambly);
        }
        return "redirect:/cambly/list";
    }

    @GetMapping("/showFormForUpdate")
    public String saveCambly(@RequestParam("camblyId") int camblyId, Model theModel) {

        Cambly cambly = camblyService.getCambly(camblyId);
        theModel.addAttribute("cambly", cambly);
        return "cambly-form";
    }

    @GetMapping("/showFormForDelete")
    public String deleteCambly(@RequestParam("camblyId") int camblyId, Model theModel) {
        camblyService.deleteCambly(camblyId);
        return "redirect:/cambly/list";
    }




    @GetMapping("/search")
    public String searchCamblys(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        // search camblys from the service
        List<Cambly> theCamblys = camblyService.searchCamblys(theSearchName);
        // add the camblys to the model
        theModel.addAttribute("camblyList", theCamblys);
        return "list-cambly";
    }

}
