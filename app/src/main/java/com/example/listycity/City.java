package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    String getCityName() {
        return this.city;
    }

    String getProvinceName() {
        return this.province;
    }

    @Override
    public int compareTo(City other) {
        int compare = this.city.compareTo(other.city);
        if (compare != 0) {
            return compare;
        } else {
            return this.province.compareTo(other.province);
        }
    }

    /**
     * Checks if a city obj is equal to another obj
     *
     * @param obj the object for comparison
     * @return true if the cities are equal and false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        City other = (City) obj;
        return city.equals(other.city) && province.equals(other.province);

    }
    /**
     * Return a hash code value for a city based on the name and province.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return city.hashCode() * 17 + province.hashCode();
    }
}

