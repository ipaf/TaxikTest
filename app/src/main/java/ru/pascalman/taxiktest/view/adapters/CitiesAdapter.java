package ru.pascalman.taxiktest.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.pascalman.taxiktest.presenter.City;

public class CitiesAdapter extends BaseAdapter<City, CitiesAdapter.CitiesViewHolder>
{

    public CitiesAdapter(View.OnClickListener listener)
    {
        super(listener);
    }

    @Override
    public CitiesAdapter.CitiesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);

        view.setOnClickListener(listener);

        return new CitiesAdapter.CitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CitiesAdapter.CitiesViewHolder viewHolder, int i)
    {
        City city = list.get(i);

        viewHolder.setId(city.getCityId());
        viewHolder.setText(city.getCityName());
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder
    {

        private TextView view;

        public CitiesViewHolder(TextView view)
        {
            super(view);

            this.view = view;
        }

        public void setText(String text)
        {
            view.setText(text);
        }

        public void setId(int id)
        {
            view.setId(id);
        }

    }

}