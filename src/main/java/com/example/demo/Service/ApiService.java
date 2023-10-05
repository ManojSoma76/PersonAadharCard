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
		Person p=personRepo.findById(id).orElse(null);
		p.setName(updatPerson.getName());
		p.setAge(updatPerson.getAge());
		p.setEmail(updatPerson.getEmail());
		p.setPhno(updatPerson.getPhno());
		p.setAadharCard(updatPerson.getAadharCard());
		personRepo.save(p);
		return p;
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
