package rest;

import entity.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import java.util.ArrayList;
import java.util.List;
import mappers.PersonMapper;

public class JSONConverter {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //------------------------- Address --------------------//   
    public static Address getAddressFromJson(String js) {
        return gson.fromJson(js, Address.class);

    }

    public static String getJSONFromAdress(Address a) {
        return gson.toJson(a);
    }

    public static String getJSONFromAddress(List<Address> address) {

        return gson.toJson(address);
    }

    //------------------------- Cityinfo --------------------//
    public static Cityinfo getCityinforomJson(String js) {
        return gson.fromJson(js, Cityinfo.class);

    }

    public static String getJSONFromCityinfo(Cityinfo c) {
        return gson.toJson(c);
    }

    public static String getJSONFromCityinfos(List<Cityinfo> cityinfos) {

        return gson.toJson(cityinfos);
    }

    //------------------------- Hobby --------------------//   
    public static Hobby getHobbyomJson(String js) {
        return gson.fromJson(js, Hobby.class);

    }

    public static String getJSONFromHobby(Hobby h) {
        return gson.toJson(h);
    }

    public static String getJSONFromHobbys(List<Hobby> hobbys) {

        return gson.toJson(hobbys);
    }

    //------------------------- Person --------------------//   
    public   static PersonMapper getPersonFromJson(String js) {
        return gson.fromJson(js, PersonMapper.class);

    }

    public static String getJSONFromPerson(PersonMapper p) {
        return gson.toJson(p);
    }

    public  static String getJSONFromPersons(List<PersonMapper> persons) {

        return gson.toJson(persons);
    }

    public static void main(String[] args) {

        List<Person> al = new ArrayList();

      
    }
}
