package org.k8go4go.controller.view;

import lombok.RequiredArgsConstructor;
import org.k8go4go.dto.view.ArticleViewResponse;
import org.k8go4go.dto.view.ListArticleViewResponse;
import org.k8go4go.serice.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getListArticles(Model model) {
        List<ListArticleViewResponse> articles = blogService.findViewAll();

        model.addAttribute("list", articles);
        model.addAttribute("listsize", articles != null ? articles.size() : 0);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable(name = "id") Long id, Model model) {
        ArticleViewResponse article = blogService.findViewById(id);

        model.addAttribute("article", article);

        return "detail";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false, name = "id") Long id, Model model) {
        if(id == null) { // new page
            model.addAttribute("article", new ArticleViewResponse());
        } else {  // update page
            model.addAttribute("article", blogService.findViewById(id));
        }

        return "newArticle";
    }
}
