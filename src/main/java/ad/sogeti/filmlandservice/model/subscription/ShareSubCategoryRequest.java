package ad.sogeti.filmlandservice.model.subscription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareSubCategoryRequest {

    private String email;
    private String customer;
    private String subscribedCategory;
}
