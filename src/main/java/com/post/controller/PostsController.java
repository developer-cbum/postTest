package com.post.controller;

import com.post.domain.dto.Pagination;
import com.post.domain.vo.PostVO;
import com.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/posts/*")
public class PostsController {

    private final PostService postService;


    @GetMapping("/list")
    public void goToMain(Pagination pagination,Model model){
        JSONArray jsonArray = new JSONArray();
        pagination.setTotal(postService.getTotal());
        pagination.progress();
        postService.getPostList(pagination).stream().map(postVO -> new JSONObject(postVO)).forEach(jsonArray::put);
        model.addAttribute("posts", jsonArray);
            model.addAttribute("pagination", pagination);
    }

    @GetMapping("/write")
    public void goToWrite(){;}

    @PostMapping("/write")
    public RedirectView write(PostVO postVO){
        postService.registerPost(postVO);
        return new RedirectView("/posts/list");
    }

    @GetMapping("/detail/{id}")
    public String goToDetail(@PathVariable Long id, Model model){
        postService.getPost(id).ifPresent(postVO ->
                model.addAttribute("post", postVO));
        return "/posts/detail";
    }


    @GetMapping("/modify/{id}")
    public String goToModify(@PathVariable Long id, Model model){
        postService.getPost(id).ifPresent(postVO ->
                model.addAttribute("post", postVO));
        return "/posts/modify";
    }

    @PostMapping("/modify/{id}")
    public RedirectView modify(@PathVariable Long id, PostVO postVO){
        postService.modifyPost(postVO);
        return new RedirectView("/posts/detail/" + id);
    }

    @GetMapping("/remove/{id}")
    public RedirectView remove(@PathVariable Long id){
        postService.removePost(id);
        return new RedirectView("/posts/list");
    }

}
