package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "record")
@Getter
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long workflowId;
    private Long laptime;
    private Integer rank;

    public static RecordEntity create(Long workflowId, Long laptime, Integer rank) {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.workflowId = workflowId;
        recordEntity.laptime = laptime;
        recordEntity.rank = rank;
        return recordEntity;
    }
}
