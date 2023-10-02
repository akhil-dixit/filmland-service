package ad.sogeti.filmlandservice.service.impl.subscription;

import ad.sogeti.filmlandservice.model.categories.Subscribed_Categories;
import ad.sogeti.filmlandservice.model.subscription.NewSubscriptionRequest;
import ad.sogeti.filmlandservice.model.subscription.ShareSubCategoryRequest;
import ad.sogeti.filmlandservice.repository.categories.AvailableCategoriesRepository;
import ad.sogeti.filmlandservice.repository.categories.SubscribedCategoriesRepository;
import ad.sogeti.filmlandservice.repository.user.UserRepository;
import ad.sogeti.filmlandservice.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionServiceImpl.class);
    private final SubscribedCategoriesRepository subscribedCategoriesRepository;
    private final AvailableCategoriesRepository availableCategoriesRepository;
    private final UserRepository userRepository;

    public SubscriptionServiceImpl(SubscribedCategoriesRepository subscribedCategoriesRepository, AvailableCategoriesRepository availableCategoriesRepository, UserRepository userRepository) {
        this.subscribedCategoriesRepository = subscribedCategoriesRepository;
        this.availableCategoriesRepository = availableCategoriesRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> subscribeCategory (@RequestBody NewSubscriptionRequest newSubscriptionRequest)
            throws Exception {
        ResponseEntity responseEntity = null;
        try{
            List<Subscribed_Categories> subscribedCategories =
                    subscribedCategoriesRepository.findByEmail(newSubscriptionRequest.getEmail());
            for (Subscribed_Categories category : subscribedCategories) {
                if (category.getName().equalsIgnoreCase(newSubscriptionRequest.getAvailableCategory())) {
                    logger.info("User is already subscribed to " + newSubscriptionRequest.getAvailableCategory());
                    responseEntity = new ResponseEntity<>("User is already subscribed to " + newSubscriptionRequest.getAvailableCategory(), HttpStatus.BAD_REQUEST);
                    break;
                }
            }
            if (null == responseEntity) {
                Subscribed_Categories newSubscription = new Subscribed_Categories(
                        5, newSubscriptionRequest.getEmail(), newSubscriptionRequest.getAvailableCategory(),
                        5, 8.0, Date.valueOf(LocalDate.now()));
                subscribedCategoriesRepository.save(newSubscription);
                availableCategoriesRepository.deleteSubscribedCategory(newSubscriptionRequest.getEmail(), newSubscriptionRequest.getAvailableCategory());
                responseEntity = new ResponseEntity<>("User successfully subscribed to " + newSubscriptionRequest.getAvailableCategory(), HttpStatus.CREATED);
                logger.info("User successfully subscribed to " + newSubscriptionRequest.getAvailableCategory());
            }
        } catch (Exception e) {
            logger.error("Error occurred while subscribing to category: " + newSubscriptionRequest.getAvailableCategory());
            throw new Exception(e.getMessage());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> shareSubscribedCategory (@RequestBody ShareSubCategoryRequest shareSubCategoryRequest)
            throws Exception {
        ResponseEntity responseEntity = null;
        try {
            if (null == userRepository.findByEmail(shareSubCategoryRequest.getCustomer())) {
                responseEntity = new ResponseEntity<>("Customer not registered/found!",HttpStatus.NOT_FOUND);
                logger.info("Customer: " + shareSubCategoryRequest.getCustomer() + " not registered or found");
            } else {
                Subscribed_Categories subCategory = subscribedCategoriesRepository.
                        findSubscribedCategoryByEmailAndName(shareSubCategoryRequest.getEmail(), shareSubCategoryRequest.getSubscribedCategory());
                if (null == subCategory) {
                    responseEntity = new ResponseEntity<>("User is not subscribed to: " + shareSubCategoryRequest.getSubscribedCategory(), HttpStatus.NOT_FOUND);
                    logger.info("User does not have subscription to: " + shareSubCategoryRequest.getSubscribedCategory());
                }
                else {
                    subscribedCategoriesRepository.save(new Subscribed_Categories(5,shareSubCategoryRequest.getCustomer(), subCategory.getName(),
                            subCategory.getRemaining_Content(), subCategory.getPrice(), subCategory.getStart_Date()));
                    availableCategoriesRepository.deleteSubscribedCategory(shareSubCategoryRequest.getCustomer(), shareSubCategoryRequest.getSubscribedCategory());
                    responseEntity = new ResponseEntity<>("Subscriber has successfully shared "
                            + shareSubCategoryRequest.getSubscribedCategory() + " with " + shareSubCategoryRequest.getCustomer(), HttpStatus.CREATED);
                    logger.info("Subscriber has successfully shared "
                            + shareSubCategoryRequest.getSubscribedCategory() + " with " + shareSubCategoryRequest.getCustomer());
                }
            }
        }catch (Exception e) {
            logger.error("Error occurred while sharing category with friend");
            throw new Exception(e.getMessage());
        }
        return responseEntity;
    }
}
