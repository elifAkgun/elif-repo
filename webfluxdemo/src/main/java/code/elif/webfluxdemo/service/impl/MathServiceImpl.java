package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.MathService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public Integer square(Integer i) {
        return i * i;
    }

    @Override
    public List<String> getMultiplicationTable(Integer i) {
        List<String> collect = IntStream.range(1, 10)
                .mapToObj(multiplicationNumber ->
                        String.format("%sx%s=%s", i, multiplicationNumber, multiplicationNumber * i))
                .collect(Collectors.toList());
        return collect;
    }
}
