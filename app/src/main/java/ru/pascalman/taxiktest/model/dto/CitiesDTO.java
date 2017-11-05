package ru.pascalman.taxiktest.model.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitiesDTO
{

    @SerializedName("cities")
    @Expose
    private List<CityDTO> cities = null;

    public List<CityDTO> getCities()
    {
        return cities;
    }

    public void setCities(List<CityDTO> cities)
    {
        this.cities = cities;
    }

}