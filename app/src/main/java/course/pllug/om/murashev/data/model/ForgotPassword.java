package course.pllug.om.murashev.data.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import course.pllug.om.murashev.AuthorizationActivity;
import course.pllug.om.murashev.R;


public class ForgotPassword extends Fragment {
    private View root;
    private Button sendNevPaswod;
    private EditText emailforgot;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.forgotpassword, container, false);
        viewForgotPasvord();
        return root;
    }

    private void viewForgotPasvord() {
        init();

    }

    private void init() {
        emailforgot = (EditText) root.findViewById(R.id.emailforgot);
        sendNevPaswod = (Button) root.findViewById(R.id.sendnewpassword);
        lisener();
    }

    private void lisener() {
        sendNevPaswod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    private void validateInput() {
        if (!(TextUtils.isEmpty(emailforgot.getText().toString()))) {
            Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
            ((AuthorizationActivity) getActivity()).showsingln();
        }
    }
}
