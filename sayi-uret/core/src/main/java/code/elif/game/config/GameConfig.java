package code.elif.game.config;

import code.elif.game.qualifier.GuessCount;
import code.elif.game.qualifier.MaxNumber;
import code.elif.game.qualifier.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "code.elif")
public class GameConfig {

    @Value("${game.maxNumber:10}")
    private int maxNumber;
    @Value("${game.guessCount:9}")
    private int guessCount;

    @Value("${game.minNumber:40}")
    private int minNumber;


    @Bean
    @MinNumber
    public int getMinNumber() {
        return minNumber;
    }
    @Bean
    @MaxNumber
    public int getMaxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int getGuessCount() {
        return guessCount;
    }

}
