package com.example.expensetrackerproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEditExpenseActivity extends AppCompatActivity {
    private EditText expenseName, amount;
    private Spinner category;
    private Button saveButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_expense);

        expenseName = findViewById(R.id.expenseName);
        amount = findViewById(R.id.amount);
        category = findViewById(R.id.category);
        saveButton = findViewById(R.id.saveButton);

        databaseReference = FirebaseDatabase.getInstance().getReference("expenses");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_options, android.R.layout.simple_spinner_item);
        category.setAdapter(adapter);

        saveButton.setOnClickListener(v -> saveExpense());
    }

    private void saveExpense() {
        String name = expenseName.getText().toString();
        String expenseAmount = amount.getText().toString();
        String categoryType = category.getSelectedItem().toString();

        String id = databaseReference.push().getKey();
        Expense expense = new Expense(id, name, Double.parseDouble(expenseAmount), categoryType);
        databaseReference.child(id).setValue(expense);
    }
}
