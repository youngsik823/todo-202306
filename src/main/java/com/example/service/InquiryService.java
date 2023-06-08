package com.example.service;

import com.example.dto.request.InquiryCreateRequestDTO;
import com.example.dto.page.PageDTO;
import com.example.dto.page.PageResponseDTO;
import com.example.dto.response.InquiryDetailResponseDTO;
import com.example.dto.response.InquiryListResponseDTO;
import com.example.entity.Answer;
import com.example.entity.Inquiry;
import com.example.repository.AnswerRepository;
import com.example.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class InquiryService {

    private final AnswerRepository answerRepository;
    private final InquiryRepository inquiryRepository;

    public InquiryListResponseDTO getInquiries(PageDTO dto) {

        PageRequest page = PageRequest.of(
                dto.getPage() - 1,
                dto.getSize(),
                Sort.by("inquiryDateTime").descending()
        );

        Page<Inquiry> inquiries = inquiryRepository.findAll(page);

        List<Inquiry> inquiryList = inquiries.getContent();
        List<InquiryDetailResponseDTO> detailList = inquiryList.stream()
                .map(inquiry -> new InquiryDetailResponseDTO(inquiry))
                .collect(Collectors.toList());

        return InquiryListResponseDTO.builder()
                .count(inquiryList.size())
                .pageInfo(new PageResponseDTO<Inquiry>(inquiries))
                .inquiries(detailList)
                .build();
    }

    public InquiryDetailResponseDTO getDetail(int inquiryId) {
        Inquiry inquiryEntity = getInquiry(inquiryId);

        return new InquiryDetailResponseDTO(inquiryEntity);
    }
    private Inquiry getInquiry(int inquiryId) {
        Inquiry inquiryEntity = inquiryRepository.findById(inquiryId)
                .orElseThrow(
                        () -> new RuntimeException(
                                inquiryId + "번 문의게시물이 존재하지 않습니다."
                        )
                );
        return inquiryEntity;
    }

    public InquiryDetailResponseDTO insert(final InquiryCreateRequestDTO dto)
        throws RuntimeException {

        Inquiry saved = inquiryRepository.save(dto);


        return null;
    }


}
