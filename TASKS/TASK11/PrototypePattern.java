package TASK11;

// Интерфейс для графических фигур
interface Shape {
  Shape clone();  // Метод для клонирования фигуры
  void draw();    // Метод для рисования фигуры
}

// Класс Circle (круг), реализующий интерфейс Shape
class Circle implements Shape {
  private String type = "Круг";

  @Override
  public Shape clone() {
      return new Circle();
  }

  @Override
  public void draw() {
      System.out.println("Рисуем " + type);
  }
}

// Класс Square (квадрат), реализующий интерфейс Shape
class Square implements Shape {
  private String type = "Квадрат";

  @Override
  public Shape clone() {
      return new Square();
  }

  @Override
  public void draw() {
      System.out.println("Рисуем " + type);
  }
}

// Класс Triangle (треугольник), реализующий интерфейс Shape
class Triangle implements Shape {
  private String type = "Треугольник";

  @Override
  public Shape clone() {
      return new Triangle();
  }

  @Override
  public void draw() {
      System.out.println("Рисуем " + type);
  }
}

// Главный класс для демонстрации паттерна Прототип
public class PrototypePattern {

  public static void main(String[] args) {
      // Создание исходных объектов фигур
      Shape circle = new Circle();
      Shape square = new Square();
      Shape triangle = new Triangle();

      // Клонирование фигур
      Shape clonedCircle = circle.clone();
      Shape clonedSquare = square.clone();
      Shape clonedTriangle = triangle.clone();

      // Рисование оригинальных и клонированных фигур
      System.out.println("Оригинальные фигуры:");
      circle.draw();
      square.draw();
      triangle.draw();

      System.out.println("\nКлонированные фигуры:");
      clonedCircle.draw();
      clonedSquare.draw();
      clonedTriangle.draw();
  }
}
