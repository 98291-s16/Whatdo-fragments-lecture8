package edu.cmu.stuco.android.whatdo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewTaskActivity extends AppCompatActivity {
    public static final String TASK_KEY = "task";

    public static void launch(Context context, String task) {
        Intent intent = new Intent(context, ViewTaskActivity.class);
        intent.putExtra(TASK_KEY, task);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String task = intent.getStringExtra(TASK_KEY);

        ViewTaskFragment fragment = (ViewTaskFragment) getSupportFragmentManager()
                .findFragmentById(R.id.view_task_fragment);
        fragment.setTask(task);
    }
}
