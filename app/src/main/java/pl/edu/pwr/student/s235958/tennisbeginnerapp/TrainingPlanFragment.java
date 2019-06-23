package pl.edu.pwr.student.s235958.tennisbeginnerapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class TrainingPlanFragment extends Fragment {

    int trainingAmount = 0;
    int trainingPerWeek = 3;
    TextView countTextView;
    TextView numbersOfTrainingTextView;
    User user;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_training_plan, container, false);
        countTextView = (TextView) view.findViewById(R.id.counter_text);
        //countTextView.setText(trainingAmount);

        numbersOfTrainingTextView = (TextView) view.findViewById(R.id.numberOfTrainingsText);
//        numbersOfTrainingTextView.setText(trainingPerWeek);

        final ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);
        progressBar.setProgress(trainingAmount);

        Button button = (Button)view.findViewById(R.id.progress_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(trainingAmount == trainingPerWeek){
//                    trainingAmount = 0;
//                    progressBar.setProgress(0);
//                }
//                else{
//                    increment();
//                    progressBar.setProgress(progressBar.getProgress()+1);
//                }

                if( TextUtils.isEmpty(countTextView.getText())){
                    Toast.makeText(getContext(),
                            getContext().getResources().getString(R.string.edit_text_of_days),
                            Toast.LENGTH_SHORT).show();
                }else
                {
                    if(trainingAmount < trainingPerWeek*100)
                    {
                        trainingAmount += Integer.parseInt(countTextView.getText().toString());
                        progressBar.setProgress(trainingAmount/trainingPerWeek);
                        countTextView.setText(Integer.toString(trainingAmount));
                    }
                    if(trainingAmount >= trainingPerWeek*100)
                    {
                        Toast.makeText(getContext(),
                                "Sukces!",
                                Toast.LENGTH_SHORT).show();
                        trainingAmount = trainingPerWeek*100;
                    }
                }


            }
        });

        bundle = getArguments();
        if (bundle != null) {
            user = (User) bundle.getSerializable("user_obj");
            trainingPerWeek = user.getTrainingPerWeek();
            trainingAmount = user.getTrainingAmount();
        }


        return view;
    }
    public void increment(){
        trainingAmount++;
        countTextView.setText(String.valueOf(trainingAmount));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();

        if (bundle != null) {
            user.setTrainingAmount(trainingAmount);
        }

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
//        String stateSaved = savedInstanceState.getString("save_state");
//        try{
//
//        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
