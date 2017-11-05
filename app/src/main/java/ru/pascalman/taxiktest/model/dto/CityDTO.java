package ru.pascalman.taxiktest.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityDTO
{

    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("city_latitude")
    @Expose
    private Double cityLatitude;
    @SerializedName("city_longitude")
    @Expose
    private Double cityLongitude;
    @SerializedName("city_spn_latitude")
    @Expose
    private Double citySpnLatitude;
    @SerializedName("city_spn_longitude")
    @Expose
    private Double citySpnLongitude;
    @SerializedName("last_app_android_version")
    @Expose
    private Integer lastAppAndroidVersion;
    @SerializedName("transfers")
    @Expose
    private Boolean transfers;
    @SerializedName("client_email_required")
    @Expose
    private Boolean clientEmailRequired;
    @SerializedName("registration_promocode")
    @Expose
    private Boolean registrationPromocode;
    @SerializedName("parent_city")
    @Expose
    private Integer parentCity;

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

    public Double getCitySpnLatitude()
    {
        return citySpnLatitude;
    }

    public void setCitySpnLatitude(Double citySpnLatitude)
    {
        this.citySpnLatitude = citySpnLatitude;
    }

    public Double getCitySpnLongitude()
    {
        return citySpnLongitude;
    }

    public void setCitySpnLongitude(Double citySpnLongitude)
    {
        this.citySpnLongitude = citySpnLongitude;
    }

    public Integer getLastAppAndroidVersion()
    {
        return lastAppAndroidVersion;
    }

    public void setLastAppAndroidVersion(Integer lastAppAndroidVersion)
    {
        this.lastAppAndroidVersion = lastAppAndroidVersion;
    }

    public Boolean getTransfers()
    {
        return transfers;
    }

    public void setTransfers(Boolean transfers)
    {
        this.transfers = transfers;
    }

    public Boolean getClientEmailRequired()
    {
        return clientEmailRequired;
    }

    public void setClientEmailRequired(Boolean clientEmailRequired)
    {
        this.clientEmailRequired = clientEmailRequired;
    }

    public Boolean getRegistrationPromocode()
    {
        return registrationPromocode;
    }

    public void setRegistrationPromocode(Boolean registrationPromocode)
    {
        this.registrationPromocode = registrationPromocode;
    }

    public Integer getParentCity()
    {
        return parentCity;
    }

    public void setParentCity(Integer parentCity)
    {
        this.parentCity = parentCity;
    }

}