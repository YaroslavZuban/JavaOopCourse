package ru.academits.java.zuban.vector;

import java.util.Arrays;

public class Vector {
    private int size;
    private double[] vector;

    Vector(int n) {//размерность n, все компоненты равны  0
        doRisky(n);

        vector = new double[n];
        this.size = n;
    }

    Vector(Vector vectorCopy) {//конструктор копирования
        this.size = vectorCopy.getSize();
        vector = new double[size];

        for (int i = 0; i < size; i++) {
            this.vector[i] = vectorCopy.getComponents(i);
        }
    }

    Vector(double[] array) {//заполнение вектора значениями из массив
        this.size = array.length;
        vector = new double[size];

        System.arraycopy(array, 0, this.vector, 0, size);
    }

    Vector(int n, double[] array) {//заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
        doRisky(n);

        this.size = array.length;

        if (n > array.length) {
            vector = new double[n];
            for (int i = 0; i < n; i++) {
                if (array.length > i) {
                    this.vector[i] = array[i];

                } else {
                    this.vector[i] = 0;
                }
            }
        } else {
            vector = new double[n];
            System.arraycopy(array, 0, this.vector, 0, n);
        }
    }

    public double[] getVector() {//выдает массив, для копирования
        return vector;
    }

    public int getSize() {//получения размерности вектора
        return vector.length;
    }

    private void doRisky(int n) throws IllegalArgumentException {//ввывод ошибки, решил перенести в отдельную функцию чтобы не дублировать код
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность меньше нуля! ");
        }
    }

    @Override
    public String toString() {//переопределил метод вывода вектора
        return Arrays.toString(vector);
    }

    public boolean equals(Vector vec) {
        return (getSize() == vec.getSize() && hashCode() == vec.hashCode());
    }

    @Override
    public int hashCode() {
        if (vector == null) {
            return 0;
        }

        final int prime = 37;
        int result = 1;
        result = prime * result + size;

        for (double arr : vector) {
            long longBits = Double.doubleToLongBits(arr);
            result = prime * result + (int) (longBits - (longBits >>> 32));
        }

        return result;
    }

    public Vector addition(Vector vec) {//сложение
        int indexMax = Math.max(getSize(), vec.getSize());
        Vector number;

        if (vec.getSize() >= getSize()) {
            number = new Vector(indexMax, getVector());

            for (int i = 0; i < indexMax; i++) {
                double sum = number.getComponents(i) + vec.getComponents(i);
                number.setComponents(i, sum);
            }
        } else {
            number = new Vector(indexMax, vec.getVector());

            for (int i = 0; i < indexMax; i++) {
                double sum = number.getComponents(i) + getComponents(i);
                number.setComponents(i, sum);
            }
        }

        return number;
    }

    public Vector subtraction(Vector vec) {//вычитание
        int indexMax = Math.max(getSize(), vec.getSize());
        Vector number;

        if (vec.getSize() >= getSize()) {
            number = new Vector(indexMax, getVector());

            for (int i = 0; i < indexMax; i++) {
                double sum = number.getComponents(i) - vec.getComponents(i);
                number.setComponents(i, sum);
            }
        } else {
            number = new Vector(indexMax, vec.getVector());

            for (int i = 0; i < indexMax; i++) {
                double sum = number.getComponents(i) - getComponents(i);
                number.setComponents(i, sum);
            }
        }

        return number;
    }


    public void multiplicationScalar(int multiplier) {//умножение на скаляр
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] *= multiplier;
        }
    }

    public void reversal() {// умножение вектора на -1
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] *= -1;
        }
    }

    public double getLength() {//получение длинный вектора
        double sumVariables = 0;

        for (double mas : vector) {
            sumVariables += Math.pow(mas, 2);
        }

        return Math.sqrt(sumVariables);
    }

    public double getComponents(int index) {//получение ячейки массива по индексу
        return vector[index];
    }

    public void setComponents(int index, double number) {//установка нового числа по индексу
        this.vector[index] = number;
    }

    public static Vector addition(Vector vec1, Vector vec2) {//Сложение двух векторов – должен создаваться новый вектор
        vec1.addition(vec2);
        return new Vector(vec1);
    }

    public static Vector subtraction(Vector vec1, Vector vec2) {//Вычитание векторов – должен создаваться новый вектор
        vec1.subtraction(vec2);
        return new Vector(vec1);
    }

    public static Vector productScalar(Vector vec1, Vector vec2) {//Скалярное произведение векторов
        int indexMax = Math.max(vec1.getSize(), vec2.getSize());
        int indexMin = Math.min(vec1.getSize(), vec2.getSize());

        double[] array = new double[indexMax];

        if (vec1.getSize() == indexMax && vec1.getSize() != indexMin) {
            for (int i = 0; i < indexMax; i++) {
                if (i < indexMin) {
                    array[i] = vec1.vector[i];
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                array[i] *= vec2.getComponents(i);
            }
        } else if (vec2.getSize() == indexMax && vec2.getSize() != indexMin) {
            for (int i = 0; i < indexMax; i++) {
                if (i < indexMin) {
                    array[i] = vec2.getComponents(i);
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                array[i] *= vec1.vector[i];
            }
        } else {
            for (int i = 0; i < indexMax; i++) {
                array[i] = vec1.vector[i] * vec2.vector[i];
            }
        }

        return new Vector(array);
    }

    private double[] arrayPlusNull(int size) {
        double[] arrayNew = new double[size];

        for (int i = 0; i < size; i++) {
            if (i < vector.length) {
                arrayNew[i] = vector[i];
            } else {
                arrayNew[i] = 0;
            }
        }

        return arrayNew;
    }
}