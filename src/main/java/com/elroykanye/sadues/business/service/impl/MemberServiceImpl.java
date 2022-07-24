package com.elroykanye.sadues.business.service.impl;
import com.elroykanye.sadues.api.dto.ExecutiveDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.ExecutiveMapper;
import com.elroykanye.sadues.business.service.i.AssociationService;
import com.elroykanye.sadues.business.service.i.ExecutiveService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.Executive;
import com.elroykanye.sadues.data.repository.ExecutiveRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExecutiveServiceImpl implements ExecutiveService {
    private final String entityName = EntityName.EXECUTIVE;
    private final ExecutiveRepository executiveRepository;
    private final ExecutiveMapper executiveMapper;
    private final AssociationService associationService;

    @NotNull
    @Override
    public SaResponse create(@NotNull ExecutiveDto executiveDto) {
        Executive executive = executiveMapper.executiveDtoToExecutive(executiveDto);
        Association association = associationService.getEntity(executiveDto.associationId());
        executive.setId(null);
        executive.setAssociation(association);

        executive = executiveRepository.save(executive);
        return new SaResponse(executive.getId(), ResponseMessage.SUCCESS.created(entityName));
    }

    @NotNull
    @Override
    public Executive getEntity(long id) {
        return executiveRepository.findById(id).orElseThrow();
    }

    @NotNull
    @Override
    public ExecutiveDto getDto(long id) {
        return executiveMapper.executiveToExecutiveDto(getEntity(id));
    }

    @NotNull
    @Override
    public List<Executive> getAllEntities() {
        return executiveRepository.findAll();
    }

    @NotNull
    @Override
    public List<ExecutiveDto> getAllDto() {
        return getAllEntities().stream().map(executiveMapper::executiveToExecutiveDto).toList();
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull ExecutiveDto executiveDto) {
        Executive executive = getEntity(executiveDto.id());
        executive.setName(executive.getName());
        executive.setPosition(executive.getPosition());
        if (!Objects.equals(executive.getAssociation().getId(), executiveDto.associationId())) {
            Association association = associationService.getEntity(executiveDto.associationId());
            executive.setAssociation(association);
        }
        executive = executiveRepository.save(executive);
        return new SaResponse(executive.getId(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(long id) {
        executiveRepository.deleteById(id);
    }
}
