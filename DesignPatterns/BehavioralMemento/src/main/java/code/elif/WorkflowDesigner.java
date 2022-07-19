package code.elif;

public class WorkflowDesigner {

    Workflow workflow;

    public void createWorkflow(String name) {
        workflow = new Workflow(name);
    }

    public Memento createMemento() {
        if (workflow == null) {
            return new Memento();
        }
        return new Memento(workflow.getSteps(), workflow.getName());
    }

    public void setMemento(Memento memento) {
        if (memento.isEmpty()) {
            this.workflow = null;
        } else {
            this.workflow = new Workflow(memento.name, memento.steps);
        }
    }

    public void addStep(String step) {
        workflow.addStep(step);
    }

    public void removeStep(String step) {
        workflow.removeStep(step);
    }

    public void print() {
        System.out.println(workflow);
    }

    public class Memento {

        private String[] steps;

        private String name;

        private Memento() {
        }

        private Memento(String[] steps, String name) {
            this.steps = steps;
            this.name = name;
        }

        private String[] getSteps() {
            return steps;
        }

        private String getName() {
            return name;
        }

        private boolean isEmpty() {
            return this.getSteps() == null && this.getName() == null;
        }
    }

}
