package pl.edu.pwr.student.s235958.tennisbeginnerapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SettingsFragment extends Fragment {
    TrainingPlanFragment trainingPlanFragment;

    User user;
    Bundle bundle;



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        bundle = getArguments();
        if (bundle != null) {
            user = (User) bundle.getSerializable("user_obj");
        }



        final EditText numberOfTrainingsText = (EditText) view.findViewById(R.id.numberOfTrainings);
        Button submit = (Button) view.findViewById(R.id.numberOfTrainingsButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( TextUtils.isEmpty(numberOfTrainingsText.getText())){
                    Toast.makeText(getContext(),
                            getContext().getResources().getString(R.string.edit_text_of_days),
                            Toast.LENGTH_SHORT).show();
                }else
                {
                    int numberofDays = Integer.parseInt(numberOfTrainingsText.getText().toString());

                    user.setTrainingPerWeek(numberofDays);
                    Toast.makeText(getContext(),
                            getContext().getResources().getString(R.string.apply),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

//    private void setTrainingDays(){
//        int daysValue = 1;
//        if(daysValue < 1 || daysValue > 7){
//
//            Toast.makeText(getContext(),"Wartość musi być w przedziale 1-7 !",Toast.LENGTH_SHORT).show();
//        }
//        else {
//
//        }
//
//
//    }
}
