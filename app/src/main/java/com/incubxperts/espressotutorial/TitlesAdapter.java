package com.incubxperts.espressotutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ac on 8/18/2017.
 */

class TitlesAdapter extends RecyclerView.Adapter<TitlesAdapter.TitleHolder> {

    private static final String[] titles = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZ"};
    private Context mContext;

    public TitlesAdapter(Context applicationContext) {
        this.mContext = applicationContext;
    }

    @Override
    public TitleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_custom_item, parent, false);
        return new TitleHolder(view);
    }

    @Override
    public void onBindViewHolder(TitleHolder holder, final int position) {
        final String title = titles[position];
        holder.title.setText(title);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, titles[position] + " is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class TitleHolder extends RecyclerView.ViewHolder {
        TextView title;

        private TitleHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}