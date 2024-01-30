package storage.waterMeter;

import model.WaterMeter;

import java.util.LinkedHashMap;

public interface WaterMeterStorage {

    void add(WaterMeter waterMeter);

    WaterMeter getById(int id);

    LinkedHashMap<Integer, WaterMeter> getWaterMeters();
}
