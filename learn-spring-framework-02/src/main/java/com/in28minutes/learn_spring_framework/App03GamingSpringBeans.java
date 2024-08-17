package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class App03GamingSpringBeans {


    @Bean(name = "MarioGame")
    public IGamingConsole marioGame(){
        return new MarioGame();
    }

    @Bean
    public IGamingConsole superContraGame(){
        return new SuperContraGame();
    }

    @Bean
    public IGamingConsole game(){
        return new PacmanGame();
    }

    @Bean
    public GameRunner gameRunner(IGamingConsole game){
        return new GameRunner(game);
    }

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {
            context.getBean("MarioGame", IGamingConsole.class).down();

            GameRunner gameRunner = context.getBean(GameRunner.class);
            gameRunner.run();
            //== context.getBean(GameRunner.class).run();
        }

    }
}
