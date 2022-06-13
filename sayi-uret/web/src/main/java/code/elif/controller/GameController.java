package code.elif.controller;

import code.elif.service.GameService;
import code.elif.util.AttributeNames;
import code.elif.util.GameMappings;
import code.elif.util.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
//705906043
@Controller
@Slf4j
public class GameController {
    private final GameService gameService;


    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.PLAY)
    public String play (Model model){

        model.addAttribute(AttributeNames.MAIN_MESSAGE,gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE,gameService.getResultMessage());
        log.info("model : {}", model);
        return gameService.isGameOver() ? Views.GAME_OVER : Views.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage (@RequestParam int guess){
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESET)
    public String resetGame(){
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }
    @GetMapping(GameMappings.HOME)
    public String redirectHome(){
        gameService.reset();
        return Views.HOME;
    }
}
