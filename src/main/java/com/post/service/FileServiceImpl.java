package com.post.service;

import com.post.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {


    private final FileService fileService;

    @Override
    public void registerFile(FileVO fileVO) {
        fileService.registerFile(fileVO);
    }

    @Override
    public List<FileVO> getFiles(Long postId) {
        return fileService.getFiles(postId);
    }

    @Override
    public void removeFiles(Long postId) {

    }
}
