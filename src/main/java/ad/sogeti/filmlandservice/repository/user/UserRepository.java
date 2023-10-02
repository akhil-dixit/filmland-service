package ad.sogeti.filmlandservice.repository.user;

import ad.sogeti.filmlandservice.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    User findByEmail(String email);
}
