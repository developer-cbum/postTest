package com.post.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
}
