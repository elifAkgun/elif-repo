package code.elif.command;

import code.elif.WorkflowDesigner;

public class AddStepCommand extends AbstractWorkflowCommand{

    private String step;

    public AddStepCommand(WorkflowDesigner receiver, String step) {
        super(receiver);
        this.step = step;
    }


    @Override
    public void execute() {
        this.memento = receiver.createMemento();
        receiver.addStep(step);
    }
}
