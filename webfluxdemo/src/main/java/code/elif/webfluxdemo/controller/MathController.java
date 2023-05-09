package code.elif.webfluxdemo.controller;


import code.elif.webfluxdemo.BaseResponse;
import code.elif.webfluxdemo.controller.base.AbstractController;
import code.elif.webfluxdemo.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math")
public class MathController extends AbstractController {

    private final MathService mathService;

    @GetMapping("/square/{input}")
    public BaseResponse<Integer> square(@PathVariable("input") Integer number) {
        return getSuccessBaseResponse(mathService.square(number));
    }

    @GetMapping("/multiplicationTable/{input}")
    public BaseResponse<List<String>> getMultiplicationTable(@PathVariable("input") Integer number) {
        return getSuccessBaseResponse(mathService.getMultiplicationTable(number));
    }
}
