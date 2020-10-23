package ru.academits.java.zuban.Shape;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeProgram {
    public static void main(String[] args) {
        Shape[] arrayShape = {new Square(4), new Square(5), new Rectangle(2, 4),
                new Rectangle(2, 3), new Circle(4), new Circle(3), new Triangle(1, 2, 4, 5, 8, 9),
                new Triangle(2, 2, 4, 4, 7, 7)};

        System.out.println("Поиск фигуры с максимальной площадью. ");
        conclusionInformationArea(arrayShape);

        System.out.println();

        System.out.println("Поиск фигуры со вторым по величине периметром. ");
        conclusionInformationPerimeter(arrayShape);
    }

    public static void conclusionInformationArea(Shape[] shape) {
        Arrays.sort(shape, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.getArea()-o2.getArea());
            }
        });
        System.out.println("Информация о фигуре: ");
        System.out.println("Длина фигуры равна: " +shape[shape.length-1].getHeight());
        System.out.println("Ширина фигуры равна: " + shape[shape.length-1].getWidth());
        System.out.println("Площадь фигуры равна: " +shape[shape.length-1].getArea());
        System.out.println("Периметр фигуры равен: " +shape[shape.length-1].getPerimeter());
    }

    public static void conclusionInformationPerimeter(Shape[] shape) {
        Arrays.sort(shape, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.getPerimeter()-o2.getPerimeter());
            }
        });
        System.out.println("Информация о фигуре: ");
        System.out.println("Длина фигуры равна: " +shape[shape.length-2].getHeight());
        System.out.println("Ширина фигуры равна: " + shape[shape.length-2].getWidth());
        System.out.println("Площадь фигуры равна: " +shape[shape.length-2].getArea());
        System.out.println("Периметр фигуры равен: " +shape[shape.length-2].getPerimeter());
    }
}
