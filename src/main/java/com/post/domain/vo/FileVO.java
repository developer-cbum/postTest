package com.post.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileVO {
    private Long fileId;
    private String fileName;
    private String filePath;
    private String fileUuid;
    private Long fileSize;
    private Long postId;
}
