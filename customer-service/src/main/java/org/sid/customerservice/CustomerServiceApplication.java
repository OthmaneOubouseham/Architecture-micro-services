package org.sid.customerservice;

import org.sid.customerservice.config.CustomerConfigParams;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
@EnableConfigurationProperties(CustomerConfigParams.class)
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {

        return args -> {
			customerRepository.save(Customer.builder().name("Othmane").email("othmane@gmail.com").build());
			customerRepository.save(Customer.builder().name("Ludivine").email("Ludivine@gmail.com").build());
			customerRepository.save((Customer.builder().name("Othlu").email("Othlu@gmail.com").build()));

			customerRepository.findAll().forEach(c->{
				System.out.println(c.getName());
				System.out.println(c.getEmail());
			});
		};
    };
}
