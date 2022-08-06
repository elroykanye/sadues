package com.elroykanye.sadues.business.service.impl;
import com.elroykanye.sadues.api.dto.MemberDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.MemberMapper;
import com.elroykanye.sadues.business.service.i.AcademicYearService;
import com.elroykanye.sadues.business.service.i.AssociationService;
import com.elroykanye.sadues.business.service.i.MemberService;
import com.elroykanye.sadues.business.service.i.UserService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.entity.composite.MemberKey;
import com.elroykanye.sadues.data.entity.relation.Member;
import com.elroykanye.sadues.data.enums.Position;
import com.elroykanye.sadues.data.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final String entityName = EntityName.MEMBER;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final AssociationService associationService;
    private final UserService userService;

    
    @Override
    public SaResponse create( MemberDto dto) {
        Member member = memberMapper.memberDtoToMember(dto);
        Association association = associationService.getEntity(dto.key().associationId());
        User user = userService.getEntity(dto.key().userId());
        AcademicYear currentYear = association.getUniversity().getCurrentYear();

        member.setAssociation(association);
        member.setUser(user);
        member.setPosition(dto.position() == null ? Position.MEMBER : dto.position());
        member.setJoinedYear(currentYear.getName()); // todo impl functionality for retrieving current year name
        member.setKey(new MemberKey(user.getId(), association.getId()));
        member = memberRepository.save(member);

        var memberships = new ArrayList<Member>();
        var currAssoc = association;
        while (currAssoc.getHeadAssociation() != null) {
            Association headAssoc = currAssoc.getHeadAssociation();
            MemberKey memberKey = new MemberKey(user.getId(), headAssoc.getId());
            Member membership = new Member(memberKey, currentYear.getName(), Position.MEMBER, new ArrayList<>(), user, headAssoc);
            memberships.add(membership);
            currAssoc = headAssoc;
        }
        memberRepository.saveAll(memberships);

        return new SaResponse(member.getKey(), ResponseMessage.SUCCESS.created(entityName));
    }



    
    @Override
    public Member getEntity(MemberDto.MemberKeyDto keyDto) {
        MemberKey key = new MemberKey(keyDto.userId(), keyDto.associationId());
        return memberRepository.findById(key).orElseThrow();
    }

    
    @Override
    public MemberDto getDto(MemberDto.MemberKeyDto keyDto) {
        return memberMapper.memberToMemberDto(getEntity(keyDto));
    }

    
    @Override
    public List<Member> getAllEntities() {
        return memberRepository.findAll();
    }

    
    @Override
    public List<MemberDto> getAllDto() {
        return getAllEntities().stream().map(memberMapper::memberToMemberDto).toList();
    }

    
    @Override
    public SaResponse update( MemberDto dto) {
        Member member = getEntity(dto.key());

        member.setPosition(member.getPosition());
        if (!Objects.equals(member.getAssociation().getId(), dto.key().associationId())) {
            Association association = associationService.getEntity(dto.key().associationId());
            member.setAssociation(association);
        }
        if (!Objects.equals(member.getUser().getId(), dto.key().userId())) {
            User user = userService.getEntity(dto.key().userId());
            member.setUser(user);
        }

        member = memberRepository.save(member);
        return new SaResponse(member.getKey(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(MemberDto.MemberKeyDto keyDto) {
        Member member = getEntity(keyDto);
        memberRepository.delete(member);
    }
}
