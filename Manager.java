package taskmate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Vignesh G
 * @apiNote
 * The Manager class which manages all the tasks
 */
public class Manager {
    private final Path FILE_PATH = Path.of("tasks.json");
    private List<Task> tasks;


    public Manager(){
        this.tasks = loadTasks();
    }

    
    private List<Task> loadTasks(){
        List<Task> storedTasks = new ArrayList<>();

        if (!Files.exists(FILE_PATH)){
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskList = jsonContent.replace("[", "")
                                            .replace("]", "")
                                            .split("},");
            for (String taskJson : taskList){
                if (!taskJson.endsWith("}")){
                    taskJson = taskJson + "}";
                    storedTasks.add(Task.fromJson(taskJson));
                } else {
                    storedTasks.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return storedTasks;
    }

    public void saveTasks(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < tasks.size(); i++){
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1){
                sb.append(",\n");
            }
        }
        sb.append("\n]");

        String jsonContent = sb.toString();
        try {
            Files.writeString(FILE_PATH, jsonContent);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addTask(String description){
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
    }

    public void updateTask(String id, String newDesc){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found!"));
        task.updateDescription(newDesc);
    }

    public void deleteTask(String id){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found!"));
        tasks.remove(task);
    }

    public void markInProgress(String id){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found!"));
        task.markInProgress();
    }

    public void markDone(String id){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found!"));
        task.markDone();
    }

    public void listTasks(String type){
        for (Task task : tasks){
            String status = task.getStatus().toString().strip();
            if (type.equals("All") || status.equals(type)){
                System.out.println(task.toString());
            }
        }
    }

    public Optional<Task> findTask(String id) {
        return tasks.stream().filter((task) -> task.getId() == Integer.parseInt(id)).findFirst();
    }


}
