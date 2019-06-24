package pl.edu.pwr.student.s235958.tennisbeginnerapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;


public class TrainingPlanFragment extends Fragment {

    int trainingAmount = 0;
    TextView countTextView;
    TextView numbersOfTrainingTextView;
    EditText trainingDaysEditText;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_training_plan, container, false);

//        if(savedInstanceState != null){
//            countTextView = savedInstanceState.getString("counter", 0);
//
//        }

        countTextView = (TextView) view.findViewById(R.id.counter_text);
        numbersOfTrainingTextView = (TextView) view.findViewById(R.id.numberOfTrainingsCount);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        trainingDaysEditText = (EditText) view.findViewById(R.id.trainingDaysEditText);




        Button buttonAdd = (Button) view.findViewById(R.id.progress_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trainingDays = trainingDaysEditText.getText().toString();
                try {
                    if (Integer.parseInt(trainingDays) < 8 && Integer.parseInt(trainingDays) > 0 && trainingAmount < Integer.parseInt(trainingDays)) {
                        increment();
                        progressBar.setProgress(trainingAmount * 100 / Integer.parseInt(trainingDays));
                        numbersOfTrainingTextView.setText(String.valueOf(trainingDays));
                    } else {
                        Toast.makeText(getContext(), "Żądana wartość nie mieści się w przedziale 1-7", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(),
                            "Wpisz liczbę od 1 do 7",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });


        return view;
    }

    public void increment() {
        trainingAmount++;
        countTextView.setText(String.valueOf(trainingAmount));
        Toast.makeText(getContext(), "Trening zrobiony!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();
        trainingDaysEditText = getActivity().findViewById(R.id.trainingDaysEditText);
        countTextView = getActivity().findViewById(R.id.counter_text);
        numbersOfTrainingTextView = getActivity().findViewById(R.id.numberOfTrainingsCount);

        SharedPreferences preferences = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("trEF", String.valueOf(trainingDaysEditText));
        editor.putString("countTV",String.valueOf(countTextView));
        editor.putString("numTV",String.valueOf(numbersOfTrainingTextView));
        editor.commit();


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        trainingDaysEditText = getActivity().findViewById(R.id.trainingDaysEditText);
        countTextView = getActivity().findViewById(R.id.counter_text);
        numbersOfTrainingTextView = getActivity().findViewById(R.id.numberOfTrainingsCount);
        outState.putString("trET", String.valueOf(trainingDaysEditText));
        outState.putString("countTV",String.valueOf(countTextView));
        outState.putString("numTV",String.valueOf(numbersOfTrainingTextView));


    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);



    }
}