package com.example.expensetrackerproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditExpenseActivity extends AppCompatActivity {

    EditText expenseName, amount;
    Spinner category;
    // Add date picker if required
    // Firebase references (or any local storage mechanism) for saving expenses

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_expense);

        expenseName = findViewById(R.id.et_expense_name);
        amount = findViewById(R.id.et_amount);
        category = findViewById(R.id.spinner_category);

        // Add save button listener
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExpense();
            }
        });
    }

    private void saveExpense() {
        String name = expenseName.getText().toString().trim();
        String amountValue = amount.getText().toString().trim();
        String selectedCategory = category.getSelectedItem().toString();

        // Save to Firebase or local storage

        // Toast message on success
        Toast.makeText(this, "Expense Saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
