package ru.pascalman.taxiktest.presenter;

import ru.pascalman.taxiktest.model.Model;
import ru.pascalman.taxiktest.model.ModelImpl;
import ru.pascalman.taxiktest.model.api.ApiInterface;
import ru.pascalman.taxiktest.model.api.ApiModule;
import ru.pascalman.taxiktest.other.Const;
import ru.pascalman.taxiktest.view.View;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter implements Presenter
{

    protected Model model;
    protected CompositeSubscription compositeSubscription;

    public BasePresenter()
    {
        ApiInterface api = ApiModule.getApiInterface(Const.BASE_URL);

        model = new ModelImpl(api);
        compositeSubscription = new CompositeSubscription();
    }

    protected void addSubscription(Subscription subscription)
    {
        compositeSubscription.add(subscription);
    }

    @Override
    public void onStop()
    {
        compositeSubscription.clear();
    }

    protected abstract View getView();

    protected void showError(Throwable e)
    {
        getView().showError(e.getMessage());
    }

}