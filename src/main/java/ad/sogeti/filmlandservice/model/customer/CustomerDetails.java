package ad.sogeti.filmlandservice.model.customer;

import ad.sogeti.filmlandservice.model.categories.Available_Categories;
import ad.sogeti.filmlandservice.model.categories.Subscribed_Categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDetails {

    List<Available_Categories> availableCategories;
    List<Subscribed_Categories> subscribedCategories;




}
