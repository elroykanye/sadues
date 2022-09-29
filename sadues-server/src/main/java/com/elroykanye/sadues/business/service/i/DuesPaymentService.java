package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.DuesPaymentDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.DuesPayment;

import java.util.List;

public interface DuesPaymentService {
    SaResponse create(DuesPaymentDto dto);
    DuesPayment getEntity(long id);
    DuesPaymentDto getDto(long id);
    List<DuesPayment> getAllEntities();
    List<DuesPaymentDto> getAllDto();
    SaResponse update( DuesPaymentDto dto);
    void delete(long id);
}
