package com.post.service;

import com.post.dao.PostDAO;
import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
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

    @Autowired
    private MemberService memberService;

//    @Test
//    public void registerTest(){
//
//        Optional<Long> foundId = memberService.getId("ljm1234@naver.com", "1234");
//        log.info(foundId.toString());
//        for (int i = 0; i < 100; i++) {
//            PostVO postVO = new PostVO();
//            postVO.setPostTitle("제목"+ (i+1));
//            postVO.setMemberId(foundId.get());
//            postVO.setPostContent("내용"+ (i+1));
//            postService.registerPost(postVO);
//        }
//    }
//
//    @Test
//    public void findByIdTest(){
//        postService.getPost(3L).ifPresent(postVO -> log.info(postVO.toString()));
//    }
//
//    @Test
//    public void getListTest(){
//        Pagination pagination = new Pagination();
//        pagination.setTotal(postService.getTotal());
//        pagination.setPage(1);
//        pagination.progress();
//        postService.getPostList(pagination).stream().map(PostDTO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void modifyTest(){
//        Optional<PostDTO> foundPost = postService.getPost(3L);
//        foundPost.ifPresent(postDTO -> {
//            postDTO.setPostTitle("수정3");
//            postService.modifyPost(postDTO);
//        });
//    }
//
//    @Test
//    public void removeTest(){
//        postService.removePost(3L);
//    }
}
