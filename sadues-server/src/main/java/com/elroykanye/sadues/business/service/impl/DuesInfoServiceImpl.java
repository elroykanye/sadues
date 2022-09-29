package com.elroykanye.sadues.business.service.impl;

import com.elroykanye.sadues.api.dto.DuesInfoDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.DuesInfoMapper;
import com.elroykanye.sadues.business.service.i.AcademicYearService;
import com.elroykanye.sadues.business.service.i.AssociationService;
import com.elroykanye.sadues.business.service.i.DuesInfoService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.composite.DuesInfoKey;
import com.elroykanye.sadues.data.entity.relation.DuesInfo;
import com.elroykanye.sadues.data.repository.DuesInfoRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuesInfoServiceImpl implements DuesInfoService {
    private final String entityName = EntityName.DUES_INFO;
    private final DuesInfoRepository duesInfoRepository;
    private final DuesInfoMapper duesInfoMapper;
    private final AcademicYearService academicYearService;
    private final AssociationService associationService;

    @Override
    public SaResponse create(DuesInfoDto dto) {
        DuesInfo duesInfo = saveDuesInfo(dto);
        return new SaResponse(duesInfo.getKey(), ResponseMessage.SUCCESS.created(entityName));
    }

    @Override
    public DuesInfo getEntity(DuesInfoDto.DuesInfoKeyDto keyDto) {
        DuesInfoKey key = new DuesInfoKey(keyDto.academicYearId(), keyDto.associationId());
        return duesInfoRepository.findById(key).orElseThrow();
    }

    @Override
    public DuesInfoDto getDto(DuesInfoDto.DuesInfoKeyDto keyDto) {
        return duesInfoMapper.duesInfoToDuesInfoDto(getEntity(keyDto));
    }

    @Override
    public List<DuesInfo> getAllEntities() {
        return duesInfoRepository.findAll();
    }

    @Override
    public List<DuesInfoDto> getAllDto() {
        return getAllEntities().stream().map(duesInfoMapper::duesInfoToDuesInfoDto).toList();
    }

    @Override
    public SaResponse update(DuesInfoDto dto) {
        DuesInfo duesInfo = saveDuesInfo(dto);
        return new SaResponse(duesInfo.getKey(), ResponseMessage.SUCCESS.updated(entityName));
    }

    private @NotNull DuesInfo saveDuesInfo(DuesInfoDto dto) {
        DuesInfo duesInfo = duesInfoMapper.duesInfoDtoToDuesInfo(dto);
        DuesInfoKey key = new DuesInfoKey(dto.key().academicYearId(), dto.key().associationId());
        AcademicYear academicYear = academicYearService.getEntity(dto.key().academicYearId());
        Association association = associationService.getEntity(dto.key().associationId());
        duesInfo.setKey(key);
        duesInfo.setAssociation(association);
        duesInfo.setAcademicYear(academicYear);
        duesInfo = duesInfoRepository.save(duesInfo);
        return duesInfo;
    }

    @Override
    public void delete(DuesInfoDto.DuesInfoKeyDto keyDto) {
        duesInfoRepository.deleteById(new DuesInfoKey(keyDto.academicYearId(), keyDto.associationId()));
    }
}
