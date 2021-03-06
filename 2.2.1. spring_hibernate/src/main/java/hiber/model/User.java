package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn
   private Car userCar;

   public Car getUserCar() {
      return userCar;
   }

   public void setUserCar(Car userCar) {
      this.userCar = userCar;
   }

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return String.format("Id = %d,\nFirst Name = %s,\nLast Name = %s,\nEmail = %s,\nCar Model = %s,\n" +
              "Car Series = %d\n", id, firstName, lastName, email, userCar.getModel(), userCar.getSeries());
   }
}
