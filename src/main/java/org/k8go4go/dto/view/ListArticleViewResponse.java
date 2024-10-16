package org.k8go4go.dto.view;

import lombok.Getter;
import org.k8go4go.domain.Article;

@Getter
public class ListArticleViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ListArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
