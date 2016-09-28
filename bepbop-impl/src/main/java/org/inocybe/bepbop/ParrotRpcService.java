/*
 * Copyright © 2016 Inocybe Technologies and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.inocybe.bepbop;

import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Future;
import org.opendaylight.yang.gen.v1.urn.inocybe.opendaylight.summit.bepbop.rev160926.BepbopService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by adetalhouet on 2016-09-26.
 */
public class ParrotRpcService implements BepbopService {

    private static final Logger LOG = LoggerFactory.getLogger(ParrotRpcService.class);

    private final Drone drone;

    public ParrotRpcService(final Drone drone) {
        this.drone = drone;
    }

    @Override
    public Future<RpcResult<Void>> takeOff() {

        LOG.info("Taking off");

        drone.takeoff();

        return Futures.immediateFuture(RpcResultBuilder.<Void>success().build());
    }

    @Override
    public Future<RpcResult<Void>> land() {

        LOG.info("Landing");

        drone.land();

        return Futures.immediateFuture(RpcResultBuilder.<Void>success().build());
    }
}
