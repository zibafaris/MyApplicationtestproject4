package com.example.myapplicationapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplicationapi.Movies.Search;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

class MyMoviesViewAdapter extends RecyclerView.Adapter<MyMoviesViewAdapter.ViewHolder> {

    private List<Search> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyMoviesViewAdapter(Context context, ArrayList<Search> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movieview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String MovieTitle = mData.get(position).getTitle();
        holder.myTextView.setText(MovieTitle);
        holder.myyear.setText( mData.get(position).getYear());
        holder.mImdb.setText( mData.get(position).getImdbID());
        holder.txtActors.setText( mData.get(position).getActors());
        holder.txtCountry.setText( mData.get(position).getCountry());
        holder.txtPlot.setText( mData.get(position).getPlot());
        String MPoster = mData.get(position).getTitle();
        Picasso.get().load(mData.get(position).getPoster()).into(holder.myimg);
        //holder.myimg.setBackgroundResource(mData.get(position).getPoster());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView,myyear,mImdb,txtCountry,txtActors,txtPlot;
        ImageView myimg;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            myyear = itemView.findViewById(R.id.txtYear);
            mImdb = itemView.findViewById(R.id.txtimdb);
            txtCountry = itemView.findViewById(R.id.txtCountry);
            txtActors = itemView.findViewById(R.id.txtActors);
            txtPlot = itemView.findViewById(R.id.txtPlot);
            myimg = itemView.findViewById(R.id.tvImgVi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClickMovie(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Search getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClickMovie(View view, int position);
    }
}
