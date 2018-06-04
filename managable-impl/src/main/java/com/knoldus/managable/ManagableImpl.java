package com.knoldus.managable;

import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ManagableImpl implements ManagableService {

    ExternalService externalService;

    @Inject
    ManagableImpl(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    public ServiceCall<NotUsed, Integer> getData() {
        //return request -> externalService.getDataResponse().invoke().thenApply(dataResponse -> dataResponse);
        return  request -> externalService
                .getDataResponse()
                .handleResponseHeader(header -> header.status())
                .invoke();
                
    }
}