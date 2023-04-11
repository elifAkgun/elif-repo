package code.elif.parallel;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class ParallelOnWithArrayList {

    public static void main(String[] args) throws InterruptedException {
        //  List<Integer> integerList = new ArrayList<>();
        List<Integer> integerList = Collections.synchronizedList(new ArrayList());

        Flux.range(1, 1000)
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(integer -> integerList.add(integer));

        Thread.sleep(2000);

        printWithThreadName("List Size: " + integerList.size());
    }
}
