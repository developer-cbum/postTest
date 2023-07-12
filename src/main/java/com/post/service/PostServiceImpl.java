package com.post.service;

import com.post.dao.PostDAO;
import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
import com.post.domain.vo.PostVO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;
    @Override
    public void registerPost(PostVO postVO) {
        postDAO.savePost(postVO);
    }

    @Override
    public Optional<PostDTO> getPost(Long id) {
        return postDAO.postFindById(id);
    }

    @Override
    public List<PostDTO> getPostList(Pagination pagination) {
        return postDAO.postFindAll(pagination);
    }

    @Override
    public void modifyPost(PostDTO postDTO) {
        postDAO.setPost(postDTO);
    }

    @Override
    public void removePost(Long id) {
        postDAO.deletePost(id);
    }

    @Override
    public int getTotal() {
        return postDAO.findTotal();
    }
}
