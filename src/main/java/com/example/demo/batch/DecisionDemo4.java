package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
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
public class DecisionDemo4 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("=====================================step1");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("=====================================step2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("step2");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("=====================================step3");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    //TODO 创建决策器
    @Bean
    public JobExecutionDecider myDecider() {
        return new MyDecider();
    }

    // 创建Job
    @Bean
    public Job DecisionDemoJob() {
        return jobBuilderFactory.get("DecisionDemoJob")
                .start(step1())
                //next一个决策器
                .next(myDecider())
                //TODO 通过返回值决定走哪一个step
                .from(myDecider()).on("even").to(step3())
                .from(myDecider()).on("odd").to(step2())
                //TODO 无论返回什么，返回到决策器，可以不要
                .from(step2()).on("*").to(myDecider())
                .end().build();
    }
}
