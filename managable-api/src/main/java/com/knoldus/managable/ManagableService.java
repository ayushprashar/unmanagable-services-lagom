package com.knoldus.managable;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.transport.Method.GET;

public interface ManagableService extends Service {

    @Override
    default Descriptor descriptor() {
        return named("internal").withCalls(
                restCall(GET, "/api/unknown",this::getData)
        ).withAutoAcl(true);
    }

    ServiceCall<NotUsed,DataResponse> getData();
}
