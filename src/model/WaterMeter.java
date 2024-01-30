package model;

import java.time.LocalDate;
import java.util.Objects;

public class WaterMeter {
    int id;
    double volumeOfColdWater;
    double volumeOfHotWater;
    LocalDate date;
    int userId;

    public WaterMeter(int id, double volumeOfColdWater, double volumeOfHotWater, LocalDate date, int userId) {
        this.id = id;
        this.volumeOfColdWater = volumeOfColdWater;
        this.volumeOfHotWater = volumeOfHotWater;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVolumeOfColdWater() {
        return volumeOfColdWater;
    }

    public void setVolumeOfColdWater(double volumeOfColdWater) {
        this.volumeOfColdWater = volumeOfColdWater;
    }

    public double getVolumeOfHotWater() {
        return volumeOfHotWater;
    }

    public void setVolumeOfHotWater(double volumeOfHotWater) {
        this.volumeOfHotWater = volumeOfHotWater;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterMeter that = (WaterMeter) o;
        return id == that.id && Double.compare(volumeOfColdWater, that.volumeOfColdWater) == 0 && Double.compare(volumeOfHotWater, that.volumeOfHotWater) == 0 && userId == that.userId && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volumeOfColdWater, volumeOfHotWater, date, userId);
    }

    @Override
    public String toString() {
        return "WaterMeter{" +
                "id=" + id +
                ", volumeOfColdWater=" + volumeOfColdWater +
                ", volumeOfHotWater=" + volumeOfHotWater +
                ", date=" + date +
                '}';
    }
}
