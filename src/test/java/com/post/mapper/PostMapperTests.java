package com.post.mapper;

import com.post.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();
        postVO.setPostWriter("작성자2");
        postVO.setPostTitle("제목2");
        postVO.setPostContent("내용2");

        postMapper.insert(postVO);
    }

    @Test
    public  void selectTest(){
        postMapper.select(1L).ifPresent(postVO -> log.info(postVO.toString()));
    }

    @Test
    public void selectAllTest(){
        postMapper.selectAll().stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        // 게시글 하나 조회
        Optional<PostVO> foundPost = postMapper.select(1L);
        // 있으면 수정
        foundPost.ifPresent(postVO -> postVO.setPostTitle("수정"));
        // 수정
        foundPost.ifPresent(postVO -> postMapper.update(postVO));
    }

    @Test
    public void deleteTest(){
        postMapper.delete(1L);
    }

}
