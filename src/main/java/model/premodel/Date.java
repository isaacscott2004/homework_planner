package model.premodel;
import java.time.LocalDate;
import java.time.Month;
import java.time.DateTimeException;
import java.util.Objects;

public class Date {
    private final LocalDate date;

    public Date(Month month, int day, int year) {
        try {
            this. date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new InvalidDateException("Invalid date: " + month + " " + day + ", " + year);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Date date1)) return false;
        return Objects.equals(date, date1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date);
    }

    @Override
    public String toString() {
        return this.date.toString();
    }
}
