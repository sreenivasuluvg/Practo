package com.studiocorp.practo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Search extends AppCompatActivity {
    EditText editText1;
    ListView lv;
    Button button1;
    ArrayAdapter<String> adapter;
    ArrayList<HashMap<String, String>> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String products[] = {"Hyderabad","Bangalore","anantapur"};

        editText1=(EditText)findViewById(R.id.editText1);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                String message=editText1.getText().toString();
//                Intent intent=new Intent();
//                intent.putExtra("MESSAGE",message);
//                setResult(2,intent);

//                finish();//finishing activity
            }
        });
        lv=findViewById(R.id.list_second);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.activity_result, R.id.product_name, products);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message=adapter.getItem(position);

                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);

                if(message.equalsIgnoreCase("Anantapur")){

                    Toast.makeText(Search.this, "Welcome"+message, Toast.LENGTH_SHORT).show();
                }
                if(message.equalsIgnoreCase("Hyderabad")){

                    Toast.makeText(Search.this, "Welcome"+message, Toast.LENGTH_SHORT).show();
                }
                if(message.equalsIgnoreCase("Bangalore")){

                    Toast.makeText(Search.this, "Welcome"+message, Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Search.this.adapter.getFilter().filter(cs);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }
}
