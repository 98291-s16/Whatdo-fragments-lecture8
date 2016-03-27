package edu.cmu.stuco.android.whatdo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<String> tasks;

    public TaskListAdapter(Context context, ArrayList<String> tasks) {
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public String getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_task, parent, false);
        }

        TextView taskTextView = (TextView) convertView.findViewById(R.id.task_TextView);
        taskTextView.setText(getItem(position));

        return convertView;
    }
}
