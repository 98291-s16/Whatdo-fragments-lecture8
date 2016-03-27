package edu.cmu.stuco.android.whatdo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AddTaskDialogFragment extends DialogFragment {
    private DialogListener dialogListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        dialogListener = (DialogListener) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.dialog_add_task, null);
        final EditText taskEditText = (EditText) view.findViewById(R.id.task_EditText);
        builder.setView(view);
        builder.setMessage(R.string.add_task)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogListener.onPositiveClick(taskEditText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }

    public interface DialogListener {
        void onPositiveClick(String taskName);
    }
}
