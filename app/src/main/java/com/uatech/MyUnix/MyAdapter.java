package com.uatech.MyUnix;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Node> data;
    String colorArray[] = {"#D5EEE4", "#B6EAD7", "#9BD5C0", "#88CDB2", "#77BAA0", "#6BA790", "#5BA387", "#4CA381", "#4EA281"};

    MyAdapter(Context context, ArrayList data)
    {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Node node = data.get(position);

        holder.textView.setText(node.name);
        try {
            holder.listSubtitle.setText(node.description);
        }catch (NullPointerException e)
        {

        }
        int var = R.drawable.c;
        try{
            holder.image.setImageResource(Integer.parseInt(node.url));
        }catch (Exception e)
        {
            holder.image.setImageResource(R.drawable.hashtag_icon3);
        }
        holder.cardView.setCardBackgroundColor(Color.parseColor(colorArray[position%9]));
        Log.d("view binder ", "invoked");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String className = context.toString().substring(context.toString().lastIndexOf('.')+1, context.toString().lastIndexOf('@'));
               Intent intent;
               //holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));

               switch (className)
               {
                   case "MainActivity":
                       Log.d("switch case", "Main Activity");
                       intent = new Intent(context, CoursesActivity.class);

                       BluePrint.shift(position);
                       context.startActivity(intent);
                       //((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                       break;
                   case "CoursesActivity":
                       intent = new Intent(context, SemesterActivity.class);
                       BluePrint.shift(position);
                       //intent.putExtra("position", position);
                       //((Activity)context).finish();
                       context.startActivity(intent);
                       //((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                       break;

                   case "SemesterActivity":
                       Log.d("switch case ", "Semester Activity");
                       intent = new Intent(context, SubjectActivity.class);
                       BluePrint.shift(position);
                       //intent.putExtra("position", position);
                       //((Activity)context).finish();
                       context.startActivity(intent);
                       //((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                       break;

                   case "SubjectActivity":
                       intent = new Intent(context, PrevYearsActivity.class);
                       BluePrint.shift(position);
                       //intent.putExtra("position", position);
                       //((Activity)context).finish();
                       context.startActivity(intent);
                       //((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                       break;

                   case "PrevYearsActivity":
                       intent = new Intent(context, WebViewActivity.class);
                       BluePrint.shift(position);
                       //intent.putExtra("position", position);
                       //((Activity)context).finish();
                       context.startActivity(intent);
                       //((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                       break;
               }
               //intent = new Intent(context, SemesterActivity.class);
               //intent.putExtra("position", position);
               Log.d("context", context.toString());

               Log.d("class name", className);

               //Log.d("item no ", " "+position);
               //((Activity)context).finish();
               //context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView, listSubtitle;
        CardView cardView;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            listSubtitle = (TextView) itemView.findViewById(R.id.list_subtitle);
            image = (ImageView) itemView.findViewById(R.id.image_view);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
