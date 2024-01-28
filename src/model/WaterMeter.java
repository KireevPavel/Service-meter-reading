package model;

import java.time.LocalDate;
import java.util.Objects;

public class WaterMeter {
    int id;
    double volume;
    int month;
    boolean hot;
    User user;

    public WaterMeter(int id, double volume, int month, boolean hot, User user) {
        this.id = id;
        this.volume = volume;
        this.month = month;
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
        return id == that.id && Double.compare(volume, that.volume) == 0 && month == that.month && hot == that.hot && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volume, month, hot, user);
    }

    @Override
    public String toString() {
        return "WaterMeter{" +
                "id=" + id +
                ", volume=" + volume +
                ", month=" + month +
                ", hot=" + hot +
                ", user=" + user +
                '}';
    }
}
