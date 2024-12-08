public class CarFactorySystem {

  // Интерфейсы для компонентов автомобиля
  public interface Engine {
      void createEngine();
  }

  public interface Wheel {
      void createWheel();
  }

  public interface Body {
      void createBody();
  }

  // Абстрактная фабрика
  public interface CarPartsFactory {
      Engine createEngine();
      Wheel createWheel();
      Body createBody();
  }

  // Компоненты для BMW
  public static class BMWEngine implements Engine {
      @Override
      public void createEngine() {
          System.out.println("Создаём двигатель для BMW");
      }
  }

  public static class BMWWheel implements Wheel {
      @Override
      public void createWheel() {
          System.out.println("Создаём колёса для BMW");
      }
  }

  public static class BMWBody implements Body {
      @Override
      public void createBody() {
          System.out.println("Создаём кузов для BMW");
      }
  }

  // Компоненты для Audi
  public static class AudiEngine implements Engine {
      @Override
      public void createEngine() {
          System.out.println("Создаём двигатель для Audi");
      }
  }

  public static class AudiWheel implements Wheel {
      @Override
      public void createWheel() {
          System.out.println("Создаём колёса для Audi");
      }
  }

  public static class AudiBody implements Body {
      @Override
      public void createBody() {
          System.out.println("Создаём кузов для Audi");
      }
  }

  // Конкретные фабрики для BMW и Audi
  public static class BMWFactory implements CarPartsFactory {
      @Override
      public Engine createEngine() {
          return new BMWEngine();
      }

      @Override
      public Wheel createWheel() {
          return new BMWWheel();
      }

      @Override
      public Body createBody() {
          return new BMWBody();
      }
  }

  public static class AudiFactory implements CarPartsFactory {
      @Override
      public Engine createEngine() {
          return new AudiEngine();
      }

      @Override
      public Wheel createWheel() {
          return new AudiWheel();
      }

      @Override
      public Body createBody() {
          return new AudiBody();
      }
  }

  // Главный метод
  public static void main(String[] args) {
      // Создаём фабрики для BMW и Audi
      CarPartsFactory bmwFactory = new BMWFactory();
      CarPartsFactory audiFactory = new AudiFactory();

      // Производим компоненты для BMW
      System.out.println("Производство BMW:");
      Engine bmwEngine = bmwFactory.createEngine();
      Wheel bmwWheel = bmwFactory.createWheel();
      Body bmwBody = bmwFactory.createBody();

      bmwEngine.createEngine();
      bmwWheel.createWheel();
      bmwBody.createBody();

      System.out.println();

      // Производим компоненты для Audi
      System.out.println("Производство Audi:");
      Engine audiEngine = audiFactory.createEngine();
      Wheel audiWheel = audiFactory.createWheel();
      Body audiBody = audiFactory.createBody();

      audiEngine.createEngine();
      audiWheel.createWheel();
      audiBody.createBody();
  }
}
