package com.aakashappsolutions.worldcupapp.Adapters;


//Packages:

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aakashappsolutions.worldcupapp.R;
import com.aakashappsolutions.worldcupapp.model.CountryModelClass;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<CountryModelClass> {

    private ArrayList<CountryModelClass>countryArrayList;
    Context context;


    public CustomAdapter(ArrayList<CountryModelClass> data,Context context)
    {
       super(context, R.layout.item_list_layout,data);
       this.countryArrayList = data;
       this.context = context;

    }

    // View Lookup Cache
    private static  class ViewHolder{

        TextView txtCountry;
        TextView txtcupWins;
        ImageView flagImg;





    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//  Get data item for this position
    CountryModelClass dataModel = getItem(position);

    // check if an existing view is reused, Otherwise inflate the view
        ViewHolder viewHolder;

        final View result;


        if (convertView == null){
          viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout,
                    parent,
                    false);

            viewHolder.txtCountry = (TextView) convertView.findViewById(R.id.country_name);
            viewHolder.txtcupWins = (TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.flagImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(viewHolder);


        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;

        }

        // Get the data from model class

        viewHolder.txtCountry.setText(dataModel.getCountry_name());
        viewHolder.txtcupWins.setText(dataModel.getCup_win_count());
        viewHolder.flagImg.setImageResource(dataModel.getFlag_img());


        return  convertView;





    }
}
