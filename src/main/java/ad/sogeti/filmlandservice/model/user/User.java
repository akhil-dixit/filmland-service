package ad.sogeti.filmlandservice.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {

    private int id;
    @Id
    private String email;
    private String password;
    private String username;
}
