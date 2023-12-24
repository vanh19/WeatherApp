package anhmvph25860.fpoly.weatherapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import anhmvph25860.fpoly.weatherapp.Domains.FutureDomains;
import anhmvph25860.fpoly.weatherapp.Domains.Hourly;
import anhmvph25860.fpoly.weatherapp.R;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewHolder> {
    ArrayList<FutureDomains> items;
    Context context;

    public FutureAdapter(ArrayList<FutureDomains> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FutureAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_future, parent, false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.viewHolder holder, int position) {
        holder.tvDay.setText(items.get(position).getDay());
        holder.tvStatus.setText(items.get(position).getStatus());
        holder.tvHigh.setText(items.get(position).getHighTemp()+"");
        holder.tvLow.setText(items.get(position).getLowTemp()+"");


        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),
                        "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableResourceId).into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvDay, tvStatus, tvLow, tvHigh;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvDay = itemView.findViewById(R.id.tvDay);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvLow = itemView.findViewById(R.id.tvLow);
            tvHigh = itemView.findViewById(R.id.tvHigh);

            pic = itemView.findViewById(R.id.imgPic);
        }
    }
}
