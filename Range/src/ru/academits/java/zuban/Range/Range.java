package ru.academits.java.zuban.Range;

class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void print() {
        System.out.print("Интервал равен: ");
        System.out.println("("+from+"; "+to+") ");
    }

    public void printFinalInterval() {
        System.out.print("Итоговый интервал равен: ");
        System.out.println("("+from+"; "+to+") ");
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        if (from <= number && number <= to) {
            return true;
        }

        return false;
    }

    public Range[] getIntersection(Range range) {//пересечение
        if (from < range.from && to < range.to && range.from < to) {
            return new Range[]{new Range(range.from, to)};
        } else if (from > range.from && to > range.to && from < range.to) {
            return new Range[]{new Range(from, range.to)};
        } else if (from < range.from && to > range.to) {
            return new Range[]{new Range(range.from, range.to)};
        } else if (to < range.from || from > range.to) {
            return null;
        }

        return null;
    }

    public Range[] getUnion(Range range) {//обьединение
        if (from >= range.from && to >= range.to && from <= range.to) {
            return new Range[]{new Range(range.from, to)};
        } else if (from <= range.from && to <= range.to && to >= range.from) {
            return new Range[]{new Range(from, range.to)};
        } else if (to <= range.from || from >= range.to) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else if (to <= range.to && from >= range.from) {
            return new Range[]{new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(from, to)};
        }
    }

    public Range[] getDifferences(Range range) {//разность
        if (from > range.from && to > range.to && from < range.to) {
            return new Range[]{new Range(range.to, to)};
        } else if (from < range.from && to < range.to && to > range.from) {
            return new Range[]{new Range(from, range.from)};
        } else if (from <= range.from && to >= range.to) {
            if (to == range.to && range.from == from) {
                return null;
            } else {
                return new Range[]{new Range(from, range.from)};
            }
        } else {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }
    }
}
