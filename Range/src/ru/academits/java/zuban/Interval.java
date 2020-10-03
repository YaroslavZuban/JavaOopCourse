package ru.academits.java.zuban;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Range range = new Range();

        Scanner scanner = new Scanner(System.in);

        range.setFrom(2.36);
        System.out.println("Начало интервала: " + range.getFrom());

        range.setTo(9.75);
        System.out.println("Конец интревала: " + range.getTo());

        System.out.println("Длина диапозона равна: " + range.findingLength());

        System.out.print("Введите: ");
        double number = scanner.nextDouble();

        System.out.println("Пренадлежит ли чилу интервалу: " + range.isInside(number));
    }
}
