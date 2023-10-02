package ad.sogeti.filmlandservice.service.impl.customer;

import ad.sogeti.filmlandservice.model.categories.Available_Categories;
import ad.sogeti.filmlandservice.model.categories.Subscribed_Categories;
import ad.sogeti.filmlandservice.model.customer.CustomerDetails;
import ad.sogeti.filmlandservice.repository.categories.AvailableCategoriesRepository;
import ad.sogeti.filmlandservice.repository.categories.SubscribedCategoriesRepository;
import ad.sogeti.filmlandservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final AvailableCategoriesRepository availableCategoriesRepository;
    private final SubscribedCategoriesRepository subscribedCategoriesRepository;

    public CustomerServiceImpl(AvailableCategoriesRepository availableCategoriesRepository, SubscribedCategoriesRepository subscribedCategoriesRepository) {
        this.availableCategoriesRepository = availableCategoriesRepository;
        this.subscribedCategoriesRepository = subscribedCategoriesRepository;
    }

    @Override
    public ResponseEntity<CustomerDetails> getCustomerDetails(@RequestParam String email) throws Exception {
        ResponseEntity responseEntity = null;
        try{
            List<Available_Categories> availableCategories = availableCategoriesRepository.findByEmail(email);
            List<Subscribed_Categories> subscribedCategories = subscribedCategoriesRepository.findByEmail(email);
            responseEntity = new ResponseEntity<>(
                    new CustomerDetails(availableCategories, subscribedCategories), HttpStatus.OK
            );
            logger.info("Getting details for user: " + email);
        } catch (Exception e) {
            logger.error("Error occurred while fetching customer details in CustomerServiceImpl: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        return responseEntity;
    }
}
