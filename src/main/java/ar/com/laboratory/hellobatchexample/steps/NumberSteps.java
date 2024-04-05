package ar.com.laboratory.hellobatchexample.steps;


import ar.com.laboratory.hellobatchexample.processor.InMemoryProcessor;
import ar.com.laboratory.hellobatchexample.readers.InMemoryReader;
import ar.com.laboratory.hellobatchexample.writers.InMemoryWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NumberSteps {

    private StepBuilderFactory steps;

    private InMemoryProcessor inMemeItemProcessor;

    private InMemoryReader reader;

    private InMemoryWriter inMemeItemWriter;

    @Bean
    public Step readNumberStep(){
        return steps.get("readNumberStep").
                        <Integer,Integer>chunk(2)
                .reader(reader)
                .processor(inMemeItemProcessor)
                .writer(inMemeItemWriter)
                .build();
    }
}
