package co.za.giantpanda.mychatapp.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import co.za.giantpanda.mychatapp.ui.ChatStatus;

@Entity(tableName = "chats")
public class Chat {
  @PrimaryKey(autoGenerate = true)
  public int id;
  public String userName;
  public String message;
  public int status = ChatStatus.NOT_SENT;
}
