package service;

import model.User;
import model.WaterMeter;
import storage.waterMeter.WaterMeterStorage;

import java.time.LocalDate;

import java.util.*;

public class WaterMeterService {

    WaterMeterStorage waterMeterStorage = new WaterMeterStorage();

    public void givingEvidence(User user) {
        LocalDate data = LocalDate.now();
        if (!waterMeterStorage.getWaterMeters().isEmpty()) {
            for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
                if (waterMeter.getUserId() == user.getId() && waterMeter.getDate().getMonthValue() == data.getMonthValue()) {
                    System.out.println("Данные уже подавались в этом месяце");
                } else {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите объем горячей воды");
                    double volumeHot = scanner1.nextDouble();
                    System.out.println("Введите объем холодной воды");
                    double volumeCold = scanner1.nextDouble();


                    WaterMeter newWaterMeter = new WaterMeter(0, volumeHot, volumeCold, data, user.getId());
                    waterMeterStorage.add(newWaterMeter);
                }
                break;
            }
        }else {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите объем горячей воды");
            double volumeHot = scanner1.nextDouble();
            System.out.println("Введите объем холодной воды");
            double volumeCold = scanner1.nextDouble();


            WaterMeter newWaterMeter = new WaterMeter(0, volumeHot, volumeCold, data, user.getId());
            waterMeterStorage.add(newWaterMeter);
        }

        }


    public WaterMeter getLastMeterReadings(User user){
       WaterMeter lastWaterMeter = null;
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if (waterMeter.getUserId() == user.getId()) {
                lastWaterMeter = waterMeter;
                break;
            }
        }
        return lastWaterMeter;
    }

    public List<WaterMeter> getMeterReadingsInMonth(User user, int month){
        List<WaterMeter> WaterMeters = new LinkedList<>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if ((waterMeter.getDate().getMonthValue()==month) && (waterMeter.getUserId()==user.getId())) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters;
    }

    public List<WaterMeter> getMeterReadings(User user){
        List<WaterMeter> WaterMeters = new LinkedList<>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().values()) {
            if (waterMeter.getUserId() == user.getId()) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters.reversed();
    }

    public Collection<WaterMeter> getMeterReadingsForAdmin() {
    return waterMeterStorage.getWaterMeters().reversed().values();
    }

    public List<WaterMeter> getMeterReadingsInMonthForAdmin( int month){
        List<WaterMeter> WaterMeters = new LinkedList<>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if ((waterMeter.getDate().getMonthValue()==month)) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters;
    }
    public WaterMeter getLastMeterReadingsForAdmin(){
        return waterMeterStorage.getWaterMeters().get(waterMeterStorage.getWaterMeters().size());
    }
}
