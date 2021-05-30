package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
public ModelAndView seznamPost (Pageable pageable) {
        return new ModelAndView ("index")
                .addObject("post", postService.list(LocalDate.now(), pageable));
    }

    @GetMapping("/post")
    public String form(String slug) {
        return String.format("redirect:/post/%s", slug);
    }

   @GetMapping("/post/{slug}")
public ModelAndView jedenPost (@PathVariable String slug, Pageable pageable){
        return new ModelAndView("post")
                .addObject("post", postService.singlePost(slug,pageable));
    }



    @ModelAttribute("currentURL")
    public String currentURL(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        return UriComponentsBuilder
                .newInstance()
                .path(helper.getOriginatingRequestUri(request))
                .query(helper.getOriginatingQueryString(request))
                .replaceQueryParam("size")
                .replaceQueryParam("page")
                .build()
                .toString();
    }
}
