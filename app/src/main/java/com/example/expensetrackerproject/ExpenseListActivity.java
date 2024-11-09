package com.example.expensetrackerproject;

import android.os.Bundle;
import android.widget.Filter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpenseAdapter expenseAdapter;
    List<Expense> expenseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the list of expenses (from Firebase or local storage)
        //expenseList = getExpenses(); // Replace with your actual method for getting expenses
        expenseAdapter = new ExpenseAdapter(this, expenseList);
        recyclerView.setAdapter(expenseAdapter);
    }

    // Method to filter expenses by category
    private void filterExpenses(String category) {
        List<Expense> filteredList = filterByCategory(expenseList, category);
        expenseAdapter.updateList(filteredList);
    }

    private List<Expense> filterByCategory(List<Expense> expenseList, String category) {
        // Filter logic to return only expenses of the given category
        return expenseList;
    }
}
