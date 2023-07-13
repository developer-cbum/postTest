package com.post.service;

import com.post.dao.FileDAO;
import com.post.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileDAO fileDAO;

    @Override
    public void registerFile(FileVO fileVO) {
        fileDAO.saveFile(fileVO);
    }

    @Override
    public List<FileVO> getFiles(Long postId) {
        return fileDAO.findByPostId(postId);
    }

    @Override
    public void removeFile(Long fileId) {
        fileDAO.deleteFile(fileId);
    }

    @Override
    public void removeFileAll(Long postId) {
        fileDAO.deleteFileAll(postId);
    }

    @Override
    public int getCount(Long postId) {
        return fileDAO.getCount(postId);
    }
}
