package ru.academits.java.zuban.matrix;

import java.util.Scanner;
import java.util.Vector;

public class Matrix  {
    private double[][] matrix;
    private int length;

    Matrix(int n,int m){
        matrix=new double[n][m];
    }

    Matrix(Matrix mat){

    }

    Matrix(double[][] mat){

    }

    Matrix(Vector vector){

    }

    public void getDimensionMatrix(){//получение размерности матрицы
        doRisky(matrix.length);
        System.out.println("Размерность матрицы ровна: "+matrix.length+" * "+matrix[0].length);
    }

    public void getStringVector(int index){//получение вектора строк
        doRisky(index);
        System.out.print("Вектор строки равен:");

        for(int i=0;i<matrix.length;i++){
            System.out.print(" "+matrix[index][i]);
        }

        System.out.println();
    }

    public double[] setStringVector(int index){
        Scanner scanner=new Scanner(System.in);
        doRisky(index);
        int count=0;
        double[] array=new double[matrix.length];
        System.out.println("Задайте значения строки:");

        while (count!=matrix.length){
            matrix[index][count]=scanner.nextDouble();
            array[count]=matrix[index][count];
            count++;
        }

        return array;
    }

    public void getColumnVector(int index){
        doRisky(index);
        System.out.print("Вектор столбца равен:");

        for(int i=0;i<matrix[index].length;i++){
            System.out.print(" "+matrix[i][index]);
        }

        System.out.println();
    }

    private void doRisky(int n) throws IllegalArgumentException {//ввывод ошибки, решил перенести в отдельную функцию чтобы не дублировать код
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность меньше нуля! ");
        }
    }
}
