package course.pllug.om.murashev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final String LOG_TAG = "Main";
    final int DIALOG_EXIT = 1;
    DialogFragment dialogForUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        showProfile();
        initToolbar();
    }

    private void initToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);// створюэмо новий дравер леяую
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_container2, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void showProfile() {
        replaceFragment(new ProfileFragment());
    }

    public void showAlbumList() {
        replaceFragment(new AlbumListFragment());
    }

    public void showPostsList() {
        replaceFragment(new PostsListFragment(this));
    }

    public void showPhotoList() {
        replaceFragment(new PhotoAlbumFragment(this));
    }

    public void showUsershList() {
        replaceFragment(new UsersFragment(this));
    }

    public void showAlbumNumber() {
        replaceFragment(new AlbumElementFragment());
    }

    public void showPostNumber() {
        replaceFragment(new PostElementFragment());
    }

    public void showDialog(String name, String company, String phone, String websity) {
        dialogForUser = new DialogForUserFragment();
        ((DialogForUserFragment) dialogForUser).setName(name);
        ((DialogForUserFragment)dialogForUser).setCompany(company);
        ((DialogForUserFragment)dialogForUser).setPhone(phone);
        ((DialogForUserFragment)dialogForUser).setWebsity(websity);
        dialogForUser.show(getSupportFragmentManager(),"dialogForUser");

    }
    public void showAuthorizationActiviti() {
        Intent intent = new Intent(this, AuthorizationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) { // обробник толбару
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            showProfile();
        } else if (id == R.id.nav_posts) {
            showPostsList();
        } else if (id == R.id.nav_album) {

            showAlbumList();
        } else if (id == R.id.nav_photo) {

            showPhotoList();
        } else if (id == R.id.nav_profileother) {
            showUsershList();
        } else if (id == R.id.Exit) {
            showAuthorizationActiviti();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
