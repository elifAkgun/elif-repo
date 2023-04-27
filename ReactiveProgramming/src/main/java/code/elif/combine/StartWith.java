package code.elif.combine;

import code.elif.ReactiveStreamUtil;

public class StartWith {

    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.getCityName("Mike")
                .take(4)
                .subscribe(s -> ReactiveStreamUtil.printWithThreadName(s));

        System.out.println("....");
        nameGenerator.getCityName("John")
                .take(2)
                .subscribe(s -> ReactiveStreamUtil.printWithThreadName(s));

        System.out.println("....");
        nameGenerator.getCityName("Adele")
                .take(6)
                .subscribe(s -> ReactiveStreamUtil.printWithThreadName(s));
        ;
    }
}
