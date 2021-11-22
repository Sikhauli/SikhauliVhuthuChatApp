package co.za.giantpanda.mychatapp.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import co.za.giantpanda.mychatapp.R;
import co.za.giantpanda.mychatapp.util.SharedPrefsUtil;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    boolean isFirstTimeUser = SharedPrefsUtil.getBoolean(this, SharedPrefsUtil.IS_FIRST_TIME_USER, true);

    if (isFirstTimeUser) {
      addFragment(new SetUsernameFragment());
    } else {
      addFragment(new ChatsFragment());
    }
  }

  public void addFragment(Fragment fragment) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.fragmentContainer, fragment)
        .addToBackStack(fragmentTransaction.getClass().getName())
        .commit();
  }

  public void replaceFragment(Fragment fragment) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.fragmentContainer, fragment)
        .addToBackStack(fragmentTransaction.getClass().getName())
        .commit();
  }
}
