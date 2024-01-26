package storage.waterMeter;

import exception.NotFoundException;
import model.User;
import model.WaterMeter;

import java.util.HashMap;

public class WaterMeterStorage {

    private final HashMap<Integer, WaterMeter> waterMeters = new HashMap<>();
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
        } else throw new NotFoundException("WaterMeter not found.");
    }
}
