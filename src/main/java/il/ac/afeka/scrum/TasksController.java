package il.ac.afeka.scrum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {
	private TasksService tasksService;

	@Autowired
	public TasksController(TasksService tasksService) {
		this.tasksService = tasksService;
	}
	
	@RequestMapping(path = "/tasks",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Task createTask(@RequestBody Task task) {
		return tasksService.createTask(task);
	}
	
	@RequestMapping(path = "/tasks/team/{teamId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Task[] getByTeam(@PathVariable("teamId") String teamId) {
		return tasksService.getByTeamId(teamId).toArray(new Task[0]);
	}
	
	@RequestMapping(path = "/tasks/{taskId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Task getTask(@PathVariable("taskId") String taskId) {
		return tasksService.getTaskById(taskId);
	}
	
	@RequestMapping(path = "/tasks",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	 public Task[] getAll() {
		 
		 return tasksService.getAll().toArray(new Task[0]);
	 }
	
	@RequestMapping(path = "/tasks/{taskId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateTask(@RequestBody Task task, @PathVariable("taskId") String taskId) {
		tasksService.createTask(task);
	}
}
