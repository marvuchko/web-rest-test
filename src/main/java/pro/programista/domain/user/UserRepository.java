package pro.programista.domain.user;

import java.util.UUID;
import pro.programista.domain.Repository;

public interface UserRepository extends Repository<User, UUID> {
}