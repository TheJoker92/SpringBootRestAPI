package com.example.tutorial;

import com.example.tutorial.data.Customer;
import com.example.tutorial.data.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.tutorial.data","com.example.tutorial.controller"})

public class IntegrateSpringAngular6 implements CommandLineRunner {


	@Autowired
	CustomerRepository repository;

    public void repoInit(){
            repository.deleteAll();

            // save a couple of customers
            repository.save(new Customer("Alice", "Smith", "Ford Fiesta"));
            repository.save(new Customer("Bob", "Smith", "Ford Focus"));
            repository.save(new Customer("Andrea", "Cavallo", "Fiat Bravo"));
            repository.save(new Customer("Alessandro", "De Micco", "Ferrari F40"));
            repository.save(new Customer("Francesca", "Ginseng", "Panda"));
            repository.save(new Customer("Veronica", "Zanti", "Smart"));


    }

	public static void main(String[] args) {
		SpringApplication.run(IntegrateSpringAngular6.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        repoInit();

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

}
