package com.example.spaceflightnews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spaceflightnews.model.SpaceFlightNews;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Callback;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<SpaceFlightNews> mSpaceFlightNewsList;
    private LayoutInflater inflater;
//    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    Context context;

    DataAdapter(Context context, List<SpaceFlightNews> mSpaceFlightNewsList) {
        this.mSpaceFlightNewsList = mSpaceFlightNewsList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        SpaceFlightNews spaceFlightNews = mSpaceFlightNewsList.get(position);
        holder.mTextViewTitle.setText(spaceFlightNews.getTitle());
        holder.mTextViewNewsSite.setText(spaceFlightNews.getNewsSite());
        Picasso.get().load(spaceFlightNews.getImageUrl()).into(holder.mImageView);
//        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        holder.mTextViewPublishedDate.setText(spaceFlightNews.getPublishedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("newsURL", spaceFlightNews.getUrl());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSpaceFlightNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextViewTitle;
        final TextView mTextViewNewsSite;
        final ImageView mImageView;
        final TextView mTextViewPublishedDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.news_title);
            mTextViewNewsSite = itemView.findViewById(R.id.news_site);
            mImageView = itemView.findViewById(R.id.news_image);
            mTextViewPublishedDate = itemView.findViewById(R.id.news_published_date);
        }
    }
}
