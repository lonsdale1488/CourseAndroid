package course.pllug.om.murashev;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
                    .commit();
        }
    }
        public void showsingln() {
            replaceFragment(new SingIn());

        }
        public void showsinglUp() {
        SingUp singUp = new SingUp();
        replaceFragment(singUp);
    }

    public void showforgotPassword() {

        replaceFragment(new ForgotPassword());
    }

    public void showMain3 ()
    { Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    }

