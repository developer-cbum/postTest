package com.post.mapper;

import com.post.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    public void insert(FileVO fileVO);

    public List<FileVO> selectByPostId(Long postId);

    public void delete(Long fileId);

    public int getCount(Long postId);

    public void deleteAll(Long postId);

}
