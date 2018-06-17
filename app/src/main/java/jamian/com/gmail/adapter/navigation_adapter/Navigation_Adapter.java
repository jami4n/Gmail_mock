package jamian.com.gmail.adapter.navigation_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jamian.com.gmail.R;
import jamian.com.gmail.model.navigation_model.Navigation_data;

public class Navigation_Adapter extends RecyclerView.Adapter<Navigation_Adapter.MYVH> {

    ArrayList<Navigation_data> navigation_data;
    Context context;

    public Navigation_Adapter(ArrayList<Navigation_data> navigation_data, Context context) {
        this.navigation_data = navigation_data;
        this.context = context;
    }

    @NonNull
    @Override
    public MYVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MYVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.each_menuitem,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MYVH holder, int position) {

        holder.tv_menutitle.setText(navigation_data.get(position).getTitle());
        Glide.with(context).load(navigation_data.get(position).getImageid()).into(holder.iv_menuimage);
    }

    @Override
    public int getItemCount() {
        return navigation_data.size();
    }

    public class MYVH extends RecyclerView.ViewHolder {
        ImageView iv_menuimage;
        TextView tv_menutitle;

        public MYVH(View itemView) {
            super(itemView);

            iv_menuimage = itemView.findViewById(R.id.iv_menuimage);
            tv_menutitle = itemView.findViewById(R.id.tv_menutitle);
        }
    }
}
