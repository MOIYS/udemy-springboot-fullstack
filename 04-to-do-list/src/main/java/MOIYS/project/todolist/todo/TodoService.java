package MOIYS.project.todolist.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import jakarta.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "MOIYS", "Get AWS Certified 1",
            LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "MOIYS", "Learn DevOps 1",
            LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "MOIYS", "Learn Full Stack 1",
            LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String task, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, task, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        return todos.stream()
            .filter(todo -> todo.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
