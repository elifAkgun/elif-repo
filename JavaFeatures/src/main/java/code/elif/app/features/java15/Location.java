package code.elif.app.features.java15;


import java.util.Objects;

public class Location{

    private String country;
    private String city;

    public Location(String country, String city){
        this.country=country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(country, location.country) && Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}