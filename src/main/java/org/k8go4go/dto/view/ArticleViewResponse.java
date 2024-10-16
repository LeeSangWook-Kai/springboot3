package org.k8go4go.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.k8go4go.domain.Article;

import java.time.LocalDateTime;

@Getter

public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ArticleViewResponse(){}

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();
    }
}
