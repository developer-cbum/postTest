package com.post.dao;

import com.post.domain.vo.MemberVO;
import com.post.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    //회원가입
    public void saveMember(MemberVO memberVO){
        memberMapper.insert(memberVO);
    };

    //로그인
    public Optional<Long> findId(String memberEmail, String memberPassword){
        return memberMapper.selectId(memberEmail,memberPassword);
    }

    // session pk값으로 회원 정보 전체조회
    public Optional<MemberVO> findMemberById(Long memberId){
        return memberMapper.selectMemberById(memberId);
    }

    // 중복검사
    public boolean findMemberByEmail(String memberEmail){
        Optional<Long> foundId = memberMapper.selectMemberByEmail(memberEmail);
        if(foundId.isEmpty()){
//           중복 없음
            return true;
        }
//        중복있음
        return false;
    }

}
