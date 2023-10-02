package ad.sogeti.filmlandservice.service;

import ad.sogeti.filmlandservice.model.categories.Subscribed_Categories;
import ad.sogeti.filmlandservice.model.subscription.NewSubscriptionRequest;
import ad.sogeti.filmlandservice.model.subscription.ShareSubCategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface SubscriptionService {

    ResponseEntity<String> subscribeCategory (@RequestBody NewSubscriptionRequest newSubscriptionRequest)
            throws Exception;

    ResponseEntity<String> shareSubscribedCategory (@RequestBody ShareSubCategoryRequest shareSubCategoryRequest)
            throws Exception;
}
