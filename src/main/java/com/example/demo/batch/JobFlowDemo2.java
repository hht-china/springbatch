package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
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
public class JobFlowDemo2 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step jobFlowStep1() {
        return stepBuilderFactory.get("jobFlowStep21").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("jobFlowStep21");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step jobFlowStep2() {
        return stepBuilderFactory.get("jobFlowStep22").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("jobFlowStep22");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step jobFlowStep3() {
        return stepBuilderFactory.get("jobFlowStep23").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
                System.out.println("jobFlowStep23");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    //TODO 创建 Flow:Flow是step的集合  步骤相同的被多次引用，可以使用flow，实现复用
    @Bean
    public Flow jobFlowDemo2Flow() {
        return new FlowBuilder<Flow>("jobFlowDemo22Flow")
                .start(jobFlowStep1())
                .next(jobFlowStep2())
                .build();
    }

    // 创建Job
    @Bean
    public Job jobFlowDemo2Job() {
        return jobBuilderFactory.get("jobFlowDemo22Job")
                .start(jobFlowDemo2Flow())
                //TODO 继续使用step
                .next(jobFlowStep3())
                .end()
                .build();
    }

}
