package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import info.androidhive.materialdesign.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new courses();
                title = getString(R.string.title_courses);
                break;
            case 2:
                //fragment = new MessagesFragment();
                chat_app();
                title = getString(R.string.title_messages);
                break;
            case 3:
                fragment = new calendar();
                title = getString(R.string.title_calendar);
                break;
            case 4:
                fragment = new images();
                title = getString(R.string.title_images);
                break;
            case 5:
                fragment = new map();
                title = getString(R.string.title_map);
                break;
            case 6:
                fragment = new schedule();
                title = getString(R.string.title_schedule);
                break;
            case 7:
                fragment = new clubs();
                title = getString(R.string.title_clubs);
                break;
            case 8:
                fragment = new twitter();
                title = getString(R.string.title_twitter);
                break;
            case 9:
                fragment = new MessagesFragment();
                title = getString(R.string.title_website);
                break;
            default:
                break;
        }



        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
    public void chat_app(){
        Intent JPCEssentials_chat = getPackageManager().getLaunchIntentForPackage("com.google.firebase.codelab.friendlychat");
        if (JPCEssentials_chat != null) {
            // We found the activity now start the activity
            JPCEssentials_chat.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(JPCEssentials_chat);
        } else {
            Toast toast =Toast.makeText(this,"Downloading Chat Applicatoin",Toast.LENGTH_LONG);
            toast.show();
            // Bring user to the market or let them choose an app?
            JPCEssentials_chat = new Intent(Intent.ACTION_VIEW);
            JPCEssentials_chat.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            JPCEssentials_chat.setData(Uri.parse("http://formulator.ca/jpci_app/chat.apk"));
            startActivity(JPCEssentials_chat);
        }
    }
}