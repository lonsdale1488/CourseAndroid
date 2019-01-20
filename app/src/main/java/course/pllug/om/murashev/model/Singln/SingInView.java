package course.pllug.om.murashev.model.Singln;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import course.pllug.om.murashev.AuthorizationActivity;
import course.pllug.om.murashev.R;

public class SingInView implements SingInContract.SinglInView {


    private Button singIn, singUp, forgotpassword;
    private EditText pasword, login;
    private SingInContract.ISignInPresenter presenter;


    @Override
    public void setPresenter(SingInContract.ISignInPresenter presenter) {
    this.presenter = presenter;
    }

    public void init(View root) {
        singIn = (Button) root.findViewById(R.id.singin);
        singUp = (Button) root.findViewById(R.id.singup);
        forgotpassword  = (Button) root.findViewById(R.id.forgotpassword);
        pasword = (EditText)  root.findViewById(R.id.pas);
        login = (EditText) root.findViewById(R.id.log);
        initListener();
    }

    public void initListener ()    // лысенери для кнопок
    {
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
    public void hideLoginError() {}

    @Override
    public void hidePasswordError() { }

    @Override
    public void showLoginError() {}

    @Override
    public void showPasswordError() {}

    @Override
    public String getLoginText() { return login.getText().toString(); }

    @Override
    public String getPasswordText() {return pasword.getText().toString();}


}
