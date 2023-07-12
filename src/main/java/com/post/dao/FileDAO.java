package com.post.dao;

import com.post.domain.vo.FileVO;
import com.post.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {

    private final FileMapper fileMapper;

    public void saveFile(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

    public List<FileVO> findByPostId(Long postId){
        return fileMapper.selectByPostId(postId);
    }

    public void deleteFile(Long postId){
        fileMapper.delete(postId);
    }

    public int getCount(Long postId){ return fileMapper.getCount(postId);}

}
