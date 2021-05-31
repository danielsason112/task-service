package il.ac.afeka.scrum;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
	public List<Task> findByTeamId(String teamId);
}
