package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.MembershipDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.MembershipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class MembershipController {
    private final MembershipService membershipService;

    @PostMapping
    public ResponseEntity<SaResponse> create(@Valid @RequestBody MembershipDto membershipDto) {
        return new ResponseEntity<>(membershipService.create(membershipDto), HttpStatus.CREATED);
    }

    @GetMapping("/key")
    public ResponseEntity<MembershipDto> get(@RequestParam("userId") Long userId, @RequestParam("associationId") Long associationId) {
        MembershipDto.MembershipKeyDto keyDto = new MembershipDto.MembershipKeyDto(userId, associationId);
        return ResponseEntity.ok(membershipService.getDto(keyDto));
    }

    @GetMapping
    public ResponseEntity<List<MembershipDto>> getAll() {
        return ResponseEntity.ok(membershipService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@Valid @RequestBody MembershipDto membershipDto) {
        return ResponseEntity.ok(membershipService.update(membershipDto));
    }

    @DeleteMapping("/key")
    public ResponseEntity<Void> delete(@RequestParam("userId") Long userId, @RequestParam("associationId") Long associationId) {
        MembershipDto.MembershipKeyDto keyDto = new MembershipDto.MembershipKeyDto(userId, associationId);
        membershipService.delete(keyDto);
        return ResponseEntity.noContent().build();
    }
}
