package course.pllug.om.murashev.model.SingUp;

import android.text.TextUtils;

import course.pllug.om.murashev.AuthorizationActivity;
import course.pllug.om.murashev.model.Singln.SingInContract;
import course.pllug.om.murashev.model.Singln.SingInFragment;

public class SingUpPresenter implements SingUpContract.SingUpPresenter{
    private SingUpContract.SingUpView view;
    private SingUpFragment fragment;
    final String LOG_TAG = "SingiNLogs";

    public SingUpPresenter(SingUpContract.SingUpView view, SingUpFragment fragment) {
        this.view = view;
        this.fragment = fragment;
    }
    @Override
    public void showsingln() {
        ((AuthorizationActivity) fragment.getActivity()).showsingln();
    }

    @Override
    public void showforgotPassword() {
        ((AuthorizationActivity) fragment.getActivity()).showforgotPassword();
    }

    @Override
    public void showRegistration() {
        validateInput();
    }

    private void validateInput()
    { String login = view.getLoginText();
      String pasword = view.getPasswordText();
      String email = view.getEmaiText();

        if (!(TextUtils.isEmpty(login) || TextUtils.isEmpty(pasword)|| TextUtils.isEmpty(email))) {
            ((AuthorizationActivity) fragment.getActivity()).showsingln();
        }
    }

}
