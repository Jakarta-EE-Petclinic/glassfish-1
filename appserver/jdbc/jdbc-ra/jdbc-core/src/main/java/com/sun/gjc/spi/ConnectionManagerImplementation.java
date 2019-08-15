/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.gjc.spi;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;

/**
 * ConnectionManager implementation for Generic JDBC Connector.
 *
 * @author Binod P.G
 * @version 1.0, 02/07/31
 */
public class ConnectionManagerImplementation implements javax.resource.spi.ConnectionManager {

    /**
     * Returns a <code>Connection </code> object to the <code>ConnectionFactory</code>
     *
     * @param mcf  <code>ManagedConnectionFactory</code> object.
     * @param info <code>ConnectionRequestInfo</code> object.
     * @return A <code>Connection</code> Object.
     * @throws ResourceException In case of an error in getting the <code>Connection</code>.
     */
    public Object allocateConnection(ManagedConnectionFactory mcf,
                                     ConnectionRequestInfo info)
            throws ResourceException {
        ManagedConnection mc = mcf.createManagedConnection(null, info);
        return mc.getConnection(null, info);
    }

    /*
    * This class could effectively implement Connection pooling also.
    * Could be done for FCS.
    */
}