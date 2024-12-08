package TASK4;

public class SmartHomeAdapter {

  // Интерфейс для старых устройств
  public interface OldDevice {
      void turnOn();
      void turnOff();
  }

  // Интерфейс для новых устройств
  public interface NewDevice {
      void activate();
      void deactivate();
  }

  // Старое устройство: обычная розетка
  public static class OldSocket implements OldDevice {
      @Override
      public void turnOn() {
          System.out.println("Старая розетка включена.");
      }

      @Override
      public void turnOff() {
          System.out.println("Старая розетка выключена.");
      }
  }

  // Новое устройство: умная розетка
  public static class SmartSocket implements NewDevice {
      @Override
      public void activate() {
          System.out.println("Умная розетка активирована.");
      }

      @Override
      public void deactivate() {
          System.out.println("Умная розетка деактивирована.");
      }
  }

  // Адаптер для старых устройств, чтобы они могли работать с новыми устройствами
  public static class SmartSocketAdapter implements OldDevice {
      private final NewDevice newDevice;

      public SmartSocketAdapter(NewDevice newDevice) {
          this.newDevice = newDevice;
      }

      @Override
      public void turnOn() {
          newDevice.activate();
      }

      @Override
      public void turnOff() {
          newDevice.deactivate();
      }
  }

  // Главный метод
  public static void main(String[] args) {
      // Создаём старое устройство (старую розетку)
      OldDevice oldSocket = new OldSocket();
      oldSocket.turnOn();
      oldSocket.turnOff();

      // Создаём новое устройство (умную розетку)
      NewDevice smartSocket = new SmartSocket();

      // Адаптируем старую розетку к новому интерфейсу
      OldDevice adaptedSmartSocket = new SmartSocketAdapter(smartSocket);
      adaptedSmartSocket.turnOn();
      adaptedSmartSocket.turnOff();
  }
}
