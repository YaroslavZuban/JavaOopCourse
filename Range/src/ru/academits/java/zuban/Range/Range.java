package ru.academits.java.zuban.Range;

class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range(Range range, Range range1) {

    }

    public void print() {
        System.out.println("Интервал равен: ");
        System.out.println("От: " + from);
        System.out.println("До: " + to);
    }

    public void printFinalInterval() {
        System.out.println("Итоговый интервал равен: ");
        System.out.println("От: " + from);
        System.out.println("До: " + to);
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

    public double findingLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        if (from < number && number < to) {
            return true;
        } else {
            return false;
        }
    }

    public Range[] gettingIntervalsCrossing(Range range) {//пересечение
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

    public Range[] gettingIntervalsUnion(Range range) {//обьединение
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

    public Range[] gettingIntervalsDifferences(Range range) {//разность
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
