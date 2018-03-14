package com.knoldus.managable;

import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;

public class ManagableImpl implements ManagableService {

    ExternalService externalService;

    @Inject
    ManagableImpl(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    public ServiceCall<NotUsed, DataResponse> getData() {
        return request -> externalService.getDataResponse().invoke().thenApply(dataResponse -> dataResponse);
    }
}