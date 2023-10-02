package ad.sogeti.filmlandservice.model.subscription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewSubscriptionRequest {

    private String email;
    private String availableCategory;
}
