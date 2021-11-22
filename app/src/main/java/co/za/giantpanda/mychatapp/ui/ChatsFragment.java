package co.za.giantpanda.mychatapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import co.za.giantpanda.mychatapp.R;
import co.za.giantpanda.mychatapp.adapter.MessageAdapter;
import co.za.giantpanda.mychatapp.data.db.entity.Chat;
import co.za.giantpanda.mychatapp.data.repo.ChatsRepository;
import co.za.giantpanda.mychatapp.util.SharedPrefsUtil;
import java.util.List;

import static co.za.giantpanda.mychatapp.util.SharedPrefsUtil.USERNAME;

public class ChatsFragment extends Fragment {

  private ChatsViewModel chatsViewModel;
  private MessageAdapter messageAdapter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ChatsRepository chatsRepository = new ChatsRepository(requireContext());
    chatsViewModel = new ChatsViewModelFactory(chatsRepository).create(ChatsViewModel.class);
    messageAdapter  = new MessageAdapter();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_chats, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    RecyclerView chatsRecyclerView = view.findViewById(R.id.chatsRecyclerView);
    TextView sendButton = view.findViewById(R.id.sendButton);
    EditText messageEditText = view.findViewById(R.id.messageEditText);

    chatsRecyclerView.setAdapter(messageAdapter);

    sendButton.setOnClickListener(v -> {
      Chat chat = new Chat();
      chat.message = (messageEditText.getText().toString());
      chat.userName = SharedPrefsUtil.getString(requireContext(), USERNAME);
      chatsViewModel.sendMessage(chat);
      messageEditText.setText("");
    });

    chatsViewModel.fetchChats();
    chatsViewModel.messageLiveData.observe(getViewLifecycleOwner(), chats -> {
      messageAdapter.addItems(chats);
    });
  }
}