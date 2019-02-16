package course.pllug.om.murashev;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DialogForUserFragment extends DialogFragment {
    private TextView company1, phone1, website1;
    private Button OK;
    private String name;
    private String company;
    private String phone;
    private String websity;
    private View root;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(name);
        root = inflater.inflate(R.layout.dialog, null);
        init();
        setInf();
        initLisener();
        return root;
    }

    private void init() {

        company1 = (TextView) root.findViewById(R.id.dialogcompany);
        phone1 = (TextView) root.findViewById(R.id.dialogpkone);
        website1 = (TextView) root.findViewById(R.id.dialogsite);
        OK = (Button) root.findViewById(R.id.dialogButton);
    }

    private void setInf() {
        company1.append(company);
        phone1.append(phone);
        website1.append(websity);
    }

    private void initLisener() {
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsity(String websity) {
        this.websity = websity;
    }

}
