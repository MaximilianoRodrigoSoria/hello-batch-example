package ar.com.laboratory.hellobatchexample.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class HelloJobExecutionListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Antes de ejecutar el job, " + jobExecution.getJobInstance().getJobName());
        System.out.println("Antes de ejecutar el job, " + jobExecution.getExecutionContext().toString());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Despues de ejecutar el job");
    }
}
