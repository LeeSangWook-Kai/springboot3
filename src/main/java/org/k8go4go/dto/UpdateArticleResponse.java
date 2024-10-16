package org.k8go4go.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.k8go4go.domain.Article;

@NoArgsConstructor
@Getter
public class UpdateArticleResponse {
    private String title;
    private String content;

    public UpdateArticleResponse(Article article) {
        this(article.getTitle(), article.getContent());
    }

    public UpdateArticleResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
