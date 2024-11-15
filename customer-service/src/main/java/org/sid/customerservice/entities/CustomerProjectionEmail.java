package org.sid.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Customer.class)
public interface CustomerProjectionEmail {
    String getName();
    String getEmail();
}
