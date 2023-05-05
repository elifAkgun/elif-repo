package code.elif.combine.startwith;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartWithDemo {

    public static void main(String[] args) {
        CityNameGenerator cityNameGenerator = new CityNameGenerator();
        cityNameGenerator.getCityName("Mike")
                .take(4)
                .subscribe(s -> log.info(s));

        System.out.println("....");
        cityNameGenerator.getCityName("John")
                .take(2)
                .subscribe(s -> log.info(s));

        System.out.println("....");
        cityNameGenerator.getCityName("Adele")
                .take(6)
                .subscribe(s -> log.info(s));
        ;
    }
}
