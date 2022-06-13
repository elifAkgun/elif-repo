package code.elif.game.impl;


import code.elif.game.Game;
import code.elif.game.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    public static final String MAIN_MESSAGE_PROP = "game.main.message";
    private static final String WON = "game.win";
    private static final String LOST = "game.lost";
    private static final String INVALID = "game.invalid.range";
    private static final String FIRST_GUESS = "game.first.guess";
    private static final String LOWER = "game.lower";
    private static final String HIGHER = "game.higher";
    private static final String RESULT_MESSAGE = "game.result.message";
    private Game game;

    private final MessageSource messageSource;



    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        log.info("game {}", game);
    }

    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE_PROP,
                game.getSmallest(), game.getBiggest());
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return getMessage(WON, game.getNumber());
        } else if (game.isGameLost()) {
            return getMessage(LOST, game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return getMessage(INVALID);
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS);
        } else {
            String direction = getMessage(LOWER);

            if (game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER);
            }

            return getMessage(RESULT_MESSAGE, direction, game.getRemainingGuesses());
        }
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
