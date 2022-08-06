package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.api.dto.DuesInfoDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.DuesInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/dues_info")
public class DuesInfoController {
    private final DuesInfoService duesInfoService;

    @PostMapping
    public ResponseEntity<SaResponse> create(@Valid @RequestBody DuesInfoDto duesInfoDto) {
        return new ResponseEntity<>(duesInfoService.create(duesInfoDto), HttpStatus.CREATED);
    }

    @GetMapping("/key")
    public ResponseEntity<DuesInfoDto> get(@RequestParam Long academicYearId, @RequestParam Long associationId) {
        DuesInfoDto.DuesInfoKeyDto keyDto = new DuesInfoDto.DuesInfoKeyDto(academicYearId, associationId);
        return ResponseEntity.ok(duesInfoService.getDto(keyDto));
    }

    @GetMapping
    public ResponseEntity<List<DuesInfoDto>> getAll() {
        return ResponseEntity.ok(duesInfoService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@Valid @RequestBody DuesInfoDto duesInfoDto) {
        return ResponseEntity.ok(duesInfoService.update(duesInfoDto));
    }

    @DeleteMapping("/key")
    public ResponseEntity<Void> delete(@RequestParam Long academicYearId, @RequestParam Long associationId) {
        DuesInfoDto.DuesInfoKeyDto keyDto = new DuesInfoDto.DuesInfoKeyDto(academicYearId, associationId);
        duesInfoService.delete(keyDto);
        return ResponseEntity.noContent().build();
    }
}
