package de.limago.jpademo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbltiere")
@Inheritance(strategy = InheritanceType.JOINED)
//@TableGenerator(name="tab", initialValue=0, allocationSize=50)
public abstract class Tier {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE, generator="tab")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
}
