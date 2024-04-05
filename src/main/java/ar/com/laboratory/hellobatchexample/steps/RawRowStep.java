package ar.com.laboratory.hellobatchexample.steps;


import ar.com.laboratory.hellobatchexample.models.entities.RawRow;
import ar.com.laboratory.hellobatchexample.processor.InMemoryProcessor;
import ar.com.laboratory.hellobatchexample.readers.InMemoryReader;
import ar.com.laboratory.hellobatchexample.readers.RawRowsReader;
import ar.com.laboratory.hellobatchexample.writers.InMemoryWriter;
import ar.com.laboratory.hellobatchexample.writers.RawRowWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RawRowStep {

    private StepBuilderFactory steps;


    private RawRowsReader rawRowsReader;

    private RawRowWriter rawRowWriter;

    @Bean
    public Step readRowStep(){
        return steps.get("readRowStep").
                        <RawRow,RawRow>chunk(2)
                .reader(rawRowsReader.reader())
                .writer(rawRowWriter)
                .build();
    }
}
