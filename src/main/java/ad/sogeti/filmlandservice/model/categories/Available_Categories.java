package ad.sogeti.filmlandservice.model.categories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Available_Categories {

    @JsonIgnore
    @Id
    private int id;
    @JsonIgnore
    private String email;
    private String name;
    private int available_Content;
    private Double price;
}
