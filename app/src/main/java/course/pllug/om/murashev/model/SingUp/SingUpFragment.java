package course.pllug.om.murashev.model.SingUp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import course.pllug.om.murashev.R;


public class SingUpFragment extends Fragment {

    private View root;
    private SingUpContract.SingUpView view;
    private SingUpContract.SingUpPresenter presenter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.signupfragment, container,false);
        innitView();
        innitpresenter();


        return root;
    }
    private void innitView ()
    {
        view = new SingUpView();
        view.init(root);
    }
    private void innitpresenter ()
    {
        presenter = new SingUpPresenter(view,this);
        view.setPresenter(presenter);
    }


}
