package co.za.giantpanda.mychatapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import co.za.giantpanda.mychatapp.data.db.entity.Chat;
import co.za.giantpanda.mychatapp.data.repo.ChatsRepository;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatsViewModel extends ViewModel {

  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  private final ChatsRepository chatsRepository;
  public LiveData<List<Chat>> messageLiveData;

  public ChatsViewModel(ChatsRepository repo) {
    chatsRepository = repo;
  }

  public void sendMessage(Chat chat) {
    executor.execute(() -> chatsRepository.sendMessage(chat));
  }

  public void fetchChats() {
      messageLiveData = chatsRepository.fetchChats();
  }
}
