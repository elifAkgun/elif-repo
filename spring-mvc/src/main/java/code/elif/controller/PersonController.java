package code.elif.controller;

import code.elif.model.Person;
import code.elif.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/list")
    public String listPerson(Model theModel) {
        List<Person> persons = personService.getAllPersons();
        theModel.addAttribute("personList", persons);
        return "list-person";
    }

    @RequestMapping("/showFormForAdd")
    public String addPerson(Model theModel) {
        Person person = new Person();
        theModel.addAttribute("person", person);
        return "person-form";
    }

    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.createPerson(person);
        return "redirect:/person/list";
    }

    @GetMapping("/showFormForUpdate")
    public String savePerson(@RequestParam("personId") int personId, Model theModel) {

        Person person = personService.getPerson(personId);
        theModel.addAttribute("person", person);
        return "person-form";
    }

    @GetMapping("/showFormForDelete")
    public String deletePerson(@RequestParam("personId") int personId, Model theModel) {
        personService.deletePerson(personId);
        return "redirect:/person/list";
    }




    @GetMapping("/search")
    public String searchPersons(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        // search persons from the service
        List<Person> thePersons = personService.searchPersons(theSearchName);
        // add the persons to the model
        theModel.addAttribute("personList", thePersons);
        return "list-person";
    }

}
