package net.serenitybdd.demos.todos.screenplay.tasks;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.demos.todos.screenplay.user_interface.TodoList.WHAT_NEEDS_TO_BE_DONE;
import static org.openqa.selenium.Keys.RETURN;
import net.serenitybdd.demos.todos.screenplay.interactions.WaitForTargetToBeVisible;

public class AddATodoItem {

    public static Task called(String thingToDo) {
        return Task.where("{0} adds a todo item called: " + thingToDo,
        // WaitForTargetToBeVisible.called(WHAT_NEEDS_TO_BE_DONE, 10),
                Enter.theValue(thingToDo)
                        .into(WHAT_NEEDS_TO_BE_DONE)
                        .thenHit(RETURN)
                );
    }
}
