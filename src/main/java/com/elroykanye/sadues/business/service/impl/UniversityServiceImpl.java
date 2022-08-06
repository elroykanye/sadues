package com.elroykanye.sadues.business.service.impl;
import com.elroykanye.sadues.api.dto.UniversityDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.UniversityMapper;
import com.elroykanye.sadues.business.service.i.AcademicYearService;
import com.elroykanye.sadues.business.service.i.UniversityService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.University;
import com.elroykanye.sadues.data.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final String entityName = EntityName.UNIVERSITY;
    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;
    private final AcademicYearService academicYearService;

    
    @Override
    public SaResponse create( UniversityDto dto) {
        University university = universityMapper.universityDtoToUniversity(dto);
        if (dto.currentYearId() != null) {
            AcademicYear academicYear = academicYearService.getEntity(dto.currentYearId());
            university.setCurrentYear(academicYear);
        }
        university.setId(null);
        university.setApproved(false);
        university = universityRepository.save(university);
        return new SaResponse(university.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    
    @Override
    public University getEntity(long id) {
        return universityRepository.findById(id).orElseThrow();
    }

    
    @Override
    public UniversityDto getDto(long id) {
        return universityMapper.universityToUniversityDto(getEntity(id));
    }

    
    @Override
    public List<University> getAllEntities() {
        return universityRepository.findAll();
    }

    
    @Override
    public List<UniversityDto> getAllDto() {
        return getAllEntities().stream().map(universityMapper::universityToUniversityDto).toList();
    }

    
    @Override
    public SaResponse update( UniversityDto dto) {
        University university = getEntity(dto.id());
        if (dto.currentYearId() != null) {
            AcademicYear academicYear = academicYearService.getEntity(dto.currentYearId());
            university.setCurrentYear(academicYear);
            System.out.println(university);
        }

        university.setApproved(dto.approved() != null && dto.approved());
        university.setLocation(dto.location());
        university.setName(dto.name());

        university = universityRepository.save(university);
        return new SaResponse(university.getId(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(long id) {
        University university = getEntity(id);
        universityRepository.delete(university);
    }
}
