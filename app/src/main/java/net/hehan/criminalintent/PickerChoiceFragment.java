package net.hehan.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import java.util.Date;

/**
 * Created by han on 14-9-2.
 */
public class PickerChoiceFragment extends DialogFragment {
    public static final String EXTRA_DATE = "net.hehan.criminalintent.date";
    private static final String DIALOG_DATE = "date";
    private static final String DIALOG_TIME = "time";

    private Date mDate;

    public static PickerChoiceFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);

        PickerChoiceFragment fragment = new PickerChoiceFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDate = (Date) getArguments().getSerializable(EXTRA_DATE);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_choice, null);

        Button dateChoice = (Button) v.findViewById(R.id.dialog_choice_date_btn);
        Button timeChoice = (Button) v.findViewById(R.id.dialog_choice_time_btn);

        dateChoice.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mDate);
                dialog.setTargetFragment(getTargetFragment(), CrimeFragment.REQUEST_DATE);
                dialog.show(fm, DIALOG_DATE);
                PickerChoiceFragment.this.dismiss();
            }
        });
        timeChoice.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(mDate);
                dialog.setTargetFragment(getTargetFragment(), CrimeFragment.REQUEST_TIME);
                dialog.show(fm, DIALOG_TIME);
                PickerChoiceFragment.this.dismiss();
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Which one to set")
                .create();
    }
}
