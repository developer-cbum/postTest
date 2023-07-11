package com.post.mapper;

import com.post.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;


    //회원가입
    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("ljm1234@naver.com");
        memberVO.setMemberName("이종문");
        memberVO.setMemberPassword("1234");

        memberMapper.insert(memberVO);
    }

    //로그인 테스트
    @Test
    public void selectIdTest(){
        Optional<Long> foundLong = memberMapper.selectId("ljm123@naver.com", "1234");
//        foundLong.ifPresent(aLong -> assertThat(aLong).isEqualTo(1L));
//        foundLong.ifPresent(aLong -> log.info(aLong.toString()));
    }

    // session 값으로 회원 정보 전체조회
    @Test
    public void selectMemberByIdTest(){
        memberMapper.selectMemberById(1L).ifPresent(memberVO -> log.info(memberVO.toString()));
    }

    //이메일 중복검사
    @Test
    public void selectMemberByEmail(){
        memberMapper.selectMemberByEmail("ljm1234@naver.com").ifPresent(aLong -> log.info(aLong.toString()));
    }

}
