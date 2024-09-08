# CliTaskApp

A cli based task app in java for submission in roadmap.sh  
Let's build a simple task tracker CLI application that allows users to manage their tasks. The application should support the following actions:  
Visit : https://roadmap.sh/projects/task-tracker

## Actions

- **Add a Task:** Add a new task.
- **Update a Task:** Update the description of a task.
- **Delete a Task:** Remove a task by its ID.
- **Mark a Task:** Mark a task as "in progress" or "done."
- **List Tasks:** List all tasks.

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/imvignesh003/CliTaskApp.git
   ```
   
   ```bash
   cd taskmate

2. **Compile the source code:**
    ```bash
   javac -d . Status.java
   javac -d . Task.java 
   javac -d . Manager.java 
   javac -d . Main.java
   
   ```
3. **Run the application:**
    ```bash
   java taskmate.Main [arguments]
   ```
## Usage
```bash
# Adding a new task
java taskmate.Main add "Fix Bugs"
# Output: Task added successfully (ID: 1)

# Updating a task
java taskmate.Main update 1 "Fix Bugs in the login page"
# Output: Task updated successfully (ID: 1)

# Deleting a task
java taskmate.Main delete 1
# Output: Task deleted successfully (ID: 1)

# Marking a task as in progress
java taskmate.Main mark-in-progress 1
# Output: Task marked as in progress (ID: 1)

# Marking a task as done
java taskmate.Main mark-done 1
# Output: Task marked as done (ID: 1)

# Listing all tasks
java taskmate.Main list
# Output: List of all tasks

# Listing tasks by status
java taskmate.Main list todo
java taskmate.Main list in-progress
java taskmate.Main list done

```