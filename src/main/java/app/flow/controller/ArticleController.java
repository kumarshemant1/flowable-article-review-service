package app.flow.controller;

import java.util.List;

import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.flow.entity.TaskDto;
import app.flow.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	private ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@PostMapping("/submit")
    public String submitArticle(@RequestParam String title, @RequestParam String authorEmail) {
        return articleService.submitArticle(title, authorEmail);
    }

    @GetMapping("/tasks")
    public List<TaskDto> getEditorTasks() {
        return articleService.getEditorTasksDto();
    }

    @PostMapping("/review/{taskId}")
    public String reviewArticle(@PathVariable String taskId, @RequestParam boolean accepted) {
        articleService.reviewArticle(taskId, accepted);
        return "Review completed for task " + taskId;
    }
}
