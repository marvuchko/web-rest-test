package pro.programista.infrastructure.repository.nosql.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import pro.programista.domain.user.User;
import pro.programista.domain.user.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserRepository {

    private final UserMongoRepository userMongoRepository;

    public UserDao(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User createOrUpdate(User data) {
        return(userMongoRepository.save(data));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userMongoRepository.findById(id);
    }

    @Override
    public List<User> getPage(int page, int size) {
        return userMongoRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void delete(UUID id) {
        userMongoRepository.deleteById(id);
    }

}