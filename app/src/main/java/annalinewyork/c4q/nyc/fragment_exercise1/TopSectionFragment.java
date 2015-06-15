package annalinewyork.c4q.nyc.fragment_exercise1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TopSectionFragment extends Fragment {

    private static final String TAG = "TopSectionFragment";

    private Context context;

    private EditText topTextInput;
    private EditText bottomTextInput;

    TopSectionListener parentContainer = null;

    //Activity parentActivity;
    //MainActivity parentActivity;

    public interface TopSectionListener {
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;

        try {
            parentContainer = (TopSectionListener) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, "host activity must implement TopSectionListener");
            parentContainer = null;
            // throw new ClassCastException(activity.toString());
        }
        //  parentActivity = (MainActivity) activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);


        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
            }
        });

        return view;
    }

    public void createMeme(String top, String bottom) {
        if (parentContainer != null) {
            parentContainer.createMeme(top, bottom);
        } else {
            Toast.makeText(context, "creatMeme function is not avaiable", Toast.LENGTH_SHORT).show();
        }
        //activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString())
    }
}
