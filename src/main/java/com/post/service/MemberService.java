package com.post.service;

import com.post.domain.vo.MemberVO;

import java.util.Optional;

public interface MemberService {

    //회원가입
    public void joinMember(MemberVO memberVO);

    //로그인
    public Optional<Long> getId(String memberEmail, String memberPassword);

    // session pk값으로 회원 정보 전체조회
    public Optional<MemberVO> getMemberById(Long memberId);

    // 중복검사
    public boolean getMemberByEmail(String memberEmail);

}
