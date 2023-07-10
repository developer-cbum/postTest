package com.post.controller;

import com.post.domain.dto.Pagination;
import com.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.HashMap;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/posts/*")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public void goToMain(Pagination pagination,Model model){
        JSONArray jsonArray = new JSONArray();
        pagination.setTotal(postService.getTotal());
        pagination.progress();
        postService.getPostList(pagination).stream().map(postVO -> new JSONObject(postVO)).forEach(jsonArray::put);
        model.addAttribute("posts", jsonArray);
//        model.addAttribute("prev", pagination.isPrev());
//        model.addAttribute("next", pagination.isNext());
//        model.addAttribute("startPage", pagination.getStartPage());
//        model.addAttribute("endPage", pagination.getEndPage());
//        model.addAttribute("page", pagination.getPage());
            model.addAttribute("pagination", pagination);
    }
}
