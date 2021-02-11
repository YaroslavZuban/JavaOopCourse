package ru.academits.java.zuban.Shape;

import java.util.Objects;

public class Square implements Shape {
    private final double width;

   public Square(double width) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                '}';
    }
}