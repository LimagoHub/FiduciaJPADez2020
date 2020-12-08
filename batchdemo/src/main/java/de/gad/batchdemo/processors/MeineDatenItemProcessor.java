package de.gad.batchdemo.processors;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.MeineDaten;

@Component

public class MeineDatenItemProcessor implements ItemProcessor<MeineDaten,MeineDaten>
{
   @Override
   public MeineDaten process( MeineDaten md ) throws Exception
   {
      long n = 0;
      if( md.getVorname()  != null ) { n += md.getVorname().length();  }
      if( md.getNachname() != null ) { n += md.getNachname().length(); }
      return new MeineDaten( md.getVorname(), md.getNachname(), Long.valueOf( n ) );
   }
}