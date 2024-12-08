package TASK9;

// Класс DatabaseConnectionManager (Одиночка) — менеджер подключений к базе данных
class DatabaseConnectionManager {
  // Статическое поле для хранения единственного экземпляра
  private static DatabaseConnectionManager instance;
  
  // Псевдоподключение (можно заменить реальным подключением к базе данных)
  private String connection;

  // Приватный конструктор, чтобы предотвратить создание экземпляров извне
  private DatabaseConnectionManager() {
      // Симуляция подключения
      this.connection = "Подключение к базе данных установлено.";
  }

  // Метод для получения единственного экземпляра класса (ленивая инициализация)
  public static DatabaseConnectionManager getInstance() {
      if (instance == null) {
          instance = new DatabaseConnectionManager();
      }
      return instance;
  }

  // Метод для получения состояния подключения
  public String getConnection() {
      return connection;
  }
}

// Главный класс для демонстрации паттерна Одиночка
public class DatabaseConnectionManagerTest {

  public static void main(String[] args) {
      // Получение единственного экземпляра менеджера подключений
      DatabaseConnectionManager dbManager1 = DatabaseConnectionManager.getInstance();
      System.out.println(dbManager1.getConnection());

      // Получение того же экземпляра
      DatabaseConnectionManager dbManager2 = DatabaseConnectionManager.getInstance();
      System.out.println(dbManager2.getConnection());

      // Проверка, что оба экземпляра одинаковы
      System.out.println("Один ли экземпляр? " + (dbManager1 == dbManager2));
  }
}
