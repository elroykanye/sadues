package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.MemberDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<SaResponse> create(@Valid @RequestBody MemberDto memberDto) {
        return new ResponseEntity<>(memberService.create(memberDto), HttpStatus.CREATED);
    }

    @GetMapping("/key")
    public ResponseEntity<MemberDto> get(@RequestParam("userId") Long userId, @RequestParam("associationId") Long associationId) {
        return ResponseEntity.ok(memberService.getDto(userId, associationId));
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAll() {
        return ResponseEntity.ok(memberService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@Valid @RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(memberService.update(memberDto));
    }

    @DeleteMapping("/key")
    public ResponseEntity<Void> delete(@RequestParam("userId") Long userId, @RequestParam("associationId") Long associationId) {
        memberService.delete(userId, associationId);
        return ResponseEntity.ok().build();
    }
}
