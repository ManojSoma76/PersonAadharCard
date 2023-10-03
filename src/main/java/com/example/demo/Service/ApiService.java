package com.example.demo.Service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Module.Person;
import com.example.demo.Repo.PersonRepo;

@Service
public class ApiService {
	
	@Autowired
	private PersonRepo personRepo; 
	
	public Person savePersonWithAadhar(Person person) {
		return personRepo.save(person);
	}
	public Optional<Person> getPersonByAadharNumber(String adharNumber) {
		return personRepo.findByAadharCard_AdharNumber(adharNumber);
	}
	public Person updatePerson(Long id,Person updatPerson){
		Optional<Person> presentPerson
		=getPersonByAadharNumber(updatPerson.getAadharCard().getAdharNumber());
		if(presentPerson.isPresent()) {
			updatPerson.setId(id);
			Person savedPerson=savePersonWithAadhar(updatPerson);
			return savedPerson;
		}
		else {
			return null;
		}
	}
	public Person deletePerson(Long id) {
		Person person=personRepo.findById(id).orElse(null);
		if(person!=null) {
			personRepo.delete(person);
			return person;
		}else {
			return null;
		}
	}
}
