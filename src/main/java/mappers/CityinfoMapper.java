package mappers;

import entity.Address;

public class CityinfoMapper {
    private Integer zipCode;
    private String city;
    //private String addressCity;

    public CityinfoMapper(Address address)
    {
        this.zipCode = address.getCityinfo().getZipCode();
        this.city = address.getCityinfo().getCity();
        //this.addressCity = address.getCityinfo().getCity();
    }

    @Override
    public String toString() {
        return "CityinfoMapper{" + "zipCode=" + zipCode + '}';
    }
    // + ", addressCity=" + addressCity + 
}