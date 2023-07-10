package com.post.service;

import com.post.domain.vo.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {

    //   게시글 등록
    public void registerPost(PostVO postVO);

    //   게시글 상세 조회
    public Optional<PostVO> getPost(Long id);
    //   전체 게시글 조회
    public List<PostVO> getPostList();

    //   게시글 수정
    public void modifyPost(PostVO postVO);

    //   게시글 삭제
    public void removePost(Long id);



}
