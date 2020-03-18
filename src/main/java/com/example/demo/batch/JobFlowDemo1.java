package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author hongtao.hao
 * @date 2019/7/3
 */
//@Configuration
//@EnableBatchProcessing
public class JobFlowDemo1 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job JobFlowDemo1() {
        /**
         *  TODO on("COMPLETED") 代表step1成功才去执行step2
         *       next 是直接执行
         *      stopAndRestart() 停止重新启动
         */
        return jobBuilderFactory.get("jobFlowDemo11")
            // .start(step1())
            // .next(step2())
            // .next(step3())
            // .build();
            .start(step1()).on("COMPLETED").to(step2()).from(step2()).on("COMPLETED").to(step3())// fail,stopAndRestart()
            .from(step3()).end().build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step11").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("==================================step11");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step12").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("==================================step12");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step13").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("==================================step13");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

}