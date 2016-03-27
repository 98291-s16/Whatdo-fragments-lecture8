package edu.cmu.stuco.android.whatdo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements AddTaskDialogFragment.DialogListener,
        TaskRecyclerAdapter.OnTaskClickListener {
    private boolean isDualPane;
    private CreateTaskFragment createFragment;
    private ViewTaskFragment viewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View viewToDo = findViewById(R.id.view_task_fragment);
        isDualPane = viewToDo != null && viewToDo.getVisibility() == View.VISIBLE;
        createFragment = (CreateTaskFragment) getSupportFragmentManager()
                .findFragmentById(R.id.create_to_do_fragment);
        if (isDualPane) {
            viewFragment = (ViewTaskFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.view_task_fragment);
        }
    }

    @Override
    public void onPositiveClick(String taskName) {
        createFragment.addTask(taskName);
    }

    @Override
    public void onTaskClick(String task) {
        if (isDualPane) {
            viewFragment.setTask(task);
        } else {
            ViewTaskActivity.launch(this, task);
        }
    }
}
