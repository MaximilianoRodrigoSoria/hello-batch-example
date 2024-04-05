package ar.com.laboratory.hellobatchexample.configurations;


import ar.com.laboratory.hellobatchexample.listeners.HelloJobExecutionListener;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class BatchConfiguration {

    private JobBuilderFactory jobs;
    private HelloJobExecutionListener helloJobExecutionListener;
    private Step readRowStep;

    @Bean
    public Job initialJob(){
        return jobs.get("processTransactionJob")
                .incrementer(new RunIdIncrementer())
                .listener(helloJobExecutionListener)
                .start(readRowStep)
                .build();
    }



}
