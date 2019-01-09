package course.pllug.om.murashev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final String LOG_TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        showProfile();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);// створюэмо новий дравер леяую
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void replaceFragment(Fragment fragment) {
        if (fragment!=null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_container2, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
    public void showProfile()
    {
        replaceFragment(new Profile());
    }

    public void showAlbumList()
    {
        replaceFragment(new AlbumList(this));
    }
    public void showPostsList()
    {
        replaceFragment(new PostsList(this));
    }
    public void showPhotoList()
    {
        replaceFragment(new PhotoAlbum(this));
    }

    public void showCommensList()
    {
        replaceFragment(new CommentsList(this));
    }

    public void showAlbumNumber()
    {
        replaceFragment(new AlbumNumber());
    }
    public void showPostNumber()
    {
        replaceFragment(new PostNumber());
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
        } else if (id == R.id.nav_comment) {

        } else if (id == R.id.nav_album) {

            showAlbumList();
        } else if (id == R.id.nav_photo) {

            showPhotoList();
        } else if (id == R.id.nav_profileother) {

        }

        else if (id == R.id.nav_share) { }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
