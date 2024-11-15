package org.example;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class NameWorkflowImpl implements NameWorkflow {

    // Activity options can be initialized as needed
    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(10))
            .build();

    @Override
    public String printName(String name) {
        NameActivity activity = Workflow.newActivityStub(NameActivity.class, options);

        System.out.println("id " + Workflow.getInfo().getWorkflowId());
        System.out.println(Workflow.getInfo().getRunId());
        System.out.println(Workflow.getInfo().getTaskQueue());

        return activity.composeName(name);
    }
}
