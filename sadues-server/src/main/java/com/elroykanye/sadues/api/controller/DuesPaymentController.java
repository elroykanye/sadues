package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.api.dto.DuesPaymentDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.DuesPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/dues_payment")
public class DuesPaymentController {
    private final DuesPaymentService duesPaymentService;

    @PostMapping
    public ResponseEntity<SaResponse> create(@Valid @RequestBody DuesPaymentDto duesPaymentDto) {
        return new ResponseEntity<>(duesPaymentService.create(duesPaymentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuesPaymentDto> get(@NotNull @PathVariable Long id) {
        return ResponseEntity.ok(duesPaymentService.getDto(id));
    }

    @GetMapping
    public ResponseEntity<List<DuesPaymentDto>> getAll() {
        return ResponseEntity.ok(duesPaymentService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@Valid @RequestBody DuesPaymentDto duesPaymentDto) {
        return ResponseEntity.ok(duesPaymentService.update(duesPaymentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        duesPaymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
