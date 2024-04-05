package ar.com.laboratory.hellobatchexample.steps;


import ar.com.laboratory.hellobatchexample.tasklests.HelloTasklet;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class HelloStep {

    private StepBuilderFactory steps;
    @Bean
    public Step helloWorldStep(){
        return steps.get("helloWorldStep")
                .tasklet(new HelloTasklet())
                .build();
    }
}
