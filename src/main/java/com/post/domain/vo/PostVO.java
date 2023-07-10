package com.post.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PostVO {
    private Long postId;
    private String postWriter;
    private String postTitle;
    private String postContent;
    private String postRegisterDate;
    private String postUpdateDate;
}
