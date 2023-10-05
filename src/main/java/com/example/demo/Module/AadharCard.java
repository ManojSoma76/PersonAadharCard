package com.example.demo.Module;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class AadharCard {
	
	@Id
	@Size(min = 12,max = 12,message = "aadharNumber should be 12-digit")
	@NotNull
	private String adharNumber;
	
	@OneToOne(mappedBy = "aadharCard")
	private Person person;

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

}
