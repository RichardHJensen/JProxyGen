package com.thoughtworks.jproxygen.asm;

import com.thoughtworks.jproxygen.sample.AClassWithOnlyOnePrimitive;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;


public class SourceReaderTest {
    @Test
    public void shouldGetMethodNamesUsingEventImpl() throws IOException {
        InputStream stream = AClassWithOnlyOnePrimitive.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class");
        SourceReader reader = new SourceReaderEventImpl(stream);
        assertEquals(newArrayList( "<init>()V", "getIntValue()I", "setIntValue(I)V"), reader.getMethodNames());
    }

    @Test
    public void shouldGetMethodNamesUsingObjectImpl() throws IOException {
        InputStream stream = AClassWithOnlyOnePrimitive.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class");
        SourceReader reader = new SourceReaderObjectImpl(stream);
        assertEquals(newArrayList( "<init>()V", "getIntValue()I", "setIntValue(I)V"), reader.getMethodNames());
    }
}
