package com.elroykanye.sadues.business.service.impl;
import com.elroykanye.sadues.api.dto.AssociationDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.AssociationMapper;
import com.elroykanye.sadues.business.service.i.AssociationService;
import com.elroykanye.sadues.business.service.i.UniversityService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.University;
import com.elroykanye.sadues.data.enums.AssociationType;
import com.elroykanye.sadues.data.repository.AssociationRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AssociationServiceImpl implements AssociationService {
    private final String entityName = EntityName.ASSOCIATION;
    private final AssociationRepository associationRepository;
    private final AssociationMapper associationMapper;
    private final UniversityService universityService;

    
    @Override
    public SaResponse create( AssociationDto dto) {
        Association association = associationMapper.associationDtoToAssociation(dto);
        University university = universityService.getEntity(dto.universityId());
        association.setId(null);
        association.setUniversity(university);

        if(dto.headAssociationId() == null) {
            Association mainAssociation = associationRepository.findByUniversityAndType(university, AssociationType.MAIN).orElseGet(
                    () -> {
                        var mainAssoc = Association.builder()
                                .name(String.format("%s Student Association", university.getName()))
                                .type(AssociationType.MAIN)
                                .university(university)
                                .id(null)
                                .build();
                        return associationRepository.save(mainAssoc);
                    }
            );
            association.setHeadAssociation(mainAssociation);
            association.setType(AssociationType.HEAD);
        } else {
            Association headAssociation = getEntity(dto.headAssociationId());
            association.setHeadAssociation(headAssociation);
            association.setType(AssociationType.SUB);
        }

        association = associationRepository.save(association);
        return new SaResponse(association.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    
    @Override
    public Association getEntity(long id) {
        return associationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    
    @Override
    public AssociationDto getDto(long id) {
        return associationMapper.associationToAssociationDto(getEntity(id));
    }

    
    @Override
    public List<Association> getAllEntities() {
        return associationRepository.findAll();
    }

    
    @Override
    public List<AssociationDto> getAllDto() {
        return getAllEntities().stream().map(associationMapper::associationToAssociationDto).toList();
    }

    
    @Override
    public SaResponse update( AssociationDto dto) {
        Association association = getEntity(dto.id());
        association.setName(dto.name());
        if (dto.headAssociationId() == null) {
            association.setType(AssociationType.MAIN);
        } else {
            Association headAssociation = getEntity(dto.headAssociationId());
            association.setHeadAssociation(headAssociation);
            association.setType(AssociationType.SUB);
        }
        if (!Objects.equals(association.getUniversity().getId(), dto.universityId())) {
            University university = universityService.getEntity(dto.universityId());
            association.setUniversity(university);
        }
        association = associationRepository.save(association);
        return new SaResponse(association.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    @Override
    public void delete(long id) {
        associationRepository.deleteById(id);
    }
}
