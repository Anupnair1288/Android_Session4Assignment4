package com.android.anup.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anup on 01-11-2016.
 */
public class Adapter extends BaseAdapter{
    Context context;
    LayoutInflater inflater;
    ArrayList<Integer> image;
    ArrayList<String> title;

    public Adapter(Context c, ArrayList<Integer> image1, ArrayList<String> title1) {
        this.context = c;
        this.image = image1;
        this.title = title1;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.logo_view, parent, false);
            holder = new ViewHolder();
            holder.bindView(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.icon.setImageResource(image.get(position));
        holder.textview.setText((CharSequence) title.get(position));
        return convertView;
    }

    private class ViewHolder {
        ImageView icon;
        TextView textview;
        void bindView(View convertView){
            icon = (ImageView)convertView.findViewById(R.id.logoimage);
            textview = (TextView)convertView.findViewById(R.id.textview);
        }
    }
}
