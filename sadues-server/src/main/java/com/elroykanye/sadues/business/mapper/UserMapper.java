package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    @Mapping(source = "university.id", target = "universityId")
    UserDto userToUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserDto(UserDto userDto, @MappingTarget User user);

    default Set<Long> associationsToAssociationIds(Set<Association> associations) {
        return associations.stream().map(Association::getId).collect(Collectors.toSet());
    }
}
