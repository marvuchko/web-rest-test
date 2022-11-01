package pro.programista.infrastructure.repository.nosql.user;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import pro.programista.domain.user.User;

public interface UserMongoRepository extends MongoRepository<User, UUID> {
}