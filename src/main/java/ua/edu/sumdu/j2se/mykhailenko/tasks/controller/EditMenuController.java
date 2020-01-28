package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.Task;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.*;

import java.util.ArrayList;
import java.util.List;

public class EditMenuController extends SubController {
    private List<SubController> controllersEdit = new ArrayList<>();

    public EditMenuController(View view, int actionPerform) {
        super(view, actionPerform);
        controllersEdit.add(this);
        controllersEdit.add(new EditNameController(new View(), 1));
        controllersEdit.add(new EditTimeController(new View(), 2));
        controllersEdit.add(new EditActiveController(new EditActiveView(), 3));
        controllersEdit.add(new EditRepeatController(new View(), 4));
    }

    public int run(Task task) {
        int action = view.printInfo(task);
        while (true) {
            for (SubController controller : controllersEdit) {
                if (controller.canProcess(action)) {
                    action = controller.run(task);
                }
            }
            if (action == SubController.BACK_MENU) {
                break;
            }
        }
        return SubController.BACK_MENU;
    }
}
