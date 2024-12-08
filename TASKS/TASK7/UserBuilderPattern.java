package TASK7;

// Класс User, представляющий пользователя
class User {
  private String firstName;
  private String lastName;
  private String email;
  private int age;
  private String address;

  public User(String firstName, String lastName, String email, int age, String address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.age = age;
      this.address = address;
  }

  @Override
  public String toString() {
      return "User{" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", age=" + age +
              ", address='" + address + '\'' +
              '}';
  }
}

// Класс UserBuilder, который строит объект User
class UserBuilder {
  private String firstName;
  private String lastName;
  private String email;
  private int age;
  private String address;

  public UserBuilder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
  }

  public UserBuilder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
  }

  public UserBuilder setEmail(String email) {
      this.email = email;
      return this;
  }

  public UserBuilder setAge(int age) {
      this.age = age;
      return this;
  }

  public UserBuilder setAddress(String address) {
      this.address = address;
      return this;
  }

  public User build() {
      return new User(firstName, lastName, email, age, address);
  }
}

// Главный класс для демонстрации паттерна Строитель
public class UserBuilderPattern {

  public static void main(String[] args) {
      // Создание пользователя с использованием билдера
      User user = new UserBuilder()
              .setFirstName("Иван")
              .setLastName("Иванов")
              .setEmail("ivanov@example.com")
              .setAge(30)
              .setAddress("Москва, улица Пушкина")
              .build();

      // Вывод информации о пользователе
      System.out.println(user);
  }
}
