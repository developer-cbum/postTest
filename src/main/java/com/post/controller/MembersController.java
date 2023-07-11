package com.post.controller;

import com.post.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MembersController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void goToLogin(){;}

    @GetMapping("/join")
    public void goToJoin(){;}

    @PostMapping("/checkId")
    @ResponseBody
    public boolean checkId(String memberEmail){
        log.info(memberEmail);
        return memberService.getMemberByEmail(memberEmail);
    }
}
