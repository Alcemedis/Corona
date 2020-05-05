package com.example.corona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements DescAdapter.OnClickItem {

    private DescAdapter mDescAdapter;
    private RecyclerView recyclerView;
    private ArrayList<String> mTitle;
   // private ArrayList<String> mDescriptions;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerView);
        Log.d(TAG, "onCreate: called ");

        mTitle =new ArrayList<>();
       // mDescriptions= new ArrayList<>();

        initArrays();
        setAdapter();



    }
     private void initArrays(){
        //adding the titles in the array
         Log.d(TAG, "initArrays: started");
         mTitle.add(getString(R.string.title1));
         mTitle.add(getString(R.string.title2));
         mTitle.add(getString(R.string.title3));
         mTitle.add(getString(R.string.title4));
         mTitle.add(getString(R.string.title5));
         mTitle.add(getString(R.string.title6));
         mTitle.add(getString(R.string.title7));



     }
     public void setAdapter(){
         Log.d(TAG, "setAdapter: created");
         mDescAdapter= new DescAdapter(this,mTitle,this);
         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
         recyclerView.setLayoutManager(linearLayoutManager);
         recyclerView.setAdapter(mDescAdapter);

     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int getItemId =item.getItemId();
        if(getItemId ==R.id.web_item){
           openWeb();
        }

        return super.onOptionsItemSelected(item);
    }

    private void openWeb() {
        String webAddress ="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/situation-reports";
        Uri uri =Uri.parse(webAddress);

        Intent intent =new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    @Override
    public void onClickObject(int position) {

     Intent intent=new Intent(this,DetailActivity.class);
     intent.putExtra("ITEM_POSITION",position);
     startActivity(intent);
    }
}
