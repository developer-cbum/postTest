package com.post.mapper;

import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
import com.post.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    //게시판 등록
    public void insert(PostVO postVO);

    //게시판 하나 조회
    public Optional<PostDTO> select(Long postId);

    //게시판 전체 조회
    public List<PostDTO> selectAll(Pagination pagination);

    //게시판 수정
    public void update(PostDTO postDTO);

    //게시판 삭제
    public void delete(Long id);

    //총 개수
    public int selectTotal();
}
