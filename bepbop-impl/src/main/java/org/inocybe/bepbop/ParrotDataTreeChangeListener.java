/*
 * Copyright © 2016 Inocybe Technologies and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.inocybe.bepbop;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataObjectModification;
import org.opendaylight.controller.md.sal.binding.api.DataTreeChangeListener;
import org.opendaylight.controller.md.sal.binding.api.DataTreeIdentifier;
import org.opendaylight.controller.md.sal.binding.api.DataTreeModification;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.inocybe.opendaylight.summit.bepbop.rev160926.Parrot;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

/**
 * Created by adetalhouet on 2016-09-26.
 */
public class ParrotDataTreeChangeListener implements DataTreeChangeListener<Parrot> {

    private final static InstanceIdentifier<Parrot> PARROT_INSTANCE_IDENTIFIER = InstanceIdentifier.create(Parrot.class);

    private final DataBroker dataBroker;
    private ListenerRegistration<ParrotDataTreeChangeListener> reg;

    public ParrotDataTreeChangeListener(final DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    /**
     * Invoke by blueprint
     */
    public void start() {
        reg = dataBroker.registerDataTreeChangeListener(
                new DataTreeIdentifier<>(LogicalDatastoreType.CONFIGURATION, PARROT_INSTANCE_IDENTIFIER),
                this);
    }

    /**
     * Invoke by blueprint
     */
    public void stop() {
        if (reg != null) {
            reg.close();
            reg = null;
        }
    }

    @Override
    public void onDataTreeChanged(@Nonnull Collection<DataTreeModification<Parrot>> collection) {
        for (final DataTreeModification<Parrot> change : collection) {
            final DataObjectModification<Parrot> root = change.getRootNode();
            switch (root.getModificationType()) {
                case SUBTREE_MODIFIED:
                    update(change);
                    break;
                case WRITE:
                    // Treat an overwrite as an update
                    boolean update = change.getRootNode().getDataBefore() != null;
                    if (update) {
                        update(change);
                    } else {
                        add(change);
                    }
                    break;
                case DELETE:
                    remove(change);
                    break;
                default:
                    break;
            }
        }    }

    private void add(DataTreeModification<Parrot> change) {
        // TODO use change.getRootNode().getDataAfter();
    }

    private void update(DataTreeModification<Parrot> change) {
        // TODO use change.getRootNode().getDataAfter();
    }

    private void remove(DataTreeModification<Parrot> change) {
        // TODO use change.getRootNode().getDataAfter();
    }
}
