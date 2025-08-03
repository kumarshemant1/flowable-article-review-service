# flowable-article-review-service
Article review service implemented using Flowable.
<img width="169" height="230" alt="image" src="https://github.com/user-attachments/assets/f8fdf7fd-1993-44bd-97b3-2849b9d752e4" />

Submit Article
curl -X POST "http://localhost:8080/articles/submit?title=Flowable%20Intro&authorEmail=test@example.com"

Get Editor Tasks
curl http://localhost:8080/articles/tasks

Approve / Reject
curl -X POST "http://localhost:8080/articles/review/{taskId}?accepted=true"
