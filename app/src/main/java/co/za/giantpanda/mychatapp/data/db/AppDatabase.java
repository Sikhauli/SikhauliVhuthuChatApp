package co.za.giantpanda.mychatapp.data.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import co.za.giantpanda.mychatapp.data.db.entity.Chat;

@Database(entities = { Chat.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

  public abstract ChatDao chatDao();

  private static AppDatabase INSTANCE;

  public static AppDatabase getDatabaseInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "MyChatApp")
          .allowMainThreadQueries()
          .build();
    }
    return INSTANCE;
  }
}
