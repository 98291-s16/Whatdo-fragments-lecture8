package edu.cmu.stuco.android.whatdo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<String> tasks;
    private final OnTaskClickListener listener;


    public TaskRecyclerAdapter(Context context, ArrayList<String> tasks, OnTaskClickListener listener) {
        this.context = context;
        this.tasks = tasks;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String task = tasks.get(position);
        holder.taskTextView.setText(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskTextView;
        View container;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTaskClick(tasks.get(getAdapterPosition()));
                }
            });

            taskTextView = (TextView) itemView.findViewById(R.id.task_TextView);
            container = (View) taskTextView.getParent();
        }

    }

    public interface OnTaskClickListener {
        void onTaskClick(String task);
    }
}
