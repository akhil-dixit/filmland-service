package ad.sogeti.filmlandservice.controller.customer;

import ad.sogeti.filmlandservice.model.customer.CustomerDetails;
import ad.sogeti.filmlandservice.service.CustomerService;
import ad.sogeti.filmlandservice.utils.FilmLandConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Customer service")
@RestController
@RequestMapping(FilmLandConstants.CUSTOMER_BASE_URL)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Get customer details",
            description = "Fetch the available and subscribed categories for a user"
    )
    public ResponseEntity<CustomerDetails> getCustomerDetails(@RequestParam String email) throws Exception {
        return customerService.getCustomerDetails(email);
    }
}
