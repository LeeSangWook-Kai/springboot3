package org.k8go4go.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.k8go4go.domain.Article;

@Getter
@NoArgsConstructor
public class AddArticleResponse {
    private Long id;
    private String title;
    private String content;

    public AddArticleResponse(Article article) {
        this(article.getId(), article.getTitle(), article.getContent());
    }

    public AddArticleResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
