package code.elif.app.ws.mobileappws.data;

import code.elif.app.ws.mobileappws.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    UserEntity findByUserId(String userId);

    UserEntity findByEmail(String email);
}
