package il.ac.afeka.scrum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoTasksService implements TasksService {
	private TaskRepository repository;
	
	
	@Autowired
	public MongoTasksService(TaskRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Task createTask(Task task) {
		return repository.save(task);
	}

	@Override
	public Task getTaskById(String taskId) {
		return repository.findById(taskId).orElse(null);
	}

	@Override
	public List<Task> getAll() {
		List<Task> tasks = repository.findAll();
		return sort(tasks);
	}

	@Override
	public List<Task> getByTeamId(String teamId) {
		List<Task> tasks = this.repository.findByTeamId(teamId);
		return sort(tasks);
	}
	
	
	
	@Override
	public void updateTask(String taskId, Task task) {
		if (this.repository.findById(taskId).orElse(null) == null) {
			return;
		}
		this.repository.save(task);
	}

	private List<Task> sort(List<Task> tasks) {
		List<Task> sorted = new ArrayList<>();
		tasks.forEach(t -> {
			if (t.getTaskStatus().equals(TaskStatus.BACKLOG)) {
				sorted.add(t);
			}
		});
		tasks.forEach(t -> {
			if (t.getTaskStatus().equals(TaskStatus.TODO)) {
				sorted.add(t);
			}
		});
		tasks.forEach(t -> {
			if (t.getTaskStatus().equals(TaskStatus.IN_PROGRESS)) {
				sorted.add(t);
			}
		});
		tasks.forEach(t -> {
			if (t.getTaskStatus().equals(TaskStatus.REVIEW)) {
				sorted.add(t);
			}
		});
		tasks.forEach(t -> {
			if (t.getTaskStatus().equals(TaskStatus.DONE)) {
				sorted.add(t);
			}
		});
		return sorted;
	}

}
