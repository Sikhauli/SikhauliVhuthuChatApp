package co.za.giantpanda.mychatapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.za.giantpanda.mychatapp.R;
import co.za.giantpanda.mychatapp.data.db.entity.Chat;
import co.za.giantpanda.mychatapp.ui.MainActivity;
import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

  private final List<Chat> chatList = new ArrayList<>();

  public static class MessageViewHolder extends RecyclerView.ViewHolder {

    public TextView messageTextView;
    public TextView userNameTextView;


    public MessageViewHolder(@NonNull View itemView) {
      super(itemView);
      userNameTextView = itemView.findViewById(R.id.userNameTextView);
      messageTextView = itemView.findViewById(R.id.messageTextView);
    }
  }

  public void addItems(List<Chat> chats) {
    chatList.clear();
    chatList.addAll(chats);
    notifyDataSetChanged();
  }

  public void addItem(Chat chat) {
    chatList.add(chat);
    notifyItemChanged(chatList.size() - 1);
  }

  @NonNull
  @Override
  public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
    return new MessageViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
    Chat currentItem = chatList.get(position);

    holder.userNameTextView.setText(currentItem.userName);
    holder.messageTextView.setText(currentItem.message);
  }

  @Override
  public int getItemCount() {
    return chatList.size();
  }
}