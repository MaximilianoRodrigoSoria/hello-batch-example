package ar.com.laboratory.hellobatchexample.configurations;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Slf4j
@Component
public class BatchConfiguration {

    private JobBuilderFactory jobs;

    private StepBuilderFactory steps;

    @Bean
    public Step step1(){
        return steps.get("step")
                .<String, String>chunk(1)
                .reader(new ListItemReader<>(Arrays.asList("Maximiliano", "Rodrigo", "Soria")))
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    @Bean
    public Step step2(){
        return steps.get("step2")
                .tasklet(helloWorldTasklet())
                .build();
    }

    private Tasklet helloWorldTasklet() {
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Hello, World!");
                return RepeatStatus.FINISHED;
            }
        });
    }

    @Bean
    public Job helloWordJob(){
        return jobs.get("helloWorldJob")
                .start(step1())
                .next(step2())
                .build();
    }
}
