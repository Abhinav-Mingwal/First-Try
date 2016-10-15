package com.example.abhinav_pc.fileexplorer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by AbHiNav-PC on 01-Oct-16.
 */
public class ListViewOpenHelper extends SQLiteOpenHelper {
    public static final String File_table_name="File_Explorer";
    public static final String File_table_Directory_name="Directory";
    public static final String File_table_Directory="File_Name";
    public ListViewOpenHelper(Context context,int version) {
        super(context, "listview.db",null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE "+File_table_name+" ("+File_table_Directory_name+" TEXT, "+File_table_Directory+" TEXT);";
        Log.i("ABCD",query);
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
