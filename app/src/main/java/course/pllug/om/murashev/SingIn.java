package course.pllug.om.murashev;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SingIn extends Fragment{
    final String LOG_TAG = "SingiNLogs";
    Button singIn, singUp, forgotpassword;
    View inflaterView;
    EditText pasword, login;

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        Log.d(LOG_TAG, "Fragment1 onAttach");
//    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onCreate");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment1 onCreateView");
        inflaterView = inflater.inflate(R.layout.signinfragment, container,false);
        singIn = (Button) inflaterView.findViewById(R.id.singin);
        singUp = (Button) inflaterView.findViewById(R.id.singup);
        forgotpassword  = (Button) inflaterView.findViewById(R.id.forgotpassword);
        pasword = (EditText)  inflaterView.findViewById(R.id.pas);
        login = (EditText) inflaterView.findViewById(R.id.log);

        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(TextUtils.isEmpty(login.getText().toString()) || TextUtils.isEmpty(pasword.getText().toString())))
                //((AuthorizationActivity) getActivity()).showMain();
                    ((AuthorizationActivity) getActivity()).showMain3();
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AuthorizationActivity) getActivity()).showforgotPassword();
            }
        });
        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AuthorizationActivity) getActivity()).showsinglUp();
            }
        });
        return inflaterView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Fragment onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment onDetach");
    }
}
