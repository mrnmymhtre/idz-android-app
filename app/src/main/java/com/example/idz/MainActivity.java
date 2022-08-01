package com.example.idz;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.idz.databinding.ActivityMainBinding;

import java.util.Calendar;




public class MainActivity extends AppCompatActivity {

    EditText date;
    DatePickerDialog datePickerDialog;

    private EditText Name, Email, Dob;
    private Button addEntryBtn, readEntryBtn;
    private DBHandler dbHandler;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = findViewById(R.id.idname);
        Email = findViewById(R.id.idemail);
        Dob = findViewById(R.id.iddate);
        addEntryBtn = findViewById(R.id.idsend);


        dbHandler = new DBHandler(MainActivity.this);


        addEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String idName = Name.getText().toString();
                String idEmail = Email.getText().toString();
                String idDob = Dob.getText().toString();


                if (idName.isEmpty() && idEmail.isEmpty() && idDob.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }


                dbHandler.addNewEntry( idName, idEmail, idDob);


                Toast.makeText(MainActivity.this, "Entry has been added.", Toast.LENGTH_SHORT).show();
                Name.setText("");
                Email.setText("");
                Dob.setText("");
            }
        });

        setContentView(R.layout.activity_main);

        date = (EditText) findViewById(R.id.iddate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        readEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ViewEntry.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}