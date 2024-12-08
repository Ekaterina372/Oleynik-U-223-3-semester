package TASK12;

import java.util.ArrayList;
import java.util.List;

// Интерфейс для графических объектов
interface Graphic {
    void draw(); // Метод для рисования объекта
}

// Простая фигура Circle (круг), реализующая интерфейс Graphic
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Рисуем Круг");
    }
}

// Простая фигура Square (квадрат), реализующая интерфейс Graphic
class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Рисуем Квадрат");
    }
}

// Простая фигура Triangle (треугольник), реализующая интерфейс Graphic
class Triangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Рисуем Треугольник");
    }
}

// Класс, представляющий составной графический объект (может содержать другие объекты)
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    // Метод для добавления графического объекта в составной
    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    // Метод для удаления графического объекта из составного
    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    // Метод для рисования всех объектов в составе
    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw(); // Рисуем каждый объект
        }
    }
}

// Главный класс для демонстрации паттерна Компоновщик
public class CompositePattern {

    public static void main(String[] args) {
        // Создание простых объектов
        Graphic circle = new Circle();
        Graphic square = new Square();
        Graphic triangle = new Triangle();

        // Создание составного объекта
        CompositeGraphic composite = new CompositeGraphic();
        composite.add(circle);
        composite.add(square);
        composite.add(triangle);

        // Рисование составного объекта
        System.out.println("Рисуем составной объект:");
        composite.draw();

        // Создание еще одного составного объекта, содержащего другие составные объекты
        CompositeGraphic composite2 = new CompositeGraphic();
        composite2.add(circle);
        composite2.add(composite);

        // Рисование второго составного объекта
        System.out.println("\nРисуем второй составной объект:");
        composite2.draw();
    }
}
