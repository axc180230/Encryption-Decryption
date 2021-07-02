//public class Main {
//    public static void main(String[] args) {
////        Circle circle = new Circle(10);
////        System.out.println(circle.getPerimeter());
////        System.out.println(circle.getArea());
//
////        Triangle triangle = new Triangle(3, 4, 5);
////        System.out.println(triangle.getPerimeter());
////        System.out.println(triangle.getArea());
//
////        Rectangle rectangle = new Rectangle(5, 10);
////        System.out.println(rectangle.getPerimeter());
////        System.out.println(rectangle.getArea());
//    }
//}

abstract class Shape {

    abstract double getPerimeter();
    abstract double getArea();
}

class Triangle extends Shape {
    double side1;
    double side2;
    double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double area = this.getPerimeter() / 2.0d;
        return Math.sqrt(area * (area - side1) * (area - side2) * (area - side3));
    }
}

class Rectangle extends Shape {
    double side1;
    double side2;

    public Rectangle(double side1, double s2) {
        this.side1 = side1;
        this.side2 = s2;
    }

    public double getPerimeter() {
        return (side1 + side2) * 2;
    }

    public double getArea() {
        return side1 * side2;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}





