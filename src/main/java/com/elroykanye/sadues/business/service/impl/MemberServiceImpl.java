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
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

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

    @NotNull
    @Override
    public SaResponse create(@NotNull MemberDto memberDto) {
        Member member = memberMapper.memberDtoToMember(memberDto);
        Association association = associationService.getEntity(memberDto.key().associationId());
        User user = userService.getEntity(memberDto.key().userId());

        member.setAssociation(association);
        member.setUser(user);
        member.setPosition(memberDto.position() == null ? Position.MEMBER : memberDto.position());
        member.setJoinedYear(association.getUniversity().getCurrentYear().getName()); // todo impl functionality for retrieving current year name
        member.setKey(new MemberKey(user.getId(), association.getId()));
        member = memberRepository.save(member);
        return new SaResponse(member.getKey(), ResponseMessage.SUCCESS.created(entityName));
    }



    @NotNull
    @Override
    public Member getEntity(long userId, long associationId) {
        MemberKey key = new MemberKey(userId, associationId);
        return memberRepository.findById(key).orElseThrow();
    }

    @NotNull
    @Override
    public MemberDto getDto(long userId, long associationId) {
        return memberMapper.memberToMemberDto(getEntity(userId, associationId));
    }

    @NotNull
    @Override
    public List<Member> getAllEntities() {
        return memberRepository.findAll();
    }

    @NotNull
    @Override
    public List<MemberDto> getAllDto() {
        return getAllEntities().stream().map(memberMapper::memberToMemberDto).toList();
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull MemberDto memberDto) {
        Member member = getEntity(memberDto.key().userId(), memberDto.key().associationId());

        member.setPosition(member.getPosition());
        if (!Objects.equals(member.getAssociation().getId(), memberDto.key().associationId())) {
            Association association = associationService.getEntity(memberDto.key().associationId());
            member.setAssociation(association);
        }
        if (!Objects.equals(member.getUser().getId(), memberDto.key().userId())) {
            User user = userService.getEntity(memberDto.key().userId());
            member.setUser(user);
        }

        member = memberRepository.save(member);
        return new SaResponse(member.getKey(), ResponseMessage.SUCCESS.updated(entityName));
    }

    @Override
    public void delete(long userId, long associationId) {
        Member member = getEntity(userId, associationId);
        memberRepository.delete(member);
    }
}
