package code.elif.controller;

import code.elif.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@RequestMapping("/test")
@Controller
public class RequestMappingController {

    @RequestMapping("test1")
    public String test1(@RequestParam String test, Model model) {
        model.addAttribute("test", test);
        return "test/test-view";
    }


    @RequestMapping(value = "test2")
    public String test20(@RequestParam(defaultValue = "elif", value = "test20") String test, Model model) {
        model.addAttribute("test", test);
        return "test/test-view";
    }

    @RequestMapping(value = "test2", params = "test21")
    public String test21(@RequestParam String test, Model model) {
        model.addAttribute("test", test);
        return "test/test-view";
    }

    @RequestMapping(value = "test3", params = {"test31", "test32"})
    public String test3(@RequestParam String test31, @RequestParam String test32, Model model) {
        model.addAttribute("test", test31);
        model.addAttribute("test2", test32);
        return "test/test-view";
    }

    @RequestMapping(value = "/test-view")
    @ModelAttribute("test4")
    public Person test4() {
        return  new Person("Elif","Akgun", LocalDate.of(1989,9,4));
    }


    @RequestMapping("*")
    public String notFound() {
        return "notfound";
    }

}
