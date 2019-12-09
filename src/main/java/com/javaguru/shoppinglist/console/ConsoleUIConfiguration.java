package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConsoleUIConfiguration {

    @Autowired
    private Action assignProductAction;

    @Autowired
    private Action createProductAction;

    @Autowired
    private Action createUserAction;

    @Autowired
    private Action exitAction;

    @Autowired
    private Action findProductByAction;


    @Bean
    ConsoleUI consoleUI() {
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductByAction);
        actions.add(exitAction);
        actions.add(createUserAction);
        actions.add(assignProductAction);
        return new ConsoleUI(actions);
    }
}
