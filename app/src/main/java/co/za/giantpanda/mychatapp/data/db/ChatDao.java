package co.za.giantpanda.mychatapp.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import co.za.giantpanda.mychatapp.data.db.entity.Chat;
import java.util.List;

@Dao
public interface ChatDao {

  @Query("SELECT * FROM chats")
  LiveData<List<Chat>> fetchChats();

  @Insert
  void insertChat(Chat chat);

}
