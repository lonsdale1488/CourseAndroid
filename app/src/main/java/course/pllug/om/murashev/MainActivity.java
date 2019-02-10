package course.pllug.om.murashev;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final String LOG_TAG = "Main";
    final int DIALOG_EXIT = 1;
    private    String name,company, phone, website;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        showProfile();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dialog = new Dialog(this);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

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
    public void showUsershList()
    {
        replaceFragment(new UsersFragment(this));
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
    public void showAuthorizationActiviti()
    { Intent intent = new Intent(this,AuthorizationActivity.class);
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
        }

        else if (id == R.id.Exit) {
            showAuthorizationActiviti();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


//    protected Dialog onCreateDialog(int id) {
//        if (id == DIALOG_EXIT) {
//            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//            // заголовок
//            dialog.setTitle(name);
//            // сообщение
//            dialog.setMessage(company);
//            // иконка
//            dialog.setMessage(phone);
//            // иконка
//            dialog.setMessage(website);
//            // иконка
//            dialog.setIcon(android.R.drawable.ic_dialog_info);
//            // кнопка положительного ответа
//            dialog.setPositiveButton("OK", (DialogInterface.OnClickListener) myClickListener);
//
//            return dialog.create();
//        }
//        return super.onCreateDialog(id);
//    }
//    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
//        public void onClick(DialogInterface dialog, int which) {
//            switch (which) {
//                // положительная кнопка
//                case Dialog.BUTTON_POSITIVE:
//                    break;
//
//            }
//        }
//    };
    public void showDialogWithParametr(String name, String company, String phone, String websity)
    {
//        this.name = name;
//        this.company = websity;
//        this.phone= company;
//        this.website = websity;

        dialog.setTitle(name);
        // Передайте ссылку на разметку
        dialog.setContentView(R.layout.dialog);
        // Найдите элемент TextView внутри вашей разметки
        // и установите ему соответствующий текст
        TextView company1 = (TextView) dialog.findViewById(R.id.dialogcompany);
        TextView phone1 = (TextView) dialog.findViewById(R.id.dialogpkone);
        TextView website1 = (TextView) dialog.findViewById(R.id.dialogsite);
        Button OK = (Button) dialog.findViewById(R.id.dialogButton);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "work dialog");
                dialog.cancel();
            }
        });
        company1.append(company);
        phone1.append(phone);
        website1.append(websity);

        dialog.show();
      //  showDialog(DIALOG_EXIT);
    }










}
