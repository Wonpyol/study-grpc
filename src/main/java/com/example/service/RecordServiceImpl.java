package com.example.service;

import com.example.dto.RecordRequestDTO;
import com.example.dto.RecordResponseDTO;
import com.example.grpc.RecordProto;
import com.example.grpc.RecordServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.transaction.annotation.Transactional;

/**
 * RPC 수신부 구현체
 */

@Slf4j
@RequiredArgsConstructor
@GrpcService
public class RecordServiceImpl extends RecordServiceGrpc.RecordServiceImplBase {

    private final RecordService recordService;

    @Transactional
    @Override
    public void createRecord(
            RecordProto.RecordRequest request,
            StreamObserver<RecordProto.RecordResponse> responseObserver
    ) {
        RecordResponseDTO responseDTO = recordService.createRecord(new RecordRequestDTO(request.getWorkflowId(), request.getLaptime()));
        RecordProto.RecordResponse response = RecordProto.RecordResponse.newBuilder()
                .setRank(responseDTO.getRank())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
