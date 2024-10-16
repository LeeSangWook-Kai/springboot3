package org.k8go4go.controller;

import lombok.RequiredArgsConstructor;
import org.k8go4go.dto.AddArticleRequest;
import org.k8go4go.dto.AddArticleResponse;
import org.k8go4go.dto.UpdateArticleRequest;
import org.k8go4go.dto.UpdateArticleResponse;
import org.k8go4go.serice.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<AddArticleResponse> addArticle(@RequestBody AddArticleRequest request) {
        AddArticleResponse response = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<AddArticleResponse>> allArticles() {
        List<AddArticleResponse> list = blogService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<AddArticleResponse> findArticle(@PathVariable(name = "id") Long id) {
        AddArticleResponse response = blogService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/api/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable(name = "id") Long id) {
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/article/{id}")
    public ResponseEntity<UpdateArticleResponse> updateArticle(@PathVariable(name = "id") Long id, UpdateArticleRequest request) {
        UpdateArticleResponse updated = blogService.updateArticle(id, request);

        return ResponseEntity.ok().body(updated);
    }
}
