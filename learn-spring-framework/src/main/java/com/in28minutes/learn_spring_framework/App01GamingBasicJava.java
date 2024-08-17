package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

        var game = new SuperContraGame();

        // instantiation + Wiring on dependencies
        // Game is a dependency of GameRunner
        var gameRunner = new GameRunner(game);

        gameRunner.run();

    }
}
