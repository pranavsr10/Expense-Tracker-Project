package com.example.expensetrackerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.expensetrackerproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardActivity extends AppCompatActivity {

    FloatingActionButton addExpenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize the FAB
        addExpenseButton = findViewById(R.id.fab_add_expense);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch AddExpenseActivity when FAB is clicked
                Intent intent = new Intent(DashboardActivity.this, AddEditExpenseActivity.class);
                startActivity(intent);
            }
        });

        // Set up other UI components to display total expenses and breakdown (use Firebase or local data)
    }
}
