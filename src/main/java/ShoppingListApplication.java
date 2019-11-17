

import com.javaguru.shoppinglist.configurtion.AppConfiguration;
import com.javaguru.shoppinglist.console.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingListApplication {

    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
       ConsoleUI console = context.getBean(ConsoleUI.class);
       console.execute();
    }
}