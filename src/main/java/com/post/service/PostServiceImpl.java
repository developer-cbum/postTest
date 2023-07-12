package com.post.service;

import com.post.dao.FileDAO;
import com.post.dao.PostDAO;
import com.post.domain.dto.Pagination;
import com.post.domain.dto.PostDTO;
import com.post.domain.vo.PostVO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;
    private final FileDAO fileDAO;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerPost(PostDTO postDTO) {
        postDAO.savePost(postDTO);
        for (int i = 0; i < postDTO.getFiles().size(); i++) {
            postDTO.getFiles().get(i).setPostId(postDTO.getPostId());
            fileDAO.saveFile(postDTO.getFiles().get(i));
        }
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

//       새로 수정하는 파일 추가
        postDAO.setPost(postDTO);
        postDTO.getFiles().forEach(file -> {
            file.setPostId(postDTO.getPostId());
            fileDAO.saveFile(file);
        });
//      삭제
        postDTO.getFileIdsForDelete().forEach(fileDAO::deleteFile);
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
