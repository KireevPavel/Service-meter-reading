package service;

import model.User;
import model.WaterMeter;

import java.util.Collection;
import java.util.List;

public interface WaterMeterService {

    void givingEvidence(User user);

    WaterMeter getLastMeterReadings(User user);

    List<WaterMeter> getMeterReadingsInMonth(User user, int month);

    List<WaterMeter> getMeterReadings(User user);

    Collection<WaterMeter> getMeterReadingsForAdmin();

    List<WaterMeter> getMeterReadingsInMonthForAdmin(int month);

    WaterMeter getLastMeterReadingsForAdmin();
}
