package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));

    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));

    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City edmonton = mockCity();

        assertEquals(1, cityList.countCities());
        cityList.delete(edmonton);
        assertEquals(0, cityList.countCities());

    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City edmonton = new City("Edmonton", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(edmonton);
        });
    }


    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        City edmonton = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");

        cityList.add(edmonton);
        cityList.add(calgary);
        assertEquals(2, cityList.countCities());

        cityList.delete(edmonton);
        assertEquals(1, cityList.countCities());


    }







}
