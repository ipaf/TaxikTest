package ru.pascalman.taxiktest.model;

import ru.pascalman.taxiktest.model.api.ApiInterface;
import ru.pascalman.taxiktest.model.dto.CitiesDTO;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ModelImpl implements Model
{

    private final Observable.Transformer schedulersTransformer;

    private ApiInterface apiInterface;
    private Scheduler uiThread;
    private Scheduler ioThread;

    public ModelImpl(ApiInterface apiInterface)
    {
        this.apiInterface = apiInterface;

        uiThread = AndroidSchedulers.mainThread();
        ioThread = Schedulers.io();
        schedulersTransformer = o -> ((Observable) o).subscribeOn(ioThread)
            .observeOn(uiThread)
            .unsubscribeOn(ioThread);
    }

    @Override
    public Observable<CitiesDTO> getCities()
    {
        return apiInterface
            .getCities()
            .compose(applySchedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers()
    {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }

}