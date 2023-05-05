package code.elif.combine.merge;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class MergeDemo {

    public static void main(String[] args) throws InterruptedException {
          Flux<String> merge =
                Flux.merge(FruitGenerator.getFruitsName(),
                        VegetableGenerator.getVegetableNames());

        merge.subscribe(data ->
                ReactiveStreamUtil.printWithThreadName(data.toString()));

        Thread.sleep(5000);
    }
}
