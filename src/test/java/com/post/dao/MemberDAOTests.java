package com.post.dao;

import com.post.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

    //회원가입
    @Test
    public void saveTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("lss1234@naver.com");
        memberVO.setMemberName("이순신");
        memberVO.setMemberPassword("1234");

        memberDAO.saveMember(memberVO);
    }

    //로그인 테스트
    @Test
    public void findIdTest(){
        Optional<Long> foundLong = memberDAO.findId("ljm1234@naver.com", "1234");
//        foundLong.ifPresent(aLong -> assertThat(aLong).isEqualTo(1L));
//        foundLong.ifPresent(aLong -> log.info(aLong.toString()));
        log.info(String.valueOf(foundLong.isEmpty()));
    }

    // session 값으로 회원 정보 전체조회
    @Test
    public void findMemberByIdTest(){
        memberDAO.findMemberById(1L).ifPresent(memberVO -> log.info(memberVO.toString()));
    }

    //이메일 중복검사
    @Test
    public void findMemberByEmail(){
        log.info(String.valueOf(memberDAO.findMemberByEmail("ljm1234@naver.com")));
    }

}
