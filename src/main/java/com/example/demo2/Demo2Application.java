package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {

//		ConfigurableApplicationContext context =
				SpringApplication.run(Demo2Application.class, args);

//		CityRepository repository = context.getBean(CityRepository.class);


		//CRUD

		//Read
//		List<City> cities = repository.findAll();
//		System.out.println(cities);
//		System.out.println(repository.findAll());

		//Read by ID
//		System.out.println(repository.findById(2));

		//Create
//		repository.save(new City("Moscow"));

		//Update
//		System.out.println(repository.findAll());
//		repository.save(new City(1, "Saint Petersburg"));
//		System.out.println(repository.findAll());

		//Delete
//		System.out.println(repository.findAll());
//		repository.deleteById(9);
//		System.out.println(repository.findAll());



		//Код для работы с людьми из базы данных
//		PersonRepository repository = context.getBean(PersonRepository.class);
//		System.out.println(repository.findAll());

	}

}
