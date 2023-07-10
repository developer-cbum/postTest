package com.post.dao;

import com.post.domain.dto.Pagination;
import com.post.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class PostDAOTests {

    @Autowired
    private PostDAO postDAO;

    @Test
    public void saveTest(){
        PostVO postVO = new PostVO();
        postVO.setPostWriter("작성자3");
        postVO.setPostTitle("제목3");
        postVO.setPostContent("내용3");
        postDAO.savePost(postVO);
    }

    @Test
    public void findByIdTest(){
        postDAO.postFindById(2L).ifPresent(postVO -> log.info(postVO.toString()));
    }

    @Test
    public void findAllTest(){

        Pagination pagination = new Pagination();
        pagination.setTotal(postDAO.findTotal());
        pagination.setPage(1);
        pagination.progress();
        postDAO.postFindAll(pagination).stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void setTest(){
        Optional<PostVO> foundPost = postDAO.postFindById(2L);
        foundPost.ifPresent(postVO -> {
            postVO.setPostTitle("수정2");
            postDAO.setPost(postVO);
        });
    }

    @Test
    public void deleteTest(){
        postDAO.deletePost(2L);
    }
}
