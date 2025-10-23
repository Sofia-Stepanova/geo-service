package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    GeoService geoService = new GeoServiceImpl();

    @Test
    void test_getLocation_ru() {

        var expectedLocation = new Location("", Country.RUSSIA, "", 0);
        var expectedCountry = expectedLocation.getCountry();
        var resultTestCountry = geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCountry();
        Assertions.assertEquals(expectedCountry, resultTestCountry);

    }

    @Test
    void test_getLocation_eng() {

        var expectedLocation = new Location("", Country.USA, "", 0);
        var expectedCountry = expectedLocation.getCountry();
        var resultTestCountry = geoService.byIp(GeoServiceImpl.NEW_YORK_IP).getCountry();
        Assertions.assertEquals(expectedCountry, resultTestCountry);

    }
}
