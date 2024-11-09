package com.example.expensetrackerproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    Context context;
    List<Expense> expenseList;

    public ExpenseAdapter(Context context, List<Expense> expenseList) {
        this.context = context;
        this.expenseList = expenseList;
    }

    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.expense_item, parent, false);
        return new ExpenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.name.setText(expense.getName());
        holder.amount.setText(String.valueOf(expense.getAmount()));
        holder.category.setText(expense.getCategory());
        holder.date.setText(expense.getDate());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public void updateList(List<Expense> updatedList) {
        expenseList = updatedList;
        notifyDataSetChanged();
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView name, amount, category, date;

        public ExpenseViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.expense_name);
            amount = itemView.findViewById(R.id.expense_amount);
            category = itemView.findViewById(R.id.expense_category);
            date = itemView.findViewById(R.id.expense_date);
        }
    }
}
