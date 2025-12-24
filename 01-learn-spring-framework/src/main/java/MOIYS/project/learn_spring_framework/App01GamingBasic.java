package MOIYS.project.learn_spring_framework;

import MOIYS.project.learn_spring_framework.game.GameRunner;
import MOIYS.project.learn_spring_framework.game.PackmanGame;

public class App01GamingBasic {
    public static void main(String[] args) {

//        var game = new SuperContraGame();
//        var game = new MarioGame();

        // 1. 객체 생성
        var game = new PackmanGame();

        // 2. 객체 생성 + 의존성 연결
        // GamingConsole은 GameRunner 클래스의 의존성
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}