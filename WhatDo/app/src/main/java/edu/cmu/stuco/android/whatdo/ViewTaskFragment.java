package edu.cmu.stuco.android.whatdo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AndrewOrobator on 3/17/16.
 */
public class ViewTaskFragment extends Fragment {
    private TextView taskTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_task, container, false);
        taskTextView = (TextView) view.findViewById(R.id.task_TextView);
        return view;
    }

    public void setTask(String task) {
        taskTextView.setText("Clicked on task: " + task);
    }
}
