package org.sid.billingservice.feign;

import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable long id);
    @GetMapping("/customers")
    PagedModel<Customer> findAllCustomers();
}
