package com.example.abhinav_pc.fileexplorer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AbHiNav-PC on 01-Oct-16.
 */
public class Favorite_Adapter extends ArrayAdapter<Favorite> {
    Context mcontext;
    ArrayList<Favorite> favorites;
    public Favorite_Adapter(Context context, ArrayList<Favorite> objects) {
        super(context, 0, objects);
        this.mcontext=context;
        this.favorites=objects;
    }
    public static class ViewHolder {
        TextView name;
        TextView Directory;

        ViewHolder(TextView name,TextView Directory) {
            this.name = name;
            this.Directory=Directory;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.favorite_layout, null);
            TextView name = (TextView) convertView.findViewById(R.id.Favorite_Name);
            TextView Directory =(TextView) convertView.findViewById(R.id.Favorite_Dir);
            ViewHolder vh=new ViewHolder(name,Directory);
            convertView.setTag(vh);
        }
        ViewHolder vh=(ViewHolder)convertView.getTag();
        Favorite CurrentFav= favorites.get(position);
        vh.name.setText(CurrentFav.name);
        vh.Directory.setText(CurrentFav.Directory);
        return convertView;

    }
}
