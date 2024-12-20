package com.example.service;

import com.example.dto.RecordRequestDTO;
import com.example.dto.RecordResponseDTO;
import com.example.entity.RecordEntity;
import com.example.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecordService {
    private final RecordRepository recordRepository;

    public RecordResponseDTO createRecord(RecordRequestDTO request) {
        recordRepository.save(RecordEntity.create(request.getWorkflowId(), request.getLaptime(), 0));
        return new RecordResponseDTO(99);
    }
}
