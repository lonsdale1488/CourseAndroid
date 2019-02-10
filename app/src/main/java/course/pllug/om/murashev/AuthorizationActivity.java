package course.pllug.om.murashev;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import course.pllug.om.murashev.data.model.ForgotPassword;
import course.pllug.om.murashev.data.model.SingUp.SingUpFragment;
import course.pllug.om.murashev.data.model.Singln.SingInFragment;

public class AuthorizationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        showsingln();
    }

    public void replaceFragment(Fragment fragment) {
        if (fragment!=null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit(); }
    }
    public void showsingln() { replaceFragment(new SingInFragment()); }

    public void showsinglUp() { replaceFragment(new SingUpFragment()); }

    public void showforgotPassword() { replaceFragment(new ForgotPassword());
    }
    public void showMain()
    { Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    }

