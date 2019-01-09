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


public class SingUp extends Fragment {
    final String LOG_TAG = "SingUpLogs";
    Button registedReg, singInReg, forgotpasReg;
    View inflaterView;
    EditText paswordReg, loginReg, emailReg;
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
        inflaterView = inflater.inflate(R.layout.signupfragment, container,false);
        registedReg = (Button) inflaterView.findViewById(R.id.registed);
        singInReg = (Button) inflaterView.findViewById(R.id.singinreg);
        forgotpasReg  = (Button) inflaterView.findViewById(R.id.forgotpasswordreg);
        paswordReg = (EditText)  inflaterView.findViewById(R.id.pasreg);
        loginReg = (EditText) inflaterView.findViewById(R.id.logreg);
        emailReg = (EditText) inflaterView.findViewById(R.id.emailreg);

        registedReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(TextUtils.isEmpty(loginReg.getText().toString()) || TextUtils.isEmpty(paswordReg.getText().toString())
                        || TextUtils.isEmpty(emailReg .getText().toString())))

                    ((AuthorizationActivity) getActivity()).showsingln();

            }
        });
        forgotpasReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AuthorizationActivity) getActivity()).showforgotPassword();
            }
        });
        singInReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AuthorizationActivity) getActivity()).showsingln();
            }
        });
        return inflaterView;
    }
}
