package MOIYS.project.todolist.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String username;

    @Size(min=10, message="Enter atleast 10 Characters")
    private String task;
    private LocalDate targetDate;
    private boolean done;

    public Todo() {}

    public Todo(int id, String username, String task, LocalDate targetDate, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.task = task;
        this.targetDate = targetDate;
        this.done = done;
    }
}