package TASK10;

// Класс, управляющий светом
class Light {
  public void turnOn() {
      System.out.println("Свет включен");
  }

  public void turnOff() {
      System.out.println("Свет выключен");
  }
}

// Класс, управляющий температурой
class Thermostat {
  public void setTemperature(int temperature) {
      System.out.println("Температура установлена на " + temperature + "°C");
  }
}

// Класс, управляющий аудиосистемой
class AudioSystem {
  public void turnOn() {
      System.out.println("Аудиосистема включена");
  }

  public void turnOff() {
      System.out.println("Аудиосистема выключена");
  }

  public void playMusic() {
      System.out.println("Аудиосистема воспроизводит музыку");
  }
}

// Фасад — класс, который упрощает взаимодействие с системой
class HomeAutomationFacade {
  private Light light;
  private Thermostat thermostat;
  private AudioSystem audioSystem;

  public HomeAutomationFacade(Light light, Thermostat thermostat, AudioSystem audioSystem) {
      this.light = light;
      this.thermostat = thermostat;
      this.audioSystem = audioSystem;
  }

  // Метод для создания комфортной атмосферы (включение света, установка температуры и включение аудиосистемы)
  public void createComfortableEnvironment() {
      light.turnOn();
      thermostat.setTemperature(22);  // Устанавливаем комфортную температуру
      audioSystem.turnOn();
      audioSystem.playMusic();
  }

  // Метод для выключения всех устройств
  public void turnOffAll() {
      light.turnOff();
      audioSystem.turnOff();
      System.out.println("Все устройства выключены");
  }
}

// Главный класс для демонстрации паттерна Фасад
public class HomeAutomationFacadeTest {

  public static void main(String[] args) {
      // Создание объектов подсистем
      Light light = new Light();
      Thermostat thermostat = new Thermostat();
      AudioSystem audioSystem = new AudioSystem();

      // Создание фасада
      HomeAutomationFacade homeAutomation = new HomeAutomationFacade(light, thermostat, audioSystem);

      // Создание комфортной атмосферы
      homeAutomation.createComfortableEnvironment();
      System.out.println();

      // Выключение всех устройств
      homeAutomation.turnOffAll();
  }
}
