package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private ImageView mImages;
    private TextView mTextView;
    private ArrayList<String> detail;
    private ArrayList<Integer> ImageArray;
    private  int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImages =findViewById(R.id.imageView);
        mTextView= findViewById(R.id.tv_detail);

        Intent intentThatGotCalled =getIntent();
        detail =new ArrayList<>();
       ImageArray = new ArrayList<>();

        if(intentThatGotCalled.hasExtra("ITEM_POSITION")){
             i =intentThatGotCalled.getIntExtra("ITEM_POSITION",0);
        }
        initialize();
        SetView();
    }
    private void initialize(){

        detail.add(getString(R.string.description1));
        detail.add(getString(R.string.description2));
        detail.add(getString(R.string.description3));
        detail.add(getString(R.string.description4));
        detail.add(getString(R.string.description5));
        detail.add(getString(R.string.description6));
        detail.add(getString(R.string.description7));

        ImageArray.add(R.drawable.download1);
        ImageArray.add(R.drawable.download2);
        ImageArray.add(R.drawable.download3);
        ImageArray.add(R.drawable.download4);
        ImageArray.add(R.drawable.download5);
        ImageArray.add(R.drawable.download6);
        ImageArray.add(R.drawable.download7);

    }

    private void SetView(){
        mImages.setImageResource(ImageArray.get(i));
        mTextView.setText(detail.get(i));
    }
}
