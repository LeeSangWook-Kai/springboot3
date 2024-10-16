package org.k8go4go.serice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.k8go4go.domain.Article;
import org.k8go4go.dto.AddArticleRequest;
import org.k8go4go.dto.AddArticleResponse;
import org.k8go4go.dto.UpdateArticleRequest;
import org.k8go4go.dto.UpdateArticleResponse;
import org.k8go4go.dto.view.ArticleViewResponse;
import org.k8go4go.dto.view.ListArticleViewResponse;
import org.k8go4go.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    @Transactional
    public AddArticleResponse save(AddArticleRequest request) {
        Article article = blogRepository.save(request.toEntity());
        return new AddArticleResponse(article.getId(), article.getTitle(), article.getContent());
    }

    public List<AddArticleResponse> findAll() {
        return blogRepository.findAll().stream().map(AddArticleResponse::new).toList();
    }

    public List<ListArticleViewResponse> findViewAll() {
        return blogRepository.findAll().stream().map(ListArticleViewResponse::new).toList();
    }

    public AddArticleResponse findById(Long id) {
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found : " + id));
        return new AddArticleResponse(article);
    }

    public ArticleViewResponse findViewById(Long id) {
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found : " + id));
        return new ArticleViewResponse(article);
    }

    @Transactional
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public UpdateArticleResponse updateArticle(Long id, UpdateArticleRequest request) {
        Article updatedArticle = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        updatedArticle.update(request.getTitle(), request.getContent());
        return new UpdateArticleResponse(updatedArticle);
    }
}
