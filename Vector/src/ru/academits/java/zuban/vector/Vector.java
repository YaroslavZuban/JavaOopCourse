package ru.academits.java.zuban.vector;

import java.util.Arrays;

public class Vector {
    private int size;
    private double[] vector;



    Vector(int n) {//размерность n, все компоненты равны 0
        if (n <= 0) {
            doRisky();
        }

        vector = new double[n];
        this.size = n;

        for (int i = 0; i < size; i++) {
            this.vector[i] = 0;
        }
    }

    Vector(Vector vectorCopy) {//конструктор копирования
        this.size = vectorCopy.getSize();
        vector = new double[size];
        this.vector = Arrays.copyOf(vectorCopy.getVector(), size);
    }

    Vector(double[] array) {//заполнение вектора значениями из массив
        this.size = array.length;
        vector = new double[size];
        this.vector = Arrays.copyOf(array, size);
    }

    Vector(int n, double[] array) {//заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
        if (n <= 0) {
            doRisky();
        }

        this.size = array.length;
        vector = new double[size];

        for (int i = 0; i < n; i++) {
            if (array.length > n) {
                this.vector[i] = 0;
            }

            this.vector[i] = array[i];
        }
    }


    public double[] getVector() {//выдает массив, для копирования
        return vector;
    }

    public int getSize() {//получения размерности вектора
        return vector.length;
    }

    private void doRisky() throws IllegalArgumentException {//ввывод ошибки, решил перенести в отдельную функцию чтобы не дублировать код
        throw new IllegalArgumentException("Размерность меньше нуля! ");
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

    public double[] addition(Vector vec) {//сложение
        int indexMax = Math.max(getSize(), vec.getSize());
        int indexMin = Math.min(getSize(), vec.getSize());

        double[] array = new double[indexMax];

        if (getSize() == indexMax) {
            for (int i = 0; i < indexMax; i++) {
                if (i < indexMin) {
                    array[i] = vector[i];
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                array[i] += vec.getComponents(i);
            }
        } else {
            for (int i = 0; i < indexMax; i++) {
                if (i < indexMin) {
                    array[i] = vec.getComponents(i);
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                array[i] += vector[i];
            }
        }

        return array;
    }

    public double[] subtraction(Vector vec) {//вычитание
        int indexMax = Math.max(getSize(), vec.getSize());
        int indexMin = Math.min(getSize(), vec.getSize());

        double[] array = new double[indexMax];

        if (getSize() == indexMax) {
            for (int i = 0; i < indexMax; i++) {
                if (i < indexMin) {
                    array[i] = vector[i];
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                array[i] -= vec.getComponents(i);
            }
        } else {
            for (int i = 0; i < indexMax; i++) {
                if (i < indexMin) {
                    array[i] = vec.getComponents(i);
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < indexMax; i++) {
                array[i] -= vector[i];
            }
        }

        return array;
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

        Arrays.sort(this.vector);
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

    public void setComponents(int index, int number) {//установка нового числа по индексу
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

        if (vec1.getSize() == indexMax) {
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
        } else {
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
        }


        return new Vector(array);
    }
}