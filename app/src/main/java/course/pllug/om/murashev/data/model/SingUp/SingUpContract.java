package course.pllug.om.murashev.data.model.SingUp;

import android.view.View;

public interface SingUpContract {


     interface SingUpView {

        void init (View root);

        void setPresenter (SingUpPresenter presenter);

        String getLoginText();

        String getPasswordText();

        String getEmaiText();

    }
    interface SingUpPresenter{

       void showsingln();

       void showforgotPassword();

       void showRegistration();
    }

}
