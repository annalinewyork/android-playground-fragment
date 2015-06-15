package annalinewyork.c4q.nyc.fragment_exercise1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class BottomPictureFragment extends Fragment {

    private TextView topMemeText;
    private TextView bottomMemeText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);

        topMemeText = (TextView)view.findViewById(R.id.textView);
        bottomMemeText = (TextView)view.findViewById(R.id.textView2);

        return view;
    }

    public void setMemeText (String top, String bottom){
        topMemeText.setText(top);
        bottomMemeText.setText(bottom);
    }

}
