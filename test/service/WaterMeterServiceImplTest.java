package service;

import model.User;
import model.WaterMeter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.waterMeter.InMemoryWaterMeterStorage;
import storage.waterMeter.WaterMeterStorage;

import java.time.LocalDate;
import java.util.List;

class WaterMeterServiceImplTest {
    WaterMeterStorage waterMeterStorage;
    WaterMeterService waterMeterService;

    User user;
    WaterMeter testWaterMeter;
    WaterMeter testWaterMeter2;
    WaterMeter testWaterMeter3;

    @BeforeEach
    void setUp() {
        waterMeterStorage = new InMemoryWaterMeterStorage();
        waterMeterService = new WaterMeterServiceImpl(waterMeterStorage);
        user = new User(1, "login", "password", true, "user");
        testWaterMeter = new WaterMeter(1, 5, 1, LocalDate.of(2024, 11, 30), 1);
        testWaterMeter2 = new WaterMeter(2, 5, 1, LocalDate.of(2024, 12, 31), 1);
        testWaterMeter3 = new WaterMeter(3, 5, 1, LocalDate.of(2024, 12, 31), 2);
    }


    @Test
    void getLastMeterReadings() {
        waterMeterStorage.add(testWaterMeter);
        waterMeterStorage.add(testWaterMeter2);
        WaterMeter testWaterMeter4 = waterMeterService.getLastMeterReadings(user);
        Assertions.assertEquals(testWaterMeter2, testWaterMeter4);
    }

    @Test
    void getMeterReadingsInMonth() {
        waterMeterStorage.add(testWaterMeter);
        waterMeterStorage.add(testWaterMeter2);
        List<WaterMeter> testWaterMeter4 = waterMeterService.getMeterReadingsInMonth(user, 11);
        Assertions.assertEquals(testWaterMeter, testWaterMeter4.getFirst());
    }


    @Test
    void getMeterReadingsInMonthForAdmin() {
        user.setStatus("admin");
        waterMeterStorage.add(testWaterMeter);
        waterMeterStorage.add(testWaterMeter2);
        waterMeterStorage.add(testWaterMeter3);
        List<WaterMeter> testWaterMeter4 = waterMeterService.getMeterReadingsInMonthForAdmin(11);
        Assertions.assertEquals(testWaterMeter, testWaterMeter4.getFirst());
    }

    @Test
    void getLastMeterReadingsForAdmin() {
        waterMeterStorage.add(testWaterMeter);
        waterMeterStorage.add(testWaterMeter2);
        waterMeterStorage.add(testWaterMeter3);
        WaterMeter testWaterMeter4 = waterMeterService.getLastMeterReadingsForAdmin();
        Assertions.assertEquals(testWaterMeter3, testWaterMeter4);
    }
}