package ru.pascalman.taxiktest.presenter;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class City implements Serializable
{

    private Integer cityId;
    private String cityName;
    private Double cityLatitude;
    private Double cityLongitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public City()
    {}

    /**
     * 
     * @param cityLongitude
     * @param cityLatitude
     * @param cityId
     * @param cityName
     */
    public City(Integer cityId, String cityName, Double cityLatitude, Double cityLongitude)
    {
        super();

        this.cityId = cityId;
        this.cityName = cityName;
        this.cityLatitude = cityLatitude;
        this.cityLongitude = cityLongitude;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        this.cityId = cityId;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public Double getCityLatitude()
    {
        return cityLatitude;
    }

    public void setCityLatitude(Double cityLatitude)
    {
        this.cityLatitude = cityLatitude;
    }

    public Double getCityLongitude()
    {
        return cityLongitude;
    }

    public void setCityLongitude(Double cityLongitude)
    {
        this.cityLongitude = cityLongitude;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(cityLongitude)
                .append(cityLatitude)
                .append(cityId)
                .append(cityName)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == this)
            return true;

        if (!(other instanceof City))
            return false;

        City rhs = ((City) other);

        return new EqualsBuilder().append(cityLongitude, rhs.cityLongitude)
                .append(cityLatitude, rhs.cityLatitude)
                .append(cityId, rhs.cityId)
                .append(cityName, rhs.cityName)
                .isEquals();
    }

}