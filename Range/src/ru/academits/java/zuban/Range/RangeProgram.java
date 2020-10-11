package ru.academits.java.zuban.Range;

import java.util.Scanner;

public class RangeProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range rangeInterval = new Range(2.36, 9.75);
        rangeInterval.print();

        System.out.print("Введите: ");
        double number1 = scanner.nextDouble();

        System.out.println("Пренадлежит ли чилу интервалу: " + rangeInterval.isInside(number1));

        System.out.println("  _Разность_");

        Range differenceInterval1 = new Range(2, 4);
        differenceInterval1.print();

        Range differenceInterval2 = new Range(3, 4);
        differenceInterval2.print();

        Range[] arrayDifferenceIntervals = differenceInterval1.gettingIntervalsDifferences(differenceInterval2);

        if (arrayDifferenceIntervals == null) {
            System.out.println("Итоговый интервал равен: " + null);
        } else {
            Range resultingDifference1 = new Range(arrayDifferenceIntervals[0].getFrom(), arrayDifferenceIntervals[0].getTo());
            resultingDifference1.printFinalInterval();

            if (arrayDifferenceIntervals.length <= 1) {

                System.out.print("Введите: ");
                double number2 = scanner.nextDouble();

                System.out.println("Пренадлежит ли заданному интервалу: " + resultingDifference1.isInside(number2));
            } else {
                Range resultingDifference2 = new Range(arrayDifferenceIntervals[1].getFrom(), arrayDifferenceIntervals[1].getTo());
                resultingDifference2.printFinalInterval();

                System.out.print("Введите: ");
                double number2 = scanner.nextDouble();

                if (resultingDifference1.isInside(number2)) {
                    System.out.println("Пренадлежит ли заданному интервалу: " + resultingDifference1.isInside(number2));
                } else {
                    System.out.println("Пренадлежит ли заданному интервалу: " + resultingDifference2.isInside(number2));
                }
            }
        }

        System.out.println("  _Обьединение_");

        Range UnionInterval1 = new Range(2, 4);
        UnionInterval1.print();

        Range UnionInterval2 = new Range(5, 6);
        UnionInterval2.print();

        Range[] arrayUnionIntervals = UnionInterval1.gettingIntervalsUnion(UnionInterval2);

        Range resultingUnion1 = new Range(arrayUnionIntervals[0].getFrom(), arrayUnionIntervals[0].getTo());
        resultingUnion1.printFinalInterval();

        if (arrayUnionIntervals.length <= 1) {
            System.out.print("Введите: ");
            double number3 = scanner.nextDouble();

            System.out.println("Пренадлежит ли заданному интервалу: " + resultingUnion1.isInside(number3));
        } else {
            Range resultingUnion2 = new Range(arrayUnionIntervals[1].getFrom(), arrayUnionIntervals[1].getTo());
            resultingUnion2.printFinalInterval();

            System.out.print("Введите: ");
            double number3 = scanner.nextDouble();

            if (resultingUnion1.isInside(number3)) {
                System.out.println("Пренадлежит ли заданному интервалу: " + resultingUnion1.isInside(number3));
            } else {
                System.out.println("Пренадлежит ли заданному интервалу: " + resultingUnion2.isInside(number3));
            }
        }

        System.out.println("  _Пересечение_");

        Range CrossingInterval1 = new Range(2, 4);
        CrossingInterval1.print();

        Range CrossingInterval2 = new Range(5, 6);
        CrossingInterval2.print();

        Range[] arrayCrossingIntervals = CrossingInterval1.gettingIntervalsCrossing(CrossingInterval2);

        if (arrayCrossingIntervals == null) {
            System.out.println("Интервал равен: " + null);
        } else {
            Range resultingCrossing2 = new Range(arrayCrossingIntervals[0], arrayCrossingIntervals[1]);
            resultingCrossing2.printFinalInterval();

            System.out.print("Введите: ");
            double number4 = scanner.nextDouble();

            System.out.println("Пренадлежит ли заданному интервалу: " + resultingCrossing2.isInside(number4));
        }
    }
}