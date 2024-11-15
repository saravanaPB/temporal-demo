package org.example;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;


public class NameWorkflowStarter {

    public static void main(String[] args) throws Exception {

//        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(
//                WorkflowServiceStubsOptions.newBuilder().setTarget("localhost:8233").build());
//
//        WorkflowClient client =
//                WorkflowClient.newInstance(
//                        service, WorkflowClientOptions.newBuilder().setNamespace("default").build());

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client = WorkflowClient.newInstance(service);
        final String WORKFLOW_ID = "nameTaskId4";

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setWorkflowId(WORKFLOW_ID)
                .setTaskQueue("nameTask")
                .build();

        NameWorkflow workflow = client.newWorkflowStub(NameWorkflow.class, options);
        String name = workflow.printName("saravana");
        String workflowId = WorkflowStub.fromTyped(workflow).getExecution().getWorkflowId();
        System.out.println(workflowId + " " + name);
        System.exit(0);
    }
}
