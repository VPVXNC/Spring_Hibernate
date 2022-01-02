package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       UserService userService = context.getBean(UserService.class);

       User user1 = new User("FirstName1", "LastName1", "1gmail@gmail.com");
       user1.setCar(new Car("BMW", 8));
       User user2 = new User("FirstName2", "LastName2", "2gmail@gmail.com");
       user2.setCar(new Car("Toyota", 15));

       List<User> users = userService.listUsers("Audi", 8);
       for (User user : users) {
           System.out.println("Id = " + user.getId());
           System.out.println("First Name = "+user.getFirstName());
           System.out.println("Last Name = "+user.getLastName());
           System.out.println("Email = " + user.getEmail());
           System.out.println("Car = " + user.getCar().toString());
           System.out.println();
       }

       context.close();
   }
}
