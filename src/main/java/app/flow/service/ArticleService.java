package app.flow.service;

import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;

import app.flow.entity.TaskDto;

@Service
public class ArticleService {

	private final RuntimeService runtimeService;
    private final TaskService taskService;
    
    public ArticleService(RuntimeService runtimeService, TaskService taskService) {
    	this.runtimeService = runtimeService;
    	this.taskService = taskService;
    }

    public String submitArticle(String title, String authorEmail) {
        var processInstance = runtimeService.startProcessInstanceByKey(
                "articleReviewProcess",
                Map.of("title", title, "authorEmail", authorEmail)
        );
        return processInstance.getId();
    }
    
    public List<TaskDto> getEditorTasksDto() {
        return taskService.createTaskQuery()
                .taskAssignee("editor")
                .list()
                .stream()
                .map(task -> new TaskDto(task.getId(), task.getName(), task.getAssignee()))
                .toList();
    }

    public void reviewArticle(String taskId, boolean accepted) {
        taskService.complete(taskId, Map.of("accepted", accepted));
    }
}
