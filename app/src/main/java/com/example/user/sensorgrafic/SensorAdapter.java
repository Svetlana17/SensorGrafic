package com.example.user.sensorgrafic;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder>  {
    private List<Sensor> sensors=new ArrayList<>();
    private LayoutInflater mIflater;
    private Context mContext;
    public SensorAdapter(Context context, List<Sensor> sensorList) {
    this.mContext=context;
    this.sensors=sensorList;
    this.mIflater=LayoutInflater.from(mContext);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View view=mIflater.inflate(R.layout.adapter_item,viewGroup,false);
      view.setOnClickListener((View.OnClickListener) mContext);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    final Sensor sensor=sensors.get(i);
    viewHolder.name.setText("Name: " +sensor.getName());
        viewHolder.type.setText("Type: " + String.valueOf(sensor.getType()));
        viewHolder.vendor.setText("Vendor: " + String.valueOf(sensor.getVendor()));
        viewHolder.version.setText("Version: " + String.valueOf(sensor.getVersion()));
        viewHolder.max.setText("Maximum: " + String.valueOf( sensor.getMaximumRange()));

//        viewHolder.name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 Intent intent=new Intent(mContext, GrafActivity.class);
//                 Integer i=sensor.getType();
////              String s= String.valueOf(sensor.getType());
//                    intent.putExtra("sensortype",sensor.getType());
//
//                StringBuilder sb = new StringBuilder();
//
//                mContext.startActivity(intent);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements SensorEventListener{
        TextView name;
        TextView type;
        TextView vendor;
        TextView version;
        TextView max;
        TextView resolution;
        TextView textViewX;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            type=(TextView) itemView.findViewById(R.id.type);
            vendor=(TextView)itemView.findViewById(R.id.vendor);
            version=(TextView) itemView.findViewById(R.id.version);
            max=(TextView) itemView.findViewById(R.id.max);
            resolution=(TextView) itemView.findViewById(R.id.resolution);

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            switch (event.sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER: {
                    //собственно выводим все полученые параметры в текствьюшки наши
                    textViewX.setText("ttt");
//                mYValueText.setText(String.format("%1.3f", event.values[SensorManager.DATA_Y]));
//                mZValueText.setText(String.format("%1.3f", event.values[SensorManager.DATA_Z]));
                }
                break;
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
