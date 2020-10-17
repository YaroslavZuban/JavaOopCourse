package ru.academits.java.zuban.Shape;

class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getWidth() {
        double[] array = {x1, x2, x3};
        double min = array[0];
        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        return max - min;
    }

    public double getHeight() {
        double[] array = {y1, y2, y3};
        double min = array[0];
        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        return max - min;
    }

    private double[] searchTriangleSides() {
        final double epsilon = 1.0e-10;

        if (Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) <= epsilon) {
            return null;
        } else {
            double[] array = new double[3];

            array[0] = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            array[1] = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
            array[2] = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));

            return array;
        }
    }

    public double getArea() {
        double[] array = searchTriangleSides();

        if (array != null) {
            double halfPerimeter = (array[0] + array[1] + array[2]) / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - array[0]) * (halfPerimeter - array[1]) * (halfPerimeter - array[2]));
        }

        return 0;
    }

    public double getPerimeter() {
        double[] array = searchTriangleSides();

        if (array != null) {
            double perimeter = 0;
            for (double e : array) {
                perimeter = +e;
            }

            return perimeter;
        }

        return 0;
    }
}