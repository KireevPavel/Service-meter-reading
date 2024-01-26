package model;

import java.util.Objects;

public class WaterMeter {
    int id;
    double volume;
    int month;
    int year;
    boolean hot;
    User user;

    public WaterMeter(int id, double volume, int month, int year, boolean hot, User user) {
        this.id = id;
        this.volume = volume;
        this.month = month;
        this.year = year;
        this.hot = hot;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterMeter that = (WaterMeter) o;
        return id == that.id && Double.compare(volume, that.volume) == 0 && month == that.month && year == that.year && hot == that.hot && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volume, month, year, hot, user);
    }
}
