package com.example.abhinav_pc.fileexplorer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Favorite> favorites;
    Favorite_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ABCD","Demo");
        setContentView(R.layout.activity_favorite);
        listView=(ListView)findViewById(R.id.Fav_list);
        favorites=new ArrayList<>();
        adapter=new Favorite_Adapter(FavoriteActivity.this,favorites);
        listView.setAdapter(adapter);
        ListViewOpenHelper openHelper=new ListViewOpenHelper(FavoriteActivity.this,1);
        SQLiteDatabase db =openHelper.getReadableDatabase();
        Cursor c=db.query(ListViewOpenHelper.File_table_name, null, null, null, null, null, null);
        while(c.moveToNext())
        {
            String name= c.getString(c.getColumnIndex(ListViewOpenHelper.File_table_Directory_name));
            String Directory=c.getString(c.getColumnIndex(ListViewOpenHelper.File_table_Directory));
            favorites.add(new Favorite(name, Directory));
        }
        adapter.notifyDataSetChanged();
    }
}
