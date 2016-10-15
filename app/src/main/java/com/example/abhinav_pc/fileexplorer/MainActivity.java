package com.example.abhinav_pc.fileexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<TYPE> Location;
    FileAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView) findViewById(R.id.ListItem);
        Location=new ArrayList<>();
        final String path;
        if(getIntent().getStringExtra("Path")!=null) {
            Toast.makeText(MainActivity.this, "HELLO ", Toast.LENGTH_SHORT).show();
            Intent i = getIntent();
            path = i.getStringExtra("Path");
        }
        else{
            path="/";
        }
        File file = new File(path);
        File[] SubFiles = file.listFiles();
        for(int i1=0;i1<SubFiles.length;i1++){
            if(SubFiles[i1].isDirectory())
            {
                Location.add(new TYPE(true, SubFiles[i1].getName(), SubFiles[i1].getPath()));
            }
            else {
                Location.add(new TYPE(false,SubFiles[i1].getName(),SubFiles[i1].getPath()));
                }
            }
        adapter=new FileAdapter(this,Location);
        listview.setAdapter(adapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("ABCD", Location.get(position).path);
//                Toast.makeText(MainActivity.this,Location.get(position).path,Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent();
//                intent.setClass(MainActivity.this,MainActivity.class);
//                intent.putExtra("Path", Location.get(position).path+"/");
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.file_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.Favorite){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,FavoriteActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
