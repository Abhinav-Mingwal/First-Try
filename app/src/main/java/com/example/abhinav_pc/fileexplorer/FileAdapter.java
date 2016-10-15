package com.example.abhinav_pc.fileexplorer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AbHiNav-PC on 25-Sep-16.
 */
public class FileAdapter extends ArrayAdapter<TYPE> {
    Context mcontext;
    ArrayList<TYPE> Location;
    public FileAdapter(Context context, ArrayList<TYPE> objects) {
        super(context, 0, objects);
        this.mcontext=context;
        this.Location=objects;
    }
    public static class ViewHolder {
        ImageView Icon;
        TextView Directory;
        Button Favorite;

        ViewHolder(ImageView Icon, TextView Directory,Button Favorite) {
            this.Icon = Icon;
            this.Directory = Directory;
            this.Favorite=Favorite;
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.list_item_layout, null);
            ImageView icon = (ImageView) convertView.findViewById(R.id.Image);
             TextView Directory = (TextView) convertView.findViewById(R.id.Directory);
             Button fav= (Button)convertView.findViewById(R.id.Fav);
            ViewHolder vh=new ViewHolder(icon,Directory,fav);
            convertView.setTag(vh);
        }
        ViewHolder vh=(ViewHolder)convertView.getTag();
        vh.Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ABCD","ONCLICK!!");
                ListViewOpenHelper openHelper= new ListViewOpenHelper(mcontext, 1);
                SQLiteDatabase db=openHelper.getWritableDatabase();
                ContentValues cv= new ContentValues();
                cv.put(ListViewOpenHelper.File_table_Directory_name, Location.get(position).Name);
                cv.put(ListViewOpenHelper.File_table_Directory, Location.get(position).path);
                long row = db.insert(ListViewOpenHelper.File_table_name, null, cv);
                Log.i("ABCD", "row id "+row);
            }
        });
        TYPE CurrentType= Location.get(position);

        if(CurrentType.isFolder)
        vh.Icon.setImageResource(android.R.drawable.alert_light_frame);
        else {
            vh.Icon.setImageResource(android.R.drawable.alert_dark_frame);
        }
        vh.Directory.setText(CurrentType.Name);
        return convertView;

    }
}
