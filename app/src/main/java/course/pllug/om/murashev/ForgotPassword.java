package course.pllug.om.murashev;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ForgotPassword extends Fragment {
    final String LOG_TAG = "forgotpaswordLogs";
    View inflaterView;
    Button sendNevPaswod;
    EditText emailforgot;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment1 onAttach");
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onCreate");
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment1 onCreateView");
        inflaterView = inflater.inflate(R.layout.forgotpassword, container,false);
        emailforgot = (EditText) inflaterView.findViewById(R.id.emailforgot);
        sendNevPaswod = (Button) inflaterView.findViewById(R.id.sendnewpassword);
        sendNevPaswod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(TextUtils.isEmpty(emailforgot.getText().toString()) ))
                    ((AuthorizationActivity) getActivity()).showsingln();
            }
        });
        return inflaterView;
    }
}
