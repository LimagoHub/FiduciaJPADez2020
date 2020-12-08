package de.gad.batchdemo.writers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.MeineDaten;


@Component

public class MeineDatenWriter extends JdbcBatchItemWriter<MeineDaten> {
	
	
	private final DataSource dataSource;
	
	
	
	
	public MeineDatenWriter(final DataSource dataSource) {
		this.dataSource = dataSource;
	     setItemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<MeineDaten>() );
	     setSql( "Insert into Meinedaten ( Vorname, Nachname, Buchstabenanzahl ) Values ( :vorname, :nachname, :buchstabenanzahl )" );
	     setDataSource( dataSource );
	     
	}
	
}
