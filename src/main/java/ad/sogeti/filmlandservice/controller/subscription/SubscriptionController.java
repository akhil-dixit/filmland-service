package ad.sogeti.filmlandservice.controller.subscription;

import ad.sogeti.filmlandservice.model.categories.Subscribed_Categories;
import ad.sogeti.filmlandservice.model.subscription.NewSubscriptionRequest;
import ad.sogeti.filmlandservice.model.subscription.ShareSubCategoryRequest;
import ad.sogeti.filmlandservice.service.SubscriptionService;
import ad.sogeti.filmlandservice.utils.FilmLandConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Subscription service")
@RestController
@RequestMapping(FilmLandConstants.SUBSCRIPTION_BASE_URL)
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(value = FilmLandConstants.SUBSCRIBE_ENDPOINT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    @Operation(
            summary = "Subscribe new category",
            description = "Check and subscribe new category for the customer"
    )
    public ResponseEntity<String> subscribeCategory (@RequestBody NewSubscriptionRequest newSubscriptionRequest)
        throws Exception {
        return subscriptionService.subscribeCategory(newSubscriptionRequest);
    }

    @PostMapping(value = FilmLandConstants.SHARE_SUBSCRIBE_ENDPOINT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    @Operation(
            summary = "Share subscription",
            description = "Subscriber can share a category with existing customer"
    )
    public ResponseEntity<String> shareSubscribedCategory (@RequestBody ShareSubCategoryRequest shareSubCategoryRequest)
            throws Exception {
        return subscriptionService.shareSubscribedCategory(shareSubCategoryRequest);
    }
}
