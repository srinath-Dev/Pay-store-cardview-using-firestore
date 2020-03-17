package com.aborteddevelopers.game_pouch.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aborteddevelopers.game_pouch.Interface.IItemClickListener;
import com.aborteddevelopers.game_pouch.Model.ItemData;
import com.aborteddevelopers.game_pouch.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyViewHolder> {

    private Context context;
    private List<ItemData> itemDataList;

    public MyItemAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item,viewGroup,false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.txt_item_title.setText(itemDataList.get(i).getName());
        Picasso.get().load(itemDataList.get(i).getImage()). into(myViewHolder.img_item);

        myViewHolder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(context,""+itemDataList.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (itemDataList != null ? itemDataList.size(): 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_item_title;
        ImageView img_item;

        IItemClickListener iItemClickListener;

        public void setiItemClickListener(IItemClickListener iItemClickListener) {
            this.iItemClickListener = iItemClickListener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_item_title = (TextView)itemView.findViewById(R.id.tvTitle);
            img_item = (ImageView)itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            iItemClickListener.onItemClickListener(view,getAdapterPosition());
        }
    }
}
