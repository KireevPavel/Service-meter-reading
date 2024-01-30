package service.waterMeter;

import model.User;
import model.WaterMeter;
import service.waterMeter.WaterMeterService;
import storage.waterMeter.WaterMeterStorage;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WaterMeterServiceImpl implements WaterMeterService {

    private final WaterMeterStorage waterMeterStorage;

    public WaterMeterServiceImpl(WaterMeterStorage waterMeterStorage) {
        this.waterMeterStorage = waterMeterStorage;
    }

    @Override
    public void givingEvidence(User user) {
        LocalDate data = LocalDate.now();
        if (!waterMeterStorage.getWaterMeters().isEmpty()) {
            for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
                if (waterMeter.getUserId() == user.getId() && waterMeter.getDate().getMonthValue() == data.getMonthValue()) {
                    System.out.println("Данные уже подавались в этом месяце");
                } else {
                    try {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Введите объем горячей воды");
                        double volumeHot = scanner1.nextDouble();
                        System.out.println("Введите объем холодной воды");
                        double volumeCold = scanner1.nextDouble();


                        WaterMeter newWaterMeter = new WaterMeter(0, volumeHot, volumeCold, data, user.getId());
                        waterMeterStorage.add(newWaterMeter);
                    } catch (Throwable exception) {
                        System.out.println("Введено неккоректное значение " + exception);
                    }
                }
                break;
            }
        } else {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите объем горячей воды");
                double volumeHot = scanner1.nextDouble();
                System.out.println("Введите объем холодной воды");
                double volumeCold = scanner1.nextDouble();


                WaterMeter newWaterMeter = new WaterMeter(0, volumeHot, volumeCold, data, user.getId());
                waterMeterStorage.add(newWaterMeter);
            } catch (Throwable exception) {
                System.out.println("Введено неккоректное значение " + exception);
            }
        }
    }

    @Override
    public WaterMeter getLastMeterReadings(User user) {
        WaterMeter lastWaterMeter = null;
        if (!waterMeterStorage.getWaterMeters().isEmpty()) {
            for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
                if (waterMeter.getUserId() == user.getId()) {
                    lastWaterMeter = waterMeter;
                    break;
                }
            }
            return lastWaterMeter;
        }
        System.out.println("история показаний пуста ");
        return null;
    }

    @Override
    public List<WaterMeter> getMeterReadingsInMonth(User user, int month) {
        List<WaterMeter> WaterMeters = new LinkedList<>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if ((waterMeter.getDate().getMonthValue() == month) && (waterMeter.getUserId() == user.getId())) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters;
    }

    @Override
    public List<WaterMeter> getMeterReadings(User user) {
        List<WaterMeter> WaterMeters = new LinkedList<>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().values()) {
            if (waterMeter.getUserId() == user.getId()) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters.reversed();
    }

    @Override
    public Collection<WaterMeter> getMeterReadingsForAdmin() {
        return waterMeterStorage.getWaterMeters().reversed().values();
    }

    @Override
    public List<WaterMeter> getMeterReadingsInMonthForAdmin(int month) {
        List<WaterMeter> WaterMeters = new LinkedList<>();
        for (WaterMeter waterMeter : waterMeterStorage.getWaterMeters().reversed().values()) {
            if ((waterMeter.getDate().getMonthValue() == month)) {
                WaterMeters.add(waterMeter);
            }
        }
        return WaterMeters;
    }

    @Override
    public WaterMeter getLastMeterReadingsForAdmin() {
        return waterMeterStorage.getWaterMeters().get(waterMeterStorage.getWaterMeters().size());
    }
}
