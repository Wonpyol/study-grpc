package com.example.client;


import com.example.grpc.RecordProto;
import com.example.grpc.RecordServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class GrpcRecordClient {
    private final RecordServiceGrpc.RecordServiceBlockingStub blockingStub;

    public GrpcRecordClient() {
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        blockingStub = RecordServiceGrpc.newBlockingStub(channel);
    }

    public RecordProto.RecordResponse createRecord(RecordProto.RecordRequest request) {
        return blockingStub.createRecord(request);
    }
}
