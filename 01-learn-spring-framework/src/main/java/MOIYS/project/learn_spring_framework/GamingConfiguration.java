package MOIYS.project.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import MOIYS.project.learn_spring_framework.game.GameRunner;
import MOIYS.project.learn_spring_framework.game.GamingConsole;
import MOIYS.project.learn_spring_framework.game.MarioGame;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }
}
