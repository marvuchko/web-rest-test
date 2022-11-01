package pro.programista.infrastructure.context.user;

import pro.programista.domain.user.UserRepository;
import pro.programista.domain.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBoundContext {

  @Bean
  public UserService userService(UserRepository userRepository) {
    return new UserService(userRepository);
  }

}