package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongtao.hao
 * @date 2019/7/3
 */
//@Configuration
//@EnableBatchProcessing
public class JobDemo0 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob").start(step1()).build();
    }

    // 需要是public的
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step0").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("Hello World!0");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

}