public class GeometrySystem {

    // Интерфейс для фигур
    public interface Shape {
        void draw();  // Метод для рисования фигуры
        double area(); // Метод для вычисления площади
    }

    // Класс Circle (круг)
    public static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Рисуем круг с радиусом " + radius);
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    // Класс Triangle (треугольник)
    public static class Triangle implements Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public void draw() {
            System.out.println("Рисуем треугольник с основанием " + base + " и высотой " + height);
        }

        @Override
        public double area() {
            return 0.5 * base * height;
        }
    }

    // Класс Rectangle (прямоугольник)
    public static class Rectangle implements Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public void draw() {
            System.out.println("Рисуем прямоугольник с длиной " + length + " и шириной " + width);
        }

        @Override
        public double area() {
            return length * width;
        }
    }

    // Абстрактный класс ShapeFactory
    public abstract static class ShapeFactory {
        public abstract Shape createShape();
    }

    // Фабрика для круга
    public static class CircleFactory extends ShapeFactory {
        private double radius;

        public CircleFactory(double radius) {
            this.radius = radius;
        }

        @Override
        public Shape createShape() {
            return new Circle(radius);
        }
    }

    // Фабрика для треугольника
    public static class TriangleFactory extends ShapeFactory {
        private double base;
        private double height;

        public TriangleFactory(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public Shape createShape() {
            return new Triangle(base, height);
        }
    }

    // Фабрика для прямоугольника
    public static class RectangleFactory extends ShapeFactory {
        private double length;
        private double width;

        public RectangleFactory(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public Shape createShape() {
            return new Rectangle(length, width);
        }
    }

    // Главный класс для тестирования
    public static void main(String[] args) {
        // Создаем фабрики для разных фигур
        ShapeFactory circleFactory = new CircleFactory(5);
        ShapeFactory triangleFactory = new TriangleFactory(6, 4);
        ShapeFactory rectangleFactory = new RectangleFactory(7, 3);

        // Создаем фигуры
        Shape circle = circleFactory.createShape();
        Shape triangle = triangleFactory.createShape();
        Shape rectangle = rectangleFactory.createShape();

        // Рисуем и выводим площади
        circle.draw();
        System.out.println("Площадь круга: " + circle.area());

        triangle.draw();
        System.out.println("Площадь треугольника: " + triangle.area());

        rectangle.draw();
        System.out.println("Площадь прямоугольника: " + rectangle.area());
    }
}
