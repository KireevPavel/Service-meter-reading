package storage.waterMeter;

import exception.Exception;
import model.WaterMeter;

import java.util.LinkedHashMap;

public class WaterMeterStorage {



    private final LinkedHashMap<Integer, WaterMeter> waterMeters = new LinkedHashMap<>();
    private int id = 0;

    private int generateId() {
        return ++id;
    }

    public WaterMeter add(WaterMeter waterMeter) {
        waterMeter.setId(generateId());
        waterMeters.put(waterMeter.getId(), waterMeter);
        return waterMeter;
    }

    public WaterMeter getById(int id) {
        if (waterMeters.containsKey(id)) {
            return waterMeters.get(id);
        } else throw new Exception("WaterMeter not found.");
    }

    public LinkedHashMap<Integer, WaterMeter> getWaterMeters() {
        return waterMeters;
    }
}
