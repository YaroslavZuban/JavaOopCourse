package ru.academits.java.zuban.Shape;

class Square implements Shape {
    private final double width;

    Square(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * width;
    }

    public double getPerimeter() {
        return 4 * width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return 0;
    }
}