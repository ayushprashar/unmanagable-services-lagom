package com.knoldus.managable;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;

public interface ExternalService extends Service{
    @Override
    default Descriptor descriptor() {
        return named("external").withCalls()
    }
}
/**
 *
 * public interface ExternalService extends Service {

 ServiceCall<NotUsed, DataResponse> getDataResponse();

 @Override
 default Descriptor descriptor() {
 return named("external").withCalls(
 restCall(GET, "/api/users/2", this::getDataResponse)
 ).withAutoAcl(true);
 }


 }

 */
