package com.example.asiascountriesinformantion;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.text.util.Linkify;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.request.RequestOptions;
import com.example.asiascountriesinformantion.EntryClass.UserModel;

import java.io.InputStream;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<UserModel> userModels;
    Context context;

    public Adapter(List<UserModel> userModels,Context context) {
        this.userModels = userModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        holder.name.setText(userModels.get(position).getName());
        holder.capital.setText(userModels.get(position).getCapital());
        holder.region.setText(userModels.get(position).getRegion());
        holder.subRegion.setText(userModels.get(position).getSubregion());
        holder.population.setText(userModels.get(position).getPopulation());
        holder.border.setText(userModels.get(position).getBorders());
        holder.languages.setText(userModels.get(position).getLanguages());
        Uri uri = Uri.parse(userModels.get(position).getFlag());

        RequestBuilder<PictureDrawable> requestBuilder =
                Glide.with(context)
                        .as(PictureDrawable.class)
                        .listener(new SvgSoftwareLayerSetter());

        requestBuilder.load(uri) .placeholder(R.mipmap.ic_launcher)
                .override(300, 300)
                .into(holder.imageView);





    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,capital,region,subRegion,population,border,languages;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            region = itemView.findViewById(R.id.region);
            subRegion = itemView.findViewById(R.id.subRegion);
            population = itemView.findViewById(R.id.population);
            border = itemView.findViewById(R.id.borders);
            languages = itemView.findViewById(R.id.languages);

        }
    }


}
