package ua.edu.sumdu.j2se.mykhailenko.tasks.controller;

import ua.edu.sumdu.j2se.mykhailenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.AddView;
import ua.edu.sumdu.j2se.mykhailenko.tasks.view.*;

import java.util.ArrayList;
import java.util.List;

public class MainController extends Controller {
    private List<Controller> controllers = new ArrayList<>();

    public MainController(View view, AbstractTaskList taskList) {
        super(view, 0);
        this.controllers.add(this);
        this.controllers.add(new AddController(new AddView(), 1));
        this.controllers.add(new CalendarController(new CalendarView(), 5));
        this.controllers.add(new DeleteController(new DeleteView(), 3));
        this.controllers.add(new EditController(new EditView(), 2));
        this.controllers.add(new ViewTasksController(new TasksView(), 4));
    }


    @Override
    public int process(AbstractTaskList taskList) {
        int action = view.printInfo(taskList);
        while (true) {
            for (Controller controller : controllers) {
                if (controller.canProcess(action)) {
                    action = controller.process(taskList);
                }
            }
            if (action == QUIT) {
                break;
            }
        }
        return QUIT;
    }
}
