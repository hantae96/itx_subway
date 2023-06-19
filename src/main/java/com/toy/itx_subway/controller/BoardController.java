package com.toy.itx_subway.controller;


import com.toy.itx_subway.service.ItxService;
import com.toy.itx_subway.service.SubwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final SubwayService subwayService;
    private final ItxService itxService;

    @GetMapping("/list")
    // 리다이렉트해서 넘어온 데이터는 자동으로 view에 전달해줌
    public String viewList(){
        return "list";
    }

    @GetMapping("/input")
    public String input(){
        return "input";
    }

    @PostMapping("input")
    public String getStation(@RequestParam String station,RedirectAttributes redirectAttributes){
        LocalTime departTime  = itxService.check(station);

        redirectAttributes.addFlashAttribute("data", departTime);
        return "redirect:/list";
    }
}
