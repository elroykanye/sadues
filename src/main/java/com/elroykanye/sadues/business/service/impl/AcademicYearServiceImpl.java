package com.elroykanye.sadues.business.service.impl;
import com.elroykanye.sadues.api.dto.AcademicYearDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.AcademicYearMapper;
import com.elroykanye.sadues.business.service.i.AcademicYearService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.repository.AcademicYearRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicYearServiceImpl implements AcademicYearService {
    private final String entityName = EntityName.ACADEMIC_YEAR;
    private final AcademicYearRepository academicYearRepository;
    private final AcademicYearMapper academicYearMapper;
    
    @NotNull
    @Override
    public SaResponse create(@NotNull AcademicYearDto academicYearDto) {
        AcademicYear academicYear = academicYearMapper.academicYearDtoToAcademicYear(academicYearDto);
        academicYear.setId(null);
        academicYear = academicYearRepository.save(academicYear);
        return new SaResponse(academicYear.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    @NotNull
    @Override
    public AcademicYear getEntity(long id) {
        return academicYearRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @NotNull
    @Override
    public AcademicYearDto getDto(long id) {
        return academicYearMapper.academicYearToAcademicYearDto(getEntity(id));
    }

    @NotNull
    @Override
    public List<AcademicYear> getAllEntities() {
        return academicYearRepository.findAll();
    }

    @NotNull
    @Override
    public List<AcademicYearDto> getAllDto() {
        return getAllEntities().stream().map(academicYearMapper::academicYearToAcademicYearDto).toList();
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull AcademicYearDto academicYearDto) {
        AcademicYear academicYear = getEntity(academicYearDto.id());
        academicYear.setName(academicYearDto.name());
        academicYear = academicYearRepository.save(academicYear);
        return new SaResponse(academicYear.getId(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(long id) {
        if (academicYearRepository.existsById(id)) {
            academicYearRepository.deleteById(id);
        }
    }
}
