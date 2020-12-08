package de.gad.batchdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeineDaten {
	private String vorname;
	private String nachname;
	private Long   buchstabenanzahl;
}
