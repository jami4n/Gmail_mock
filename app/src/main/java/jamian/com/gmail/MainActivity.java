package jamian.com.gmail;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import jamian.com.gmail.view.Navigation_Fragment;

public class MainActivity extends AppCompatActivity implements Navigation_Fragment.FragmentDrawerListener {

    private static final String TAG = "MainActivity";
    Toolbar toolbar;
    private Navigation_Fragment drawerFragment;

    TextView tv_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (Navigation_Fragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_view);
        drawerFragment.setUp(R.id.nav_view, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

    }

    @Override
    public void onDrawerItemSelected(View view, int position, String link) {

    }
}
