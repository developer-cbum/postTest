package com.post.mapper;

import com.post.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    //게시판 등록
    public void insert(PostVO postVO);

    //게시판 하나 조회
    public Optional<PostVO> select(Long postId);

    //게시판 전체 조회
    public List<PostVO> selectAll();

    //게시판 수정
    public void update(PostVO postVO);

    //게시판 삭제
    public void delete(Long id);
}
