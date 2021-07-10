package com.example.recyclerview;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Pizza_Adapter extends RecyclerView.Adapter<Pizza_Adapter.pizzaViewHolder>{
    String[] namePizza = {"Маргарита","Дьябло", "Гавайская пицца", "Капричоза",
            "Пицца по-неаполитански", "Пицца с морепродуктами", "Четыре мяса",
            "Овощная пицца", "Пицца с тунцом", "Четыре сезона", "Цыпенок BBQ",
            "Сицилийская", "Четыре сыра", "Кальцоне", "Фокачча", "Десертные",
            "Национальные", "Белая", "Чёрная" , "Регина"};
    int[] imageId = {R.drawable.margarita, R.drawable.dyablo, R.drawable.gavaiskaya_pizza,
            R.drawable.kaprichoza, R.drawable.neapolitanski, R.drawable.s_moreproduktami, R.drawable.chetiri_myasa,
            R.drawable.ovoshnaya_pizza, R.drawable.s_tuntsom, R.drawable.chetiti_sezona, R.drawable.siplyonok_bbq,
            R.drawable.sitsiliyskaya, R.drawable.chetiri_sira, R.drawable.kaltsone, R.drawable.fokachcha, R.drawable.desertniy,
            R.drawable.natsionalniy, R.drawable.belaya, R.drawable.chyornaya, R.drawable.regina};

    @Override
    public pizzaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view, parent, false);

        pizzaViewHolder viewHolder = new pizzaViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(pizzaViewHolder holder, int position) {
        holder.textView.setText(namePizza[position]);
        holder.imageView.setImageResource(imageId[position]);

        dayNight(holder);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), pizza.class);
                intent.putExtra("textView",  namePizza[position]);
                intent.putExtra("imageView", imageId[position]);
                intent.putExtra("position",  position);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namePizza.length;
    }

    class pizzaViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        RelativeLayout relativeLayout;

        public pizzaViewHolder(View view){
            super(view);

            textView = view.findViewById(R.id.pizza_name);
            imageView = view.findViewById(R.id.image_pizza);
            constraintLayout = view.findViewById(R.id.constraintLayout12);
            relativeLayout = view.findViewById(R.id.relLay);

        }
    }

    public static void dayNight(Pizza_Adapter.pizzaViewHolder holder){
        if(!MainActivity.t) {
            holder.relativeLayout.setBackgroundResource(R.color.black);
            holder.constraintLayout.setBackgroundResource(R.color.darkBlue);
        } else {
            holder.relativeLayout.setBackgroundResource(R.color.white);
            holder.constraintLayout.setBackgroundResource(R.color.teal_600);
        }
    }
}
