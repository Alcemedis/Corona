package com.example.corona;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class DescAdapter extends RecyclerView.Adapter<DescAdapter.DescAdapterViewHolder> {

    private Context mContext;
   // public ArrayList<String> Description;
    public ArrayList<String> Title;
    private final OnClickItem onItemClicked;

    public DescAdapter( Context context, ArrayList<String>title, OnClickItem listItemClick){
        mContext =context;
       // Description =desc;
        Title = title;
        onItemClicked =listItemClick;
    }
    @NonNull
    @Override
    public DescAdapter.DescAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.description_layout,viewGroup,false);
        return new DescAdapterViewHolder(view,onItemClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull DescAdapter.DescAdapterViewHolder holder, int i) {
        Log.d(TAG, "onBindViewHolder: called"+ i);
        holder.bind(i);

    }

    @Override
    public int getItemCount() {
        return Title.size();
    }

    public class DescAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

         private TextView description;
         private TextView title;
         private OnClickItem onClickItem;


        public DescAdapterViewHolder(@NonNull View itemView,OnClickItem clicked) {
            super(itemView);
            description =itemView.findViewById(R.id.tv_description);
            title =itemView.findViewById(R.id.tv_title);
            onClickItem= clicked;
            itemView.setOnClickListener(this);
        }
        public void onClick(View view){
            int itemPosition= getAdapterPosition();
            onClickItem.onClickObject(itemPosition);

        }

        public void bind(int i) {
            String concat = Title.get(i);
            title.setText(concat);

        }
    }
    public interface OnClickItem{
        void onClickObject(int position);
    }
}
