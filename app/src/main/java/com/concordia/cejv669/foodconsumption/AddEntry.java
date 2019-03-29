package com.concordia.cejv669.foodconsumption;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AddEntry extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        dl = (DrawerLayout)findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, dl,R.string.nav_open, R.string.nav_close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv=findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);

        Button btSave = findViewById(R.id.buttonSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseClass dbc = new DataBaseClass(getApplicationContext());
                CalendarView cvDate = findViewById(R.id.calendarView);
                EditText etName=findViewById(R.id.editTextName);
                EditText etCalories = findViewById(R.id.editTextCalories);
                EditText etQuantity = findViewById(R.id.editTextQuantity);
                Serving serving=new Serving(cvDate.getDate(),etName.getText().toString(),Integer.parseInt(etCalories.getText().toString()),Integer.parseInt(etQuantity.getText().toString()));
                dbc.addServing(serving);
                Toast.makeText(getApplicationContext(),"Record Added",Toast.LENGTH_LONG).show();
                Intent i= new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        Button btcancel = findViewById(R.id.buttonCancel);
        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_LONG).show();
                Intent i= new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.nav_history:
                Intent i = new Intent(this, MainActivity.class);

                startActivity(i);
                break;
            case R.id.nav_add:
                Intent intent = new Intent(this, AddEntry.class);
//                intent.putExtra("sendHistory", history.toString());
                startActivity(intent);
                break;
            case R.id.exit:
                finish();
                System.exit(0);
                break;
        }

        return true;
    }
}
