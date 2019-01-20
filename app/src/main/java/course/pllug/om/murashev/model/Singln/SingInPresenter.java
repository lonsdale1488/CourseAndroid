package course.pllug.om.murashev.model.Singln;

import android.text.TextUtils;
import android.util.Log;

import course.pllug.om.murashev.AuthorizationActivity;

public class SingInPresenter implements SingInContract.ISignInPresenter {
    private SingInContract.SinglInView view;
    private SingInFragment fragment;
    final String LOG_TAG = "SingiNLogs";
    public SingInPresenter(SingInContract.SinglInView view, SingInFragment fragment) {
        this.view = view;
        this.fragment = fragment;
    }

    @Override
    public void signInClick() {
        validateInput();
    }


    private void validateInput() {
        String login = view.getLoginText();
        String password = view.getPasswordText();
        Log.d(LOG_TAG, login);
        Log.d(LOG_TAG, password);
        if (!(TextUtils.isEmpty(login) || TextUtils.isEmpty(password))) {
              ((AuthorizationActivity) fragment.getActivity()).showMain3();
        }


    }
    @Override
    public void showSignUp() {
        ((AuthorizationActivity) fragment.getActivity()).showsinglUp();
    }

    @Override
    public void showForgotPassword() {
        ((AuthorizationActivity) fragment.getActivity()).showforgotPassword();
    }
}
