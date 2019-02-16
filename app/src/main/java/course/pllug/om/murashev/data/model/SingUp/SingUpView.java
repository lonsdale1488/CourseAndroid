package course.pllug.om.murashev.data.model.SingUp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import course.pllug.om.murashev.R;

public class SingUpView implements SingUpContract.SingUpView {
      private Button registedReg;
      private TextView singInReg, forgotpasReg;
      private EditText paswordReg, loginReg, emailReg;
      private SingUpContract.SingUpPresenter presenter;

    @Override
    public void setPresenter(SingUpContract.SingUpPresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void init(View root) {
            registedReg = (Button) root.findViewById(R.id.registed);
            singInReg = (TextView) root.findViewById(R.id.singinreg);
            forgotpasReg  = (TextView) root.findViewById(R.id.forgotpasswordreg);
            paswordReg = (EditText)  root.findViewById(R.id.pasreg);
            loginReg = (EditText) root.findViewById(R.id.logreg);
            emailReg = (EditText) root.findViewById(R.id.emailreg);
            Listenet();

    }

    public void Listenet()
    {
            registedReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.showRegistration();
                }
            });
            forgotpasReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.showforgotPassword();
                }
            });
            singInReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.showsingln();
                }
            });
    }

    @Override
    public String getLoginText() {
        return loginReg.getText().toString();
    }

    @Override
    public String getPasswordText() {
        return paswordReg.getText().toString();
    }

    @Override
    public String getEmaiText() {
        return emailReg.getText().toString();
    }
}
