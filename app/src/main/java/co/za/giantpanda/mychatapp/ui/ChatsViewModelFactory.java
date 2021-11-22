package co.za.giantpanda.mychatapp.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import co.za.giantpanda.mychatapp.data.repo.ChatsRepository;

public class ChatsViewModelFactory implements ViewModelProvider.Factory {

  private final ChatsRepository chatsRepository;

  public ChatsViewModelFactory(ChatsRepository repo) {
    chatsRepository = repo;
  }

  @NonNull
  @Override
  public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
    if (aClass.isAssignableFrom(ChatsViewModel.class)) {
      return (T) new ChatsViewModel(chatsRepository);
    }
    throw new IllegalArgumentException("Unknown ViewModel class");
  }
}
