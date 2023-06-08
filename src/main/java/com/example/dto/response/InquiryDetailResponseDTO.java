package com.example.dto.response;

import com.example.entity.Answer;
import com.example.entity.Inquiry;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquiryDetailResponseDTO {

    private int inquiryId;
    private String inquiryDetails;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime inquiryDateTime;
    private Answer answer;

    public InquiryDetailResponseDTO(Inquiry inquiry) {
        this.inquiryId = inquiry.getInquiryId();
        this.inquiryDetails = inquiry.getInquiryDetails();
        this.inquiryDateTime = inquiry.getInquiryDateTime();
        this.answer = inquiry.getAnswer();
    }
}

