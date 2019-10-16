package com.rd.demo;

import com.rd.demo.model.Person;
import com.rd.demo.repositories.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonbHibernateDemoApplicationTests {

	@Autowired
	private PersonRepository repository;

	@Test
	public void createPerson() {
		//repository.deleteAll();

		Person person = new Person();
		person.setFirstName("meraj");
		person.setLastName("ahmad");

		Map<String, String> additionalData = new HashMap<>();
		additionalData.put("workex", "10");
		additionalData.put("city", "rampur");
		additionalData.put("Tech stack", "java");
		person.setAdditionalData(additionalData);

		repository.save(person);
	}

	@Test
	public void findPerson() {
		Person person = repository.findOne(Integer.toUnsignedLong(3));
		Assert.assertEquals("ritesh", person.getFirstName());
	}

	@Test

	public void getAdditionalDetails(){
		Person person = repository.findOne(Integer.toUnsignedLong(6));
		Assert.assertEquals("rampur", person.getAdditionalData().get("city"));
	}
}
