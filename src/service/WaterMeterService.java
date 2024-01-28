package service;

import model.User;
import model.WaterMeter;
import storage.waterMeter.WaterMeterStorage;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WaterMeterService {

    WaterMeterStorage waterMeterStorage = new WaterMeterStorage();

    public void givingEvidence(User user){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите обьем");
        double volume = scanner1.nextDouble();
        System.out.println("Введите дату в формате YYYY,MM,DD");
        int data = scanner1.nextInt();
        System.out.println("Если вода горячая введите true, иначе false");
        boolean hot = scanner1.nextBoolean();
        System.out.println(hot);
        WaterMeter waterMeter = new WaterMeter(0,volume,data,hot,user);
        waterMeterStorage.add(waterMeter);
    }
    public WaterMeter getLastMeterReadings(User user){
       WaterMeter lastWaterMeter = null;
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if(waterMeter.getUser().equals(user));
            lastWaterMeter = waterMeter;
            break;
        }
        return lastWaterMeter;
    }

    public List<WaterMeter> getMeterReadingsInMonth(User user, int month){
        List<WaterMeter> WaterMeters = new LinkedList<WaterMeter>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if ((waterMeter.getMonth()==month) && (waterMeter.getUser().equals(user))) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters;
    }

    public List<WaterMeter> getMeterReadings(User user){
        List<WaterMeter> WaterMeters = new LinkedList<WaterMeter>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().values()) {
            if(waterMeter.getUser().equals(user));
            WaterMeters.add(waterMeter);
        }
        return WaterMeters.reversed();
    }

}
