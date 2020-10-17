package ru.academits.java.zuban.Shape;

class Square implements Shape {
    private final double width;

    Square(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return 0;
    }
}
