/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.jaxrs30.fat.appandresource;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.junit.Test;

import componenttest.app.FATServlet;

@SuppressWarnings("serial")
@WebServlet("/AppAndResourceTestServlet")
public class AppAndResourceTestServlet extends FATServlet {
    private final static ClassLoader THIS_CLASSLOADER = AppAndResourceTestServlet.class.getClassLoader();

    @Test
    public void testCanLoadJavaxWsRsClasses() throws Exception {
        URI uri = URI.create("http://localhost:" + System.getProperty("bvt.prop.HTTP_default") + "/appandresource/app/path");
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        assertEquals(200, conn.getResponseCode());
        assertEquals("foo", readEntity(conn.getInputStream()));
    }

    private String readEntity(InputStream is) throws Exception {
        StringBuilder sb = new StringBuilder();
        byte[] b = new byte[256];
        int i = is.read(b);
        while (i > 0) {
            sb.append(new String(b, 0, i));
            i = is.read(b);
        }
        return sb.toString();
    }
}