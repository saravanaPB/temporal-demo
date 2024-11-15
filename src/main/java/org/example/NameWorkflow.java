package org.example;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface NameWorkflow {

    @WorkflowMethod
    String printName(String name);

}
