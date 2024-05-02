package com.example.demo;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@GrpcService
public class DemoController extends HelloServiceGrpc.HelloServiceImplBase{


    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        new Thread(new MyThread()).start();
        HelloResponse reply = HelloResponse.newBuilder()
                .setGreeting("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
