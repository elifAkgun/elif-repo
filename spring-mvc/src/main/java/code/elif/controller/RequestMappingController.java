package code.elif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/test")
@Controller
public class RequestMappingController {

    @RequestMapping("test1")
    public String test1(@RequestParam String test, Model model){
        model.addAttribute("test", test);
        return "test-view";
    }

    @RequestMapping(value = "test2", params = "test2")
    public String test20(@RequestParam(defaultValue = "elif", value = "test2") String test, Model model){
        model.addAttribute("test", test);
        return "test-view";
    }

    @RequestMapping(value="test2", params = "test")
    public String test21(@RequestParam String test, Model model){
        model.addAttribute("test", test);
        return "test-view";
    }

    @RequestMapping(value="test3", params = {"test", "test2"})
    public String test21(@RequestParam String test,@RequestParam String test2, Model model){
        model.addAttribute("test", test);
        model.addAttribute("test2", test);
        return "test-view";
    }

    @RequestMapping("*")
    public String notFound(){
        return "notfound";
    }

}
