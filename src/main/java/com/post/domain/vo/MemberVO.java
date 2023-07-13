package com.post.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberRegisterDate;
    private String memberUpdateDate;
    private Character memberStatus;
}
