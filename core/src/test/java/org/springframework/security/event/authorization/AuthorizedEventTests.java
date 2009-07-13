/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.event.authorization;

import junit.framework.TestCase;

import org.springframework.security.ConfigAttributeDefinition;

import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

import org.springframework.security.util.SimpleMethodInvocation;


/**
 * Tests {@link AuthorizedEvent}.
 *
 * @author Ben Alex
 * @version $Id$
 */
public class AuthorizedEventTests extends TestCase {
    //~ Constructors ===================================================================================================

    public AuthorizedEventTests() {
        super();
    }

    public AuthorizedEventTests(String arg0) {
        super(arg0);
    }

    //~ Methods ========================================================================================================

    public void testRejectsNulls() {
        try {
            new AuthorizedEvent(null, ConfigAttributeDefinition.NO_ATTRIBUTES,
                new UsernamePasswordAuthenticationToken("foo", "bar"));
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertTrue(true);
        }

        try {
            new AuthorizedEvent(new SimpleMethodInvocation(), null,
                new UsernamePasswordAuthenticationToken("foo", "bar"));
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertTrue(true);
        }

        try {
            new AuthorizedEvent(new SimpleMethodInvocation(), ConfigAttributeDefinition.NO_ATTRIBUTES, null);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertTrue(true);
        }
    }
}