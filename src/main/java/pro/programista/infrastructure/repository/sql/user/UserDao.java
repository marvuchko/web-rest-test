package pro.programista.infrastructure.repository.sql.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import pro.programista.domain.user.User;
import pro.programista.domain.user.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  public UserDao(UserJpaRepository userJpaRepository) {
    this.userJpaRepository = userJpaRepository;
  }

  @Override
  public User createOrUpdate(User data) {
    return toDomain(userJpaRepository.save(toJpaEntity(data)));
  }

  @Override
  public Optional<User> findById(UUID id) {
    return userJpaRepository.findById(id).map(UserDao::toDomain);
  }

  @Override
  public List<User> getPage(int page, int size) {
    return userJpaRepository.findAll(PageRequest.of(page, size))
        .map(UserDao::toDomain).getContent();
  }

  @Override
  public void delete(UUID id) {
    userJpaRepository.deleteById(id);
  }

  private static User toDomain(UserJpaEntity jpaEntity) {
    var user = new User();
    user.setId(jpaEntity.getId());
    user.setEmail(jpaEntity.getEmail());
    user.setFirstName(jpaEntity.getFirstName());
    user.setLastName(jpaEntity.getLastName());
    user.setPassword(jpaEntity.getPassword());
    return user;
  }

  private static UserJpaEntity toJpaEntity(User user) {
    var entity = new UserJpaEntity();
    entity.setId(user.getId());
    entity.setEmail(user.getEmail());
    entity.setFirstName(user.getFirstName());
    entity.setLastName(user.getLastName());
    entity.setPassword(user.getPassword());
    return entity;
  }

}