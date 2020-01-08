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
        String id = view.inputId();
        Task taskChange = null;
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                taskChange = task;
                break;
            }
        }
        if (taskChange == null) {
            return view.printInfo(null);
        }
        editMenu.run(taskChange);
        return Controller.MAIN_MENU;
    }
}
