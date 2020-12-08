package de.gad.batchdemo.readers;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.MeineDaten;

@Component

public class MyFlatFileReader extends FlatFileItemReader<MeineDaten> {

	public MyFlatFileReader() {
		setResource(new ClassPathResource("BeispielDaten1.csv"));
		setLineMapper(new DefaultLineMapper<MeineDaten>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "Vorname", "Nachname" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<MeineDaten>() {
					{
						setTargetType(MeineDaten.class);
					}
				});
			}
		});
	}

}
