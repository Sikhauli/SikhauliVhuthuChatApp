package co.za.giantpanda.mychatapp.data.repo;

import android.content.Context;
import androidx.lifecycle.LiveData;
import co.za.giantpanda.mychatapp.data.db.AppDatabase;
import co.za.giantpanda.mychatapp.data.db.ChatDao;
import co.za.giantpanda.mychatapp.data.db.entity.Chat;
import java.util.List;

public class ChatsRepository {

  private final ChatDao chatDao;

  public ChatsRepository(Context context) {
    chatDao = AppDatabase.getDatabaseInstance(context).chatDao();
  }

  public void sendMessage(Chat chat) {
    chatDao.insertChat(chat);
  }

  public LiveData<List<Chat>> fetchChats() {
    return chatDao.fetchChats();
  }
}
