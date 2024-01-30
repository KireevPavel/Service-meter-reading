package storage.waterMeter;

import exception.Exception;
import model.WaterMeter;

import java.util.LinkedHashMap;

public class InMemoryWaterMeterStorage implements WaterMeterStorage {

    private final LinkedHashMap<Integer, WaterMeter> waterMeters = new LinkedHashMap<>();
    private int id = 0;

    private int generateId() {
        return ++id;
    }

    @Override
    public void add(WaterMeter waterMeter) {
        waterMeter.setId(generateId());
        waterMeters.put(waterMeter.getId(), waterMeter);
    }

    @Override
    public WaterMeter getById(int id) {
        if (waterMeters.containsKey(id)) {
            return waterMeters.get(id);
        } else throw new Exception("WaterMeter not found.");
    }

    @Override
    public LinkedHashMap<Integer, WaterMeter> getWaterMeters() {
        return waterMeters;
    }
}
