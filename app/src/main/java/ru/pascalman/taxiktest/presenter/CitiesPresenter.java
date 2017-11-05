package ru.pascalman.taxiktest.presenter;

import android.util.Log;

import java.util.List;

import ru.pascalman.taxiktest.presenter.mappers.CitiesMapper;
import ru.pascalman.taxiktest.view.ListView;
import ru.pascalman.taxiktest.view.View;
import rx.Observer;
import rx.Subscription;

public class CitiesPresenter extends BasePresenter
{

    private ListView<City> view;
    private CitiesMapper mapper;
    private List<City> cityList;

    public CitiesPresenter(ListView<City> view)
    {
        this.view = view;

        mapper = new CitiesMapper();
    }

    public void getCities()
    {
        Subscription subscription = model.getCities()
            .map(mapper)
            .subscribe(new Observer<List<City>>() {

                @Override
                public void onCompleted()
                {}

                @Override
                public void onError(Throwable e)
                {
                    Log.d(CitiesPresenter.class.getName(), e.toString());
                    showError(e);
                }

                @Override
                public void onNext(List<City> list)
                {
                    if (list == null || list.isEmpty())
                        view.showEmptyList();
                    else
                    {
                        cityList = list;

                        view.showList(cityList);
                    }
                }

            });

        addSubscription(subscription);
    }

    @Override
    protected View getView()
    {
        return view;
    }

}