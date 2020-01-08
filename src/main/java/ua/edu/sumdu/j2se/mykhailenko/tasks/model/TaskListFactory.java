package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

public class TaskListFactory {
    public static AbstractTaskList createTaskList(ListTypes.Types type) {
        switch (type) {
            case ARRAY:
                return new ArrayTaskList();
            case LINKED:
                return new LinkedTaskList();
            default:
                return null;
        }
    }
}
