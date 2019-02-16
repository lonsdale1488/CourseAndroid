package course.pllug.om.murashev.data.model.Singln;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import course.pllug.om.murashev.R;

public class SingInView implements SingInContract.SinglInView {


    private Button singIn;
    private EditText pasword, login;
    private SingInContract.ISignInPresenter presenter;
    private TextView singUp, forgotpassword;


    @Override
    public void setPresenter(SingInContract.ISignInPresenter presenter) {
        this.presenter = presenter;
    }

    public void init(View root) {
        singIn = (Button) root.findViewById(R.id.singin);
        singUp = (TextView) root.findViewById(R.id.singup);
        forgotpassword = (TextView) root.findViewById(R.id.forgotpassword);
        pasword = (EditText) root.findViewById(R.id.pas);
        login = (EditText) root.findViewById(R.id.log);
        initListener();
    }

    public void initListener() {
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signInClick();
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showForgotPassword();
            }
        });
        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showSignUp();
            }
        });
    }


    @Override
    public void hideLoginError() {
    }

    @Override
    public void hidePasswordError() {
    }

    @Override
    public void showLoginError() {
    }

    @Override
    public void showPasswordError() {
    }

    @Override
    public String getLoginText() {
        return login.getText().toString();
    }

    @Override
    public String getPasswordText() {
        return pasword.getText().toString();
    }


}
