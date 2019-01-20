package course.pllug.om.murashev.model.Singln;

import android.view.View;

public interface SingInContract {

interface SinglInView
{
    void init(View root); // ініціалізація

    void setPresenter(ISignInPresenter presenter);

    void hideLoginError();

    void hidePasswordError();

    void showLoginError();

    void showPasswordError();

    String getLoginText();

    String getPasswordText();
}
    interface ISignInPresenter {
        void signInClick();

        void showSignUp();

        void showForgotPassword();

    }

}
