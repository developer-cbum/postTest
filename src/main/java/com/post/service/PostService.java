package com.post.service;

import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
import com.post.domain.vo.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {

    //   게시글 등록
    public void registerPost(PostVO postVO);

    //   게시글 상세 조회
    public Optional<PostDTO> getPost(Long id);
    //   전체 게시글 조회
    public List<PostDTO> getPostList(Pagination pagination);

    //   게시글 수정
    public void modifyPost(PostDTO postDTO);

    //   게시글 삭제
    public void removePost(Long id);

    //    게시글 총개수
    public int getTotal();



}
