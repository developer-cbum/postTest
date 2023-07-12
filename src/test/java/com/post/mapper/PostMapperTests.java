package com.post.mapper;

import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
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

//    @Test
//    public void insertTest(){
//        //게시글 등록
//        for (int i = 0; i < 50; i++) {
//            PostVO postVO = new PostVO();
//            postVO.setPostTitle("제목"+ (i + 1));
//            postVO.setPostContent("내용"+ (i + 1));
//            postMapper.insert(postVO);
//
//        }
//    }
//
//    @Test
//    public  void selectTest(){
//        //게시글 조회
//        postMapper.select(1L).ifPresent(postVO -> log.info(postVO.toString()));
//    }
//
//    @Test
//    public void selectAllTest(){
////        게시글 전체 조회
//        Pagination pagination = new Pagination();
//        pagination.setTotal(postMapper.selectTotal());
//        pagination.setPage(1);
//        pagination.progress();
//        postMapper.selectAll(pagination).stream().map(PostDTO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void updateTest(){
//        // 게시글 하나 조회
//        Optional<PostDTO> foundPost = postMapper.select(1L);
//        // 있으면 수정
//        foundPost.ifPresent(postDTO -> postDTO.setPostTitle("수정"));
//        // 수정
//        foundPost.ifPresent(postDTO -> postMapper.update(postDTO));
//    }
//
//    @Test
//    public void deleteTest(){
////        게시글삭제
//        postMapper.delete(1L);
//    }
//
//    @Test
//    public void selectTotalTests(){
////        총개수
//        log.info(String.valueOf(postMapper.selectTotal()));
//    }

}
