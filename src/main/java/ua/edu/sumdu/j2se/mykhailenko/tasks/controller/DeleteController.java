package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.DeleteView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public class DeleteController extends Controller {
    public DeleteController(View view, int actionPerform) {
        super(view, actionPerform);
    }

    public int process(AbstractTaskList taskList) {
        DeleteView deleteView = (DeleteView) view;
        String id = deleteView.inputId();
        boolean resultInfo = false;
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                taskList.remove(task);
                resultInfo = true;
            }
        }
        return deleteView.printInfo(resultInfo);
    }
}
