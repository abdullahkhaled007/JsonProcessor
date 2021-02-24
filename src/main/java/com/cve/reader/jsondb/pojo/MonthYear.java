package com.cve.reader.jsondb.pojo;

import java.text.DateFormatSymbols;
import java.util.Objects;

public class MonthYear implements Comparable<MonthYear> {
    private final int month;
    private final int year;

    private final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

    public MonthYear(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


    @Override
    public int compareTo(MonthYear o) {
        if (this.year == o.year) {
            return Integer.compare(this.month, o.month);
        } else {
            return Integer.compare(this.year, o.year);
        }
    }

    @Override
    public String toString() {
        String month = dateFormatSymbols.getMonths()[this.month - 1];
        return month + " " + this.year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthYear)) return false;
        MonthYear monthYear = (MonthYear) o;
        return getMonth() == monthYear.getMonth() && getYear() == monthYear.getYear() && Objects.equals(dateFormatSymbols, monthYear.dateFormatSymbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonth(), getYear(), dateFormatSymbols);
    }
}
