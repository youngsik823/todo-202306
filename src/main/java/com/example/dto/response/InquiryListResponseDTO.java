package com.example.dto.response;

import com.example.dto.page.PageResponseDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquiryListResponseDTO {
    private int count;
    private PageResponseDTO pageInfo;
    private List<InquiryDetailResponseDTO> inquiries;

}
