package com.knoldus.managable;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class ManagableModule extends AbstractModule implements ServiceGuiceSupport{
    @Override
    protected void configure() {
        bindService(ManagableService.class,ManagableImpl.class);
        bindClient(ExternalService.class);
    }
}

