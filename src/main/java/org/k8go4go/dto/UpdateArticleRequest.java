package org.k8go4go.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.k8go4go.domain.Article;

@Getter
@NoArgsConstructor
public class UpdateArticleRequest {
    private String title;
    private String content;

    public UpdateArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
