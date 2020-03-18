package com.example.demo.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author hongtao.hao
 * @date 2019/7/3
 */
public class MyDecider implements JobExecutionDecider {

    private int count;

    @Override
    public FlowExecutionStatus decide(JobExecution arg0, StepExecution arg1) {
        count++;
        if (count % 2 == 0)
            return new FlowExecutionStatus("even");
        else
            return new FlowExecutionStatus("odd");
    }

}
