package com.post.service;

import com.post.domain.vo.FileVO;

import java.util.List;

public interface FileService {

    public void registerFile(FileVO fileVO);

    public List<FileVO> getFiles(Long postId);

    public void removeFiles(Long postId);

    public int getCount(Long postId);
}
