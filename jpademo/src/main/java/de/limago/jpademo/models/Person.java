package de.limago.jpademo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tblpersonen")
public class Person extends BaseEntity{
	
	
	@Column(length = 30)
	private String vorname;
	@Column(length = 30, nullable = true)
	private String nachname;
	@Embedded
	@Builder.Default
	private Adresse adresse = new Adresse();
	
	@Builder.Default
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "tblpersonenKontakte")
	private List<Kontakt> kontakte = new ArrayList<>();

}
