package controller;

import model.Task;
import model.premodel.Date;
import model.premodel.Priority;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private ArrayList<Task> storage = new ArrayList<>();

    @GetMapping
    public ArrayList<Task> getTaskList(){
        return storage;
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task newTask){
        storage.add(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task){
        for(Task currentTask : storage){
            if(currentTask.getId() == id){
                currentTask.setTaskName(task.getTaskName());
                currentTask.setPriority(task.getPriority());
                currentTask.setDescription(task.getDescription());
                currentTask.setDate(task.getDate());
                return ResponseEntity.ok("Task updated successfully");

            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no task with the specified id: " + id);
    }

    @PatchMapping("/{id}/date")
    public ResponseEntity<String> updateDate(@PathVariable int id, @RequestBody Date date){
        for(Task currentTask : storage){
            if(currentTask.getId() == id){
                currentTask.setDate(date);
                return ResponseEntity.ok("Date updated successfully, new date: " + date);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no task with the specified id: " + id);
    }

    @PatchMapping("/{id}/priority")
    public ResponseEntity<String> updatePriority(@PathVariable int id, @RequestBody Priority priority){
        for(Task currentTask: storage){
            if(currentTask.getId() == id){
                currentTask.setPriority(priority);
                return ResponseEntity.ok("Priority updated successfully, new priority: " + priority);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no task with the specified id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        boolean isRemoved = storage.removeIf(task -> task.getId() == id);
        if(isRemoved){
            return ResponseEntity.ok("Task removed successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no task with the specified id: " + id);

    }




}
