package ru.academits.java.zuban.Shape;

import java.util.Arrays;

public class ShapeProgram {
    public static void main(String[] args) {
        Shape[] arrayShape = {new Square(4), new Square(5), new Rectangle(2, 4),
                new Rectangle(2, 3), new Circle(4), new Circle(3), new Triangle(1, 2, 4, 5, 8, 9),
                new Triangle(2, 2, 4, 4, 7, 7)};

        double area = searchArea(arrayShape);
        System.out.println("Поиск фигуры с максимальной площадью. ");

        conclusionInformationShape(arrayShape, area);

        double perimeter = searchPerimeter(arrayShape);
        System.out.println("Поиск фигуры со вторым по величине периметром. ");

        conclusionInformationShape(arrayShape, perimeter);
    }

    public static double searchArea(Shape[] shape) {
        double maxArea = shape[0].getArea();

        for (int i = 1; i < shape.length; i++) {
            if (maxArea < shape[i].getArea()) {
                maxArea = shape[i].getArea();
            }
        }

        return maxArea;
    }

    public static double searchPerimeter(Shape[] shape) {
        double[] array = new double[shape.length];

        for (int i = 0; i < shape.length; i++) {
            array[i] = shape[i].getPerimeter();
        }

        Arrays.sort(array);
        return array[1];
    }

    public static void conclusionInformationShape(Shape[] shape, double number) {
        for (Shape value : shape) {
            if (number == value.getArea()) {
                System.out.println("Информация о фигуре: ");
                System.out.println("Длина фигуры равна: " + value.getHeight());
                System.out.println("Ширина фигуры равна: " + value.getWidth());
                System.out.println("Площадь фигуры равна: " + value.getArea());
                System.out.println("Периметр фигуры равен: " + value.getPerimeter());
            }
        }
    }
}
