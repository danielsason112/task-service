package il.ac.afeka.scrum;

import java.util.List;

public interface TasksService {

	Task createTask(Task task);

	Task getTaskById(String taskId);

	List<Task> getAll();
	
	List<Task> getByTeamId(String teamId);
	
	void updateTask(String taskId, Task task);

}
