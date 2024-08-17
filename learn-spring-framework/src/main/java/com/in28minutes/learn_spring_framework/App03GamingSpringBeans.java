package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.IGamingConsole;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean("MarioGame", IGamingConsole.class).down();

            GameRunner gameRunner = context.getBean(GameRunner.class);
            gameRunner.run();
            //== context.getBean(GameRunner.class).run();
        }

    }
}
