package com.post.dao;

import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
import com.post.domain.vo.PostVO;
import com.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    private final PostMapper postMapper;

//   게시글 등록
    public void savePost(PostVO postVO){
        postMapper.insert(postVO);
    }

//   게시글 상세 조회
    public Optional<PostDTO> postFindById(Long id){
        return postMapper.select(id);
    }

//   전체 게시글 조회
    public List<PostDTO> postFindAll(Pagination pagination){
        return postMapper.selectAll(pagination);
    }

//   게시글 수정
    public void setPost(PostDTO postDTO){
        postMapper.update(postDTO);
    }

//   게시글 삭제
    public void deletePost(Long id){
        postMapper.delete(id);
    }

//    게시글 총개수
    public int findTotal(){return postMapper.selectTotal();}

}
