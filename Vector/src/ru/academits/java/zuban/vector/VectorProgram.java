package ru.academits.java.zuban.vector;

public class VectorProgram {
    public static void main(String[] args) {
        double[] arrayTest = {2, 3, 5, 6, 9, 7, 5};
        Vector test = new Vector(arrayTest);

        System.out.println("Начианем тестировать код: \n Программа _1_: ");
        Vector vector = new Vector(8);
        String line = vector.toString();
        System.out.println(line);
        System.out.println("Размерноть равна 8 следовательно данный вектор: " + vector.getSize());

        System.out.println("Программа _2_: ");
        try {
            Vector vector1 = new Vector(-2);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка произошла! Поздравляю! ");
        } finally {
            System.out.println();
        }

        System.out.println("Программа _3_: ");

        Vector vector2 = new Vector(vector);
        String line2 = vector2.toString();
        System.out.println(line2);
        System.out.println("Размерноть равна 8 следовательно данный вектор: " + vector2.getSize());

        System.out.println("Программа _4_: ");

        double[] arrayTest3 = {1, 1, 1, 1};
        Vector vector3 = new Vector(6, arrayTest3);

        String line3 = vector3.toString();
        System.out.println(line3);

        Vector vectorArray = new Vector(vector3.addition(test));
        System.out.println("Прибавление: " + vectorArray.toString());

        Vector vectorArray1 = new Vector(vector3.subtraction(test));
        System.out.println("Вычитание: " + vectorArray1.toString());

        System.out.println("Программа _5_: ");

        double[] arrayTest4 = {1, 1, 1, 1};
        Vector vector4 = new Vector(4, arrayTest4);

        vector4.multiplicationScalar(2);
        System.out.println("Скалярная умножение: " + vector4.toString());

        vector4.reversal();
        System.out.println("Умноженние на -1(разворот): " + vector4.toString());

        System.out.println("Программа _6_: ");

        double[] arrayTest5 = {1, 2, 1, 1};
        Vector vector5 = new Vector(3, arrayTest5);

        System.out.println("Получение длинны вектора: " + vector5.getLength());

        System.out.println("Получение по индексу: " + vector5.getComponents(1));

        vector5.setComponents(1, 0);
        System.out.println("Установка и получение по индексу: " + vector5.getComponents(1));
    }
}
