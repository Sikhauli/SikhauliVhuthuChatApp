package co.za.giantpanda.mychatapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Prefs {

  public final SharedPreferences sharedPreferences;

  public Prefs(Context context) {
    sharedPreferences = context.getSharedPreferences("MyChatApp", MODE_PRIVATE);
  }
}