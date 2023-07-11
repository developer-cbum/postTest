package com.post.mapper;

import com.post.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    //회원가입
    public void insert(MemberVO memberVO);

    //로그인
    public Optional<Long> selectId(@Param("memberEmail") String memberEmail, @Param("memberPassword" )String memberPassword);

    // session pk값으로 회원 정보 전체조회
    public Optional<MemberVO> selectMemberById(Long memberId);

    // 중복검사
    public Optional<Long> selectMemberByEmail(String memberEmail);
}
