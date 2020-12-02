package de.limago.jpademo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Adresse {
	@Column(length = 5)
	private String plz;
	@Column(length = 30)
	private String ort;
	@Column(length = 30)
	private String strasse;

}
