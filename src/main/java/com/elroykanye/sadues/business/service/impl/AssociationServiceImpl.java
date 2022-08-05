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
import org.jetbrains.annotations.NotNull;
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

    @NotNull
    @Override
    public SaResponse create(@NotNull AssociationDto associationDto) {
        Association association = associationMapper.associationDtoToAssociation(associationDto);
        University university = universityService.getEntity(associationDto.universityId());
        association.setId(null);
        association.setUniversity(university);

        if(associationDto.headAssociationId() == null) {
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
            Association headAssociation = getEntity(associationDto.headAssociationId());
            association.setHeadAssociation(headAssociation);
            association.setType(AssociationType.SUB);
        }

        association = associationRepository.save(association);
        return new SaResponse(association.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    @NotNull
    @Override
    public Association getEntity(long id) {
        return associationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @NotNull
    @Override
    public AssociationDto getDto(long id) {
        return associationMapper.associationToAssociationDto(getEntity(id));
    }

    @NotNull
    @Override
    public List<Association> getAllEntities() {
        return associationRepository.findAll();
    }

    @NotNull
    @Override
    public List<AssociationDto> getAllDto() {
        return getAllEntities().stream().map(associationMapper::associationToAssociationDto).toList();
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull AssociationDto associationDto) {
        Association association = getEntity(associationDto.id());
        association.setName(associationDto.name());
        if (associationDto.headAssociationId() == null) {
            association.setType(AssociationType.MAIN);
        } else {
            Association headAssociation = getEntity(associationDto.headAssociationId());
            association.setHeadAssociation(headAssociation);
            association.setType(AssociationType.SUB);
        }
        if (!Objects.equals(association.getUniversity().getId(), associationDto.universityId())) {
            University university = universityService.getEntity(associationDto.universityId());
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
