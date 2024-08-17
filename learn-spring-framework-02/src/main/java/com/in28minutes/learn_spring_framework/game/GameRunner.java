package com.in28minutes.learn_spring_framework.game;

public class GameRunner {


    private IGamingConsole game;

    public GameRunner(IGamingConsole aGame) { this.game = aGame; }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
