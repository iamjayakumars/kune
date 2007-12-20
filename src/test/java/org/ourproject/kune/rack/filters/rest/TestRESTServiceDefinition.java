package org.ourproject.kune.rack.filters.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.ourproject.kune.rack.filters.rest.REST;
import org.ourproject.kune.rack.filters.rest.RESTServiceDefinition;

public class TestRESTServiceDefinition {

    private RESTServiceDefinition definition;

    @Before
    public void createDefinition() {
        this.definition = new RESTServiceDefinition(SimpleRESTService.class);
    }

    @Test
    public void testMethodOrder() {
        assertEquals("three", definition.getMethods()[0].getName());
        assertEquals("two", definition.getMethods()[1].getName());
        assertEquals("one", definition.getMethods()[2].getName());
    }

    @Test
    public void testMethodCount() {
        assertEquals(3, definition.getMethods().length);
    }

    public static class SimpleRESTService {
        @REST(params = { "one", "two" })
        public void two(final String one, final String two) {

        }

        @REST(params = { "one", "two", "three" })
        public void three(final String one, final String two, final String three) {

        }

        @REST(params = { "one" })
        public void one(final String one) {
        }

    }
}