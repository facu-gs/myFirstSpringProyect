package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfiguration {

    @Bean(name = "MarioGame")
    public IGamingConsole marioGame(){
        return new MarioGame();
    }

    @Bean
    public IGamingConsole superContraGame(){
        return new SuperContraGame();
    }

    @Bean
    @Primary
    public IGamingConsole game(){
        return new PacmanGame();
    }

    @Bean
    public GameRunner gameRunner(IGamingConsole game){
        return new GameRunner(game);
    }

}
