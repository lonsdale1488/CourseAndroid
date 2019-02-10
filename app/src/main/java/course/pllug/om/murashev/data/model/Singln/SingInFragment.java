package course.pllug.om.murashev.data.model.Singln;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import course.pllug.om.murashev.R;

public class SingInFragment extends Fragment {

    private View root;
    private SingInContract.SinglInView view;
    private SingInContract.ISignInPresenter presenter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.signinfragment, container,false);
    innitView();
    innitpresenter();


        return root;
    }
    private void innitView ()
    {
        view = new SingInView();
        view.init(root);
    }
    private void innitpresenter ()
    {
        presenter = new SingInPresenter(view,this);
        view.setPresenter(presenter);
    }
}
