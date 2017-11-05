package ru.pascalman.taxiktest.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ru.pascalman.taxiktest.R;
import ru.pascalman.taxiktest.databinding.MainBinding;
import ru.pascalman.taxiktest.presenter.CitiesPresenter;
import ru.pascalman.taxiktest.presenter.City;
import ru.pascalman.taxiktest.view.adapters.CitiesAdapter;

public class MainActivity extends AppCompatActivity implements ListView<City>, View.OnClickListener
{

    private MainBinding binding;
    private CitiesAdapter adapter;
    private CitiesPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.main);
        adapter = new CitiesAdapter(this);
        presenter = new CitiesPresenter(this);
        progressDialog = new ProgressDialog(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
        progressDialog.setTitle("Cities is loading");
        progressDialog.setMessage("Please, wait while cities is loading");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        presenter.getCities();
        progressDialog.show();
    }

    @Override
    public void showError(String error)
    {
        makeToast(error);
    }

    @Override
    public void showList(List<City> list)
    {
        adapter.setList(list);
        progressDialog.dismiss();
    }

    @Override
    public void showEmptyList()
    {
        makeToast("Cities not found");
        adapter.setList(new ArrayList<>());
        progressDialog.dismiss();
    }

    private void makeToast(String text)
    {
        Snackbar.make(binding.recyclerView, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v)
    {
        Intent mapIntent = new Intent(this, MapsActivity.class);
        List<City> cities = adapter.getList();
        int id = v.getId();
        City clickedCity = null;

        for (City city : cities)
            if (city.getCityId() == id)
            {
                clickedCity = city;

                break;
            }

        if (clickedCity == null)
            return;

        mapIntent.putExtra("cityName", clickedCity.getCityName());
        mapIntent.putExtra("cityLatitude", clickedCity.getCityLatitude());
        mapIntent.putExtra("cityLongitude", clickedCity.getCityLongitude());

        startActivity(mapIntent);
    }

    @Override
    public void onStop()
    {
        super.onStop();

        if (presenter != null)
            presenter.onStop();
    }

}