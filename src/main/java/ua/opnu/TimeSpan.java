package ua.opnu;

public class TimeSpan {

    private int totalMinutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.totalMinutes = 0;
        } else {
            this.totalMinutes = hours * 60 + minutes;
        }
    }

    public int getHours() {
        return totalMinutes / 60;
    }

    public int getMinutes() {
        return totalMinutes % 60;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            return;
        }
        this.totalMinutes += hours * 60 + minutes;
    }

    public void addTimeSpan(TimeSpan timespan) {
        if (timespan != null) {
            this.totalMinutes += timespan.totalMinutes;
        }
    }

    public double getTotalHours() {
        return (double) totalMinutes / 60.0;
    }

    public int getTotalMinutes() {
        return this.totalMinutes;
    }

    public void subtract(TimeSpan span) {
        if (span != null && this.totalMinutes >= span.totalMinutes) {
            this.totalMinutes -= span.totalMinutes;
        }

    }

    public void scale(int factor) {
        if (factor > 0) {
            this.totalMinutes *= factor;
        }

    }
}