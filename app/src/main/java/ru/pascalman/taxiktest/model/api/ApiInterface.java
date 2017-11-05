package ru.pascalman.taxiktest.model.api;

import retrofit2.http.GET;
import retrofit2.http.Query;

import ru.pascalman.taxiktest.model.dto.CitiesDTO;
import rx.Observable;

public interface ApiInterface
{

    @GET("test")
    Observable<CitiesDTO> getCities();

}