package com.elroykanye.sadues.business.service.impl;

import com.elroykanye.sadues.api.dto.DuesInfoDto;
import com.elroykanye.sadues.api.dto.DuesPaymentDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.DuesPaymentMapper;
import com.elroykanye.sadues.business.service.i.DuesInfoService;
import com.elroykanye.sadues.business.service.i.DuesPaymentService;
import com.elroykanye.sadues.business.service.i.MemberService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.DuesPayment;
import com.elroykanye.sadues.data.entity.relation.DuesInfo;
import com.elroykanye.sadues.data.entity.relation.Member;
import com.elroykanye.sadues.data.enums.PaymentStatus;
import com.elroykanye.sadues.data.repository.DuesPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DuesPaymentServiceImpl implements DuesPaymentService {
    private final String entityName = EntityName.DUES_PAYMENT;
    private final DuesPaymentRepository duesPaymentRepository;
    private final DuesPaymentMapper duesPaymentMapper;
    private final MemberService memberService;
    private final DuesInfoService duesInfoService;

    public void checkDuesPayment(DuesPaymentDto dto) {
        Member member = memberService.getEntity(dto.memberKey());
        AcademicYear currentAcademicYear = member.getAssociation().getUniversity().getCurrentYear();
        DuesInfo duesInfo = duesInfoService.getEntity(
                new DuesInfoDto.DuesInfoKeyDto(currentAcademicYear.getId(), dto.associationId())
        );

        final Double maxAmount = duesInfo.getAmount();
        final Double toPayAmount = dto.amount();
        final Double[] paidAmount = {0D};

        member.getDuesPayments().stream().filter(
                duesPayment -> Objects.equals(duesPayment.getMember().getAssociation().getId(), dto.associationId())
        ).forEach(duesPayment -> paidAmount[0] = paidAmount[0] + duesPayment.getAmount());


        System.out.println("Max amount: " + maxAmount);
        System.out.println("To pay amount: " + toPayAmount);
        System.out.println("Paid amount: " + paidAmount[0]);

        if ((toPayAmount + paidAmount[0]) > maxAmount ) {
            String message = "Paid amount exceeds total amount. Your remaining amount to pay is XAF " + (maxAmount - paidAmount[0]);
            throw new IllegalStateException(message);
        }
        if (toPayAmount % 100 != 0) {
            String message = "You can only payments in multiples of XAF 100";
            throw new IllegalStateException(message);
        }
    }

    @Override
    public SaResponse create(DuesPaymentDto dto) {
        checkDuesPayment(dto);

        Member member = memberService.getEntity(dto.memberKey());
        DuesPayment duesPayment = duesPaymentMapper.duesPaymentDtoToDuesPayment(dto);

        duesPayment.setMember(member);
        duesPayment.setDate(new Date());
        duesPayment.setStatus(PaymentStatus.PENDING);
        duesPayment = duesPaymentRepository.save(duesPayment);

        return new SaResponse(duesPayment.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    @Override
    public DuesPayment getEntity(long id) {
        return duesPaymentRepository.findById(id).orElseThrow();
    }

    @Override
    public DuesPaymentDto getDto(long id) {
        return duesPaymentMapper.duesPaymentToDuesPaymentDto(getEntity(id));
    }

    @Override
    public List<DuesPayment> getAllEntities() {
        return duesPaymentRepository.findAll();
    }

    @Override
    public List<DuesPaymentDto> getAllDto() {
        return getAllEntities().stream().map(duesPaymentMapper::duesPaymentToDuesPaymentDto).toList();
    }

    @Override
    public SaResponse update(DuesPaymentDto dto) {
        throw new IllegalStateException("Wait abit");
    }

    @Override
    public void delete(long id) {
        duesPaymentRepository.deleteById(id);
    }
}
