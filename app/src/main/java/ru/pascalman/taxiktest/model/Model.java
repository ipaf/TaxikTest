package ru.pascalman.taxiktest.model;

import ru.pascalman.taxiktest.model.dto.CitiesDTO;
import rx.Observable;

public interface Model
{

    Observable<CitiesDTO> getCities();

}