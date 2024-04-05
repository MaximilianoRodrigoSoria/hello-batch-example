//package ar.com.laboratory.hellobatchexample.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.http.ResponseEntity;
//
//@Tag(name = "Batch", description = "Operations jobs")
//public interface JobController {
//
//
//    @Operation(summary = "Execution Job", description = "Execution Job")
//    public ResponseEntity<String> runJub() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException;
//}
