package co.za.giantpanda.mychatapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import co.za.giantpanda.mychatapp.R;
import co.za.giantpanda.mychatapp.util.SharedPrefsUtil;
import org.jetbrains.annotations.NotNull;

public class SetUsernameFragment extends Fragment {

  MainActivity mainActivity = null;

  public SetUsernameFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mainActivity = (MainActivity) requireActivity();
    ActionBar actionBar = mainActivity.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(R.string.set_username);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_set_username, container, false);
  }

  public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Button saveButton = view.findViewById(R.id.saveButton);
    EditText userNameEditText = view.findViewById(R.id.userNameEditText);

    saveButton.setOnClickListener(view1 -> {
      String username = userNameEditText.getText().toString();

      if (username.length() > 0) {
        SharedPrefsUtil.setString(requireContext(), SharedPrefsUtil.USERNAME, username);
        SharedPrefsUtil.setBoolean(requireContext(), SharedPrefsUtil.IS_FIRST_TIME_USER, false);

        mainActivity.replaceFragment(new ChatsFragment());
      } else {
        userNameEditText.setError(getString(R.string.error_username));
      }
    });
  }
}