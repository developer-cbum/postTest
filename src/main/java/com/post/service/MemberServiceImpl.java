package com.post.service;

import com.post.dao.MemberDAO;
import com.post.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    @Override
    public void joinMember(MemberVO memberVO) {
        memberDAO.saveMember(memberVO);
    }

    @Override
    public Optional<Long> getId(String memberEmail, String memberPassword) {
        return memberDAO.findId(memberEmail,memberPassword);
    }

    @Override
    public Optional<MemberVO> getMemberById(Long memberId) {
        return memberDAO.findMemberById(memberId);
    }

    @Override
    public boolean getMemberByEmail(String memberEmail) {
        return memberDAO.findMemberByEmail(memberEmail);
    }
}
