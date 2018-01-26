package com.studiocorp.practo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DashboardFragment extends Fragment {

    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        context = getActivity();
//        Button textView = (Button) view.findViewById(R.id.details_dashboard);
        TextView textView1 = (TextView) view.findViewById(R.id.add_dash);
        TextView textView2 = (TextView) view.findViewById(R.id.reading_dashboard);
        TextView textView=(TextView) view.findViewById(R.id.interst_dashboard);
        TextView textView4 = (TextView) view.findViewById(R.id.diss);
        TextView textView5 = (TextView) view.findViewById(R.id.refer);
        TextView textView6 = (TextView) view.findViewById(R.id.card);
        TextView textView7 = (TextView) view.findViewById(R.id.share);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AddIntrest.class);
                startActivity(intent);
            }
        });
    return view;
    }

    public void onStart() {
        super.onStart();

        TextView bt = (TextView) context.findViewById(R.id.details_dashboard);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //create an Intent object
                Intent intent = new Intent(context, AddDetails.class);
                //add data to the Intent object

                //start the second activity
                startActivity(intent);
            }

        });
    }


    }







