package mappers;

import entity.Address;
import entity.Cityinfo;

public class CityinfoMapper {
    
    private Integer zipCode;
    private String city;
    private String addressCity;

    public CityinfoMapper() {
    }
    
    public CityinfoMapper(Cityinfo cityinfo) {
        this.zipCode = cityinfo.getZipCode();
        this.city = cityinfo.getCity();
    }
    
    public CityinfoMapper(Integer zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }   
    
    public CityinfoMapper(Address address) {
        this.zipCode = address.getCityinfo().getZipCode();
        this.city = address.getCityinfo().getCity();
        //this.addressCity = address.getCityinfo().getCity();
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    
    
    
    @Override
    public String toString() {
        return "CityinfoMapper{" + "zipCode=" + zipCode + '}';
    }
    // + ", addressCity=" + addressCity + 
}