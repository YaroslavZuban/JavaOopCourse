package ru.academits.java.zuban;

import java.util.Scanner;

public class RangeProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Range rangeInterval = new Range(2.36, 9.75);
        rangeInterval.print();

        System.out.print("Введите: ");
        double number1 = scanner.nextDouble();

        System.out.println("Пренадлежит ли чилу интервалу: " + rangeInterval.isInside(number1));

        //разность
        System.out.println("  _Разность_");
        Range r1 = new Range(2, 4);
        r1.print();

        Range r2 = new Range(3, 4);
        r2.print();

        Range[] array6 = r1.gettingIntervalsDifferences(r2);

        if (array6 == null) {
            System.out.println("Итоговый интервал равен: " + null);
        } else {
            Range r3 = new Range(array6[0].getFrom(),array6[0].getTo());
            r3.printFinalInterval();

            if (array6.length <= 1) {

                System.out.print("Введите: ");
                double number2 = scanner.nextDouble();

                System.out.println("Пренадлежит ли заданному интервалу: " + r3.isInside(number2));
            } else {
                Range r9 = new Range(array6[1].getFrom(),array6[1].getTo());
                r9.printFinalInterval();

                System.out.print("Введите: ");
                double number2 = scanner.nextDouble();

                if (r3.isInside(number2)) {
                    System.out.println("Пренадлежит ли заданному интервалу: " + r3.isInside(number2));
                } else {
                    System.out.println("Пренадлежит ли заданному интервалу: " + r9.isInside(number2));
                }
            }
        }
        
        System.out.println("  _Обьединение_");

        Range r4= new Range(2, 4);
        r4.print();

        Range r5 = new Range(5, 6);
        r5.print();

        Range[] array=r4.gettingIntervalsUnion(r5);

        Range r6 = new Range(array[0].getFrom(),array[0].getTo());
        r6.printFinalInterval();

        if (array.length<=1) {
            System.out.print("Введите: ");
            double number3 = scanner.nextDouble();

            System.out.println("Пренадлежит ли заданному интервалу: " + r6.isInside(number3));
        }else {
            Range r7 = new Range(array[1].getFrom(),array[1].getTo());
            r7.printFinalInterval();

            System.out.print("Введите: ");
            double number3 = scanner.nextDouble();

            if (r6.isInside(number3)) {
                System.out.println("Пренадлежит ли заданному интервалу: " + r6.isInside(number3));
            }else{
                System.out.println("Пренадлежит ли заданному интервалу: " + r7.isInside(number3));
            }
        }


        //пересечение

        System.out.println("  _Пересечение_");

        Range r10 = new Range(2, 4);
        r10.print();

        Range r8 = new Range(5, 6);
        r8.print();

        Range[] array3=r10.gettingIntervalsCrossing(r8);

        if (array3==null) {
        System.out.println("Интервал равен: "+ null);
        }else{
            Range r11 = new Range(array3[0], array3[1]);
            r11.printFinalInterval();

            System.out.print("Введите: ");
            double number4= scanner.nextDouble();

            System.out.println("Пренадлежит ли заданному интервалу: " + r11.isInside(number4));
        }
    }
}