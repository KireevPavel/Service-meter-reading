package main.java.ru.ylab.storage.waterMeter;

import main.java.ru.ylab.model.WaterMeter;

import java.util.LinkedHashMap;

public interface WaterMeterStorage {

    void add(WaterMeter waterMeter);

    WaterMeter getById(int id);

    LinkedHashMap<Integer, WaterMeter> getWaterMeters();
}
