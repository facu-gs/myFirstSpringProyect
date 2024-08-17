package com.in28minutes.learn_spring_framework.game;

import org.springframework.stereotype.Component;
//Annotating PacmanGame Class as @Component, there's no need to create a bean
@Component
public class PacmanGame implements IGamingConsole {

    public void up() {
        System.out.println("Move Up");
    }

    public void down() {
        System.out.println("Move down");
    }

    public void left() {
        System.out.println("Move left");
    }

    public void right() {
        System.out.println("Move right");
    }
}
