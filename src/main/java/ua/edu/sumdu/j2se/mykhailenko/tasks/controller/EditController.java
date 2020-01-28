package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.EditMenuView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.View;

public class EditController extends Controller {
    EditMenuController editMenu;

    public EditController(View view, int actionPerform) {
        super(view, actionPerform);
        editMenu = new EditMenuController(new EditMenuView(), 0);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        String id = view.inputNameOrID("\nВведите id задачи: ");
        Task taskChange = null;
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                taskChange = task;
                break;
            }
        }
        if (taskChange == null) {
            return view.printInfo(View.TASK_NOT_FOUND);
        }
        editMenu.run(taskChange);
        return Controller.MAIN_MENU;
    }
}
