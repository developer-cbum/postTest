package com.post.domain.dto;

import com.post.domain.vo.FileVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class PostDTO {
    private Long postId;
    private Long memberId;
    private String memberName;
    private String postTitle;
    private String postContent;
    private String postRegisterDate;
    private String postUpdateDate;
    private List<FileVO> files = new ArrayList<>();
}
