package ad.sogeti.filmlandservice.service;

import ad.sogeti.filmlandservice.model.customer.CustomerDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerService {

    ResponseEntity<CustomerDetails> getCustomerDetails(@RequestParam String email) throws Exception;
}
