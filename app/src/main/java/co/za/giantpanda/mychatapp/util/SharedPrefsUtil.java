package co.za.giantpanda.mychatapp.util;

import android.content.Context;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefsUtil {

  public final static String USERNAME = "username";
  public final static String IS_FIRST_TIME_USER = "isFirstTimeUser";

  private static final String PREFS_NAME = "MyChatApp";

  public static void setString(Context context, String key, String value) {
    context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        .edit()
        .putString(key, value)
        .apply();
  }

  public static void setBoolean(Context context, String key, boolean value) {
    context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        .edit()
        .putBoolean(key, value)
        .apply();
  }

  public static void setInt(Context context, String key, int value) {
    context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        .edit()
        .putInt(key, value)
        .apply();
  }

  public static String getString(Context context, String key) {
    return context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        .getString(key, "");
  }

  public static boolean getBoolean(Context context, String key, boolean defaultValue) {
    return context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        .getBoolean(key, defaultValue);
  }

  public static int getInt(Context context, String key) {
    return context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        .getInt(key, 0);
  }
}