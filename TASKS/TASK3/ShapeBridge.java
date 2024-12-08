package TASK3;
public class ShapeBridge {

  // Абстракция устройства вывода
  public interface OutputDevice {
      void display(String shape);
  }

  // Конкретные устройства вывода
  public static class Monitor implements OutputDevice {
      @Override
      public void display(String shape) {
          System.out.println("Отображаем " + shape + " на мониторе");
      }
  }

  public static class Printer implements OutputDevice {
      @Override
      public void display(String shape) {
          System.out.println("Печатаем " + shape + " на принтере");
      }
  }

  public static class Plotter implements OutputDevice {
      @Override
      public void display(String shape) {
          System.out.println("Рисуем " + shape + " на плоттере");
      }
  }

  // Абстракция фигуры
  public interface Shape {
      void draw();
  }

  // Конкретные фигуры
  public static class Circle implements Shape {
      private OutputDevice outputDevice;

      public Circle(OutputDevice outputDevice) {
          this.outputDevice = outputDevice;
      }

      @Override
      public void draw() {
          outputDevice.display("круг");
      }
  }

  public static class Square implements Shape {
      private OutputDevice outputDevice;

      public Square(OutputDevice outputDevice) {
          this.outputDevice = outputDevice;
      }

      @Override
      public void draw() {
          outputDevice.display("квадрат");
      }
  }

  public static class Triangle implements Shape {
      private OutputDevice outputDevice;

      public Triangle(OutputDevice outputDevice) {
          this.outputDevice = outputDevice;
      }

      @Override
      public void draw() {
          outputDevice.display("треугольник");
      }
  }

  // Главный метод
  public static void main(String[] args) {
      // Создаём устройства вывода
      OutputDevice monitor = new Monitor();
      OutputDevice printer = new Printer();
      OutputDevice plotter = new Plotter();

      // Создаём фигуры и выводим их на разных устройствах
      System.out.println("Отображение на мониторе:");
      Shape circle = new Circle(monitor);
      circle.draw();

      Shape square = new Square(monitor);
      square.draw();

      Shape triangle = new Triangle(monitor);
      triangle.draw();

      System.out.println("\nОтображение на принтере:");
      circle = new Circle(printer);
      circle.draw();

      square = new Square(printer);
      square.draw();

      triangle = new Triangle(printer);
      triangle.draw();

      System.out.println("\nОтображение на плоттере:");
      circle = new Circle(plotter);
      circle.draw();

      square = new Square(plotter);
      square.draw();

      triangle = new Triangle(plotter);
      triangle.draw();
  }
}
