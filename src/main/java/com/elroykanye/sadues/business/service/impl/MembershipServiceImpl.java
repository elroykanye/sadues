package com.elroykanye.sadues.business.service.impl;
import com.elroykanye.sadues.api.dto.MembershipDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.MembershipMapper;
import com.elroykanye.sadues.business.service.i.AssociationService;
import com.elroykanye.sadues.business.service.i.MembershipService;
import com.elroykanye.sadues.business.service.i.UserService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.entity.composite.MembershipKey;
import com.elroykanye.sadues.data.entity.relation.Membership;
import com.elroykanye.sadues.data.enums.Position;
import com.elroykanye.sadues.data.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {
    private final String entityName = EntityName.MEMBER;
    private final MembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;
    private final AssociationService associationService;
    private final UserService userService;

    
    @Override
    public SaResponse create( MembershipDto dto) {
        Membership member = membershipMapper.memberDtoToMember(dto);
        Association association = associationService.getEntity(dto.key().associationId());
        User user = userService.getEntity(dto.key().userId());
        AcademicYear currentYear = association.getUniversity().getCurrentYear();

        member.setAssociation(association);
        member.setUser(user);
        member.setPosition(dto.position() == null ? Position.MEMBER : dto.position());
        member.setJoinedYear(currentYear.getName()); // todo impl functionality for retrieving current year name
        member.setKey(new MembershipKey(user.getId(), association.getId()));
        member = membershipRepository.save(member);

        var memberships = new ArrayList<Membership>();
        var currAssoc = association;
        while (currAssoc.getHeadAssociation() != null) {
            Association headAssoc = currAssoc.getHeadAssociation();
            MembershipKey membershipKey = new MembershipKey(user.getId(), headAssoc.getId());
            Membership membership = new Membership(membershipKey, currentYear.getName(), Position.MEMBER, new ArrayList<>(), user, headAssoc);
            memberships.add(membership);
            currAssoc = headAssoc;
        }
        membershipRepository.saveAll(memberships);

        return new SaResponse(member.getKey(), ResponseMessage.SUCCESS.created(entityName));
    }



    
    @Override
    public Membership getEntity(MembershipDto.MemberKeyDto keyDto) {
        MembershipKey key = new MembershipKey(keyDto.userId(), keyDto.associationId());
        return membershipRepository.findById(key).orElseThrow();
    }

    
    @Override
    public MembershipDto getDto(MembershipDto.MemberKeyDto keyDto) {
        return membershipMapper.memberToMemberDto(getEntity(keyDto));
    }

    
    @Override
    public List<Membership> getAllEntities() {
        return membershipRepository.findAll();
    }

    
    @Override
    public List<MembershipDto> getAllDto() {
        return getAllEntities().stream().map(membershipMapper::memberToMemberDto).toList();
    }

    
    @Override
    public SaResponse update( MembershipDto dto) {
        Membership membership = getEntity(dto.key());

        membership.setPosition(membership.getPosition());
        if (!Objects.equals(membership.getAssociation().getId(), dto.key().associationId())) {
            Association association = associationService.getEntity(dto.key().associationId());
            membership.setAssociation(association);
        }
        if (!Objects.equals(membership.getUser().getId(), dto.key().userId())) {
            User user = userService.getEntity(dto.key().userId());
            membership.setUser(user);
        }

        membership = membershipRepository.save(membership);
        return new SaResponse(membership.getKey(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(MembershipDto.MemberKeyDto keyDto) {
        Membership membership = getEntity(keyDto);
        membershipRepository.delete(membership);
    }
}
