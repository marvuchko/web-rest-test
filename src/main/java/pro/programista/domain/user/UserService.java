package pro.programista.domain.user;

import java.util.UUID;
import pro.programista.domain.Service;

public class UserService extends Service<User, UUID> {

  public UserService(UserRepository repository) {
    super(repository);
  }

}