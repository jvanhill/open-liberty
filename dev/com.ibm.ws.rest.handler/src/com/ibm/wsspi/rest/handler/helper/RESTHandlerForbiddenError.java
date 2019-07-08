/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.wsspi.rest.handler.helper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This error is thrown by the RESTHandlerContainer when an unauthorized request is encountered by a RESTHandler.
 *
 * @ibm-spi
 */
public class RESTHandlerForbiddenError extends RuntimeException {

    private static final long serialVersionUID = -3647481857680022528L;

    private final int statusCode = 403;

    private Set<String> requiredRoles;

    public RESTHandlerForbiddenError(Set<String> requiredRoles, Exception e) {
        super(e);
        if (requiredRoles != null && !requiredRoles.isEmpty()) {
            this.requiredRoles = new HashSet<String>(requiredRoles);
        }
    }

    public RESTHandlerForbiddenError(Set<String> requiredRoles, String msg) {
        super(msg);
        if (requiredRoles != null && !requiredRoles.isEmpty()) {
            this.requiredRoles = new HashSet<String>(requiredRoles);
        }
    }

    public RESTHandlerForbiddenError(Set<String> requiredRoles) {
        super();
        if (requiredRoles != null && !requiredRoles.isEmpty()) {
            this.requiredRoles = new HashSet<String>(requiredRoles);
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Set<String> getRequiredRoles() {
        return requiredRoles == null ? null : Collections.unmodifiableSet(requiredRoles);
    }
}
