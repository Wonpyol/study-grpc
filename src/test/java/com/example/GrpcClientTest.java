package com.example;


import com.example.client.GrpcRecordClient;
import com.example.grpc.RecordProto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GrpcClientTest {
    @Autowired
    private GrpcRecordClient grpcRecordClient;

    @Test
    void 송수신() {
        //given
        RecordProto.RecordRequest request = RecordProto.RecordRequest.newBuilder()
                .setWorkflowId(1L)
                .setLaptime(73000)
                .build();
        //when
        RecordProto.RecordResponse record = grpcRecordClient.createRecord(request);


        Assertions.assertEquals(99, record.getRank());
        //then
    }



}
