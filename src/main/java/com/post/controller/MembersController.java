package com.post.controller;

import com.post.domain.vo.MemberVO;
import com.post.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MembersController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void goToLogin(){;}

    @PostMapping("/login")
    public RedirectView login(String memberEmail, String memberPassword, HttpSession session,RedirectAttributes redirectAttributes){
        Optional<Long> foundId = memberService.getId(memberEmail, memberPassword);
        if(foundId.isPresent()){
            session.setAttribute("id", foundId.get());
            return new RedirectView("/posts/list");
        }else{
            redirectAttributes.addFlashAttribute("loginStatus", true);
        }
        return new RedirectView("/members/login");
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/members/login");
    }

    @GetMapping("/join")
    public void goToJoin(){;}

    @PostMapping
    public RedirectView join(MemberVO memberVO, RedirectAttributes redirectAttributes){
        memberService.joinMember(memberVO);
        redirectAttributes.addFlashAttribute("join", true);
        return new RedirectView("/members/login");
    }

    @PostMapping("/checkId")
    @ResponseBody
    public boolean checkId(String memberEmail){
        log.info(memberEmail);
        return memberService.getMemberByEmail(memberEmail);
    }
}
