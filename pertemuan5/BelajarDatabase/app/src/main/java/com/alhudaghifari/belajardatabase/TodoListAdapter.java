package com.alhudaghifari.belajardatabase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ghifar on 13/07/18.
 */

public class TodoListAdapter extends
        RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    ArrayList<Item> itemArrayList;
    Context context;

    public TodoListAdapter(ArrayList<Item> itemArrayList, Context context) {
        this.itemArrayList = itemArrayList;
        this.context = context;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        final Item item = itemArrayList.get(position);
        holder.todoText.setText(item.getName());

        holder.editImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,
                        AddEditActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("name", item.getName());
                intent.putExtra("priority", item.getPriority());
                context.startActivity(intent);
            }
        });

        holder.doneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              MyDatabase database = new MyDatabase(context);
              database.deleteItem(item.getId());

              itemArrayList.clear();
              itemArrayList.addAll(database.getAll());
              notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class TodoViewHolder extends
            RecyclerView.ViewHolder {
        TextView todoText;
        ImageView editImageView;
        ImageView doneImageView;

        public TodoViewHolder(View itemView) {
            super(itemView);

            todoText = itemView.findViewById(R.id.todo_text);
            editImageView = itemView.findViewById(R.id.edit_todo);
            doneImageView = itemView.findViewById(R.id.done_todo);
        }
    }
}
