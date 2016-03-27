package edu.cmu.stuco.android.whatdo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by AndrewOrobator on 3/17/16.
 */
public class CreateTaskFragment extends Fragment {
    private ArrayList<String> tasks = new ArrayList<>();
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.create_task, container, false);

        FloatingActionButton addItemFab = (FloatingActionButton) view.findViewById(R.id.add_item_fab);
        addItemFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new AddTaskDialogFragment();
                fragment.show(getFragmentManager(), "AddTask");
            }
        });


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TaskRecyclerAdapter(getActivity(), tasks, (TaskRecyclerAdapter.OnTaskClickListener) getActivity()));


        return view;
    }

    public void addTask(String taskName) {
        tasks.add(taskName);
        recyclerView.getAdapter().notifyItemInserted(tasks.size() - 1);
    }

}
