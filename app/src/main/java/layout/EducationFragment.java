package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gaurav.vouchdog.AddEduInfo;
import com.example.gaurav.vouchdog.AddNewIdInfo;
import com.example.gaurav.vouchdog.R;

public class EducationFragment extends Fragment {
Button b10;

    public EducationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_education, container, false);
        b10=(Button)v.findViewById(R.id.button10);

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddEduInfo.class);
                startActivity(intent);
            }
        });
        return v;
    }


}
