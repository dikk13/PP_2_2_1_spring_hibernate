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
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("1", 1);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setUserCar(car1);
      userService.add(user1);
      Car car2 = new Car("2", 2);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setUserCar(car2);
      userService.add(user2);
      Car car3 = new Car("3",3);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setUserCar(car3);
      userService.add(user3);
      Car car4 = new Car("4", 4);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setUserCar(car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      System.out.println(userService.getUserByModelAndSeries("2", 2));
      context.close();
   }
}
