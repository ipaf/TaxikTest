package ru.pascalman.taxiktest.presenter.mappers;

import java.util.List;

import ru.pascalman.taxiktest.model.dto.CitiesDTO;
import ru.pascalman.taxiktest.presenter.City;
import rx.Observable;
import rx.functions.Func1;

public class CitiesMapper implements Func1<CitiesDTO, List<City>>
{

    @Override
    public List<City> call(CitiesDTO citiesDTO)
    {
        if (citiesDTO == null)
            return null;

        return Observable.from(citiesDTO.getCities())
            .map(cityDTO -> new City(cityDTO.getCityId(), cityDTO.getCityName(), cityDTO.getCityLatitude(), cityDTO.getCityLongitude()))
            .toList()
            .toBlocking()
            .first();
    }

}