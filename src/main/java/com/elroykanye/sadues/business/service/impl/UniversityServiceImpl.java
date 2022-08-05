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
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final String entityName = EntityName.UNIVERSITY;
    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;
    private final AcademicYearService academicYearService;

    @NotNull
    @Override
    public SaResponse create(@NotNull UniversityDto universityDto) {
        University university = universityMapper.universityDtoToUniversity(universityDto);
        if (universityDto.currentYearId() != null) {
            AcademicYear academicYear = academicYearService.getEntity(universityDto.currentYearId());
            university.setCurrentYear(academicYear);
        }
        university.setId(null);
        university.setApproved(false);
        university = universityRepository.save(university);
        return new SaResponse(university.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    @NotNull
    @Override
    public University getEntity(long id) {
        return universityRepository.findById(id).orElseThrow();
    }

    @NotNull
    @Override
    public UniversityDto getDto(long id) {
        return universityMapper.universityToUniversityDto(getEntity(id));
    }

    @NotNull
    @Override
    public List<University> getAllEntities() {
        return universityRepository.findAll();
    }

    @NotNull
    @Override
    public List<UniversityDto> getAllDto() {
        return getAllEntities().stream().map(universityMapper::universityToUniversityDto).toList();
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull UniversityDto universityDto) {
        University university = getEntity(universityDto.id());
        if (universityDto.currentYearId() != null) {
            AcademicYear academicYear = academicYearService.getEntity(universityDto.currentYearId());
            university.setCurrentYear(academicYear);
            System.out.println(university);
        }

        university.setApproved(universityDto.approved() != null && universityDto.approved());
        university.setLocation(universityDto.location());
        university.setName(universityDto.name());

        university = universityRepository.save(university);
        return new SaResponse(university.getId(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(long id) {
        University university = getEntity(id);
        universityRepository.delete(university);
    }
}
