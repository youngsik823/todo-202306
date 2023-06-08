package com.example.repository;

import com.example.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository
    extends JpaRepository<Inquiry, Integer> {

}
