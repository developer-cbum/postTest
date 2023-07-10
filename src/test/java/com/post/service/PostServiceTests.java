package com.post.service;

import com.post.dao.PostDAO;
import com.post.domain.dto.Pagination;
import com.post.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class PostServiceTests {
    @Autowired
    private PostService postService;

    @Test
    public void registerTest(){
        PostVO postVO = new PostVO();
        postVO.setPostWriter("작성자4");
        postVO.setPostTitle("제목4");
        postVO.setPostContent("내용4");
        postService.registerPost(postVO);
    }

    @Test
    public void findByIdTest(){
        postService.getPost(3L).ifPresent(postVO -> log.info(postVO.toString()));
    }

    @Test
    public void getListTest(){
        Pagination pagination = new Pagination();
        pagination.setTotal(postService.getTotal());
        pagination.setPage(1);
        pagination.progress();
        postService.getPostList(pagination).stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void modifyTest(){
        Optional<PostVO> foundPost = postService.getPost(3L);
        foundPost.ifPresent(postVO -> {
            postVO.setPostTitle("수정3");
            postService.modifyPost(postVO);
        });
    }

    @Test
    public void removeTest(){
        postService.removePost(3L);
    }
}
