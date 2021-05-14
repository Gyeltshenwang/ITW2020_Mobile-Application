package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportsAdapter extends  RecyclerView.Adapter<SportsAdapter.ViewHolder>{
    ArrayList<Sport> msport = new ArrayList<>();
    Context mcontext;
    public SportsAdapter(Context mcontext, ArrayList<Sport> msport){
        this.mcontext = mcontext;
        this.msport = msport;

    }


    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        Sport currentsport = msport.get(position);
        holder.bindTo(currentsport);

    }

    @Override
    public int getItemCount() {

        return msport.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.News);
            mInfoText = (TextView) itemView.findViewById(R.id.subtitle);
            mSportsImage =itemView.findViewById(R.id.sportsImage);
        }
        void bindTo(Sport currentsport){
            mInfoText.setText(currentsport.getInfo());
            mTitleText.setText(currentsport.getTitle());
            Glide.with(mcontext).load(currentsport.getImageResource()).into(mSportsImage);
        }

    }
}
