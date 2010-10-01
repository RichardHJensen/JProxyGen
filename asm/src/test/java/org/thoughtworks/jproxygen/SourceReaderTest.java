package org.thoughtworks.jproxygen;

import org.junit.Test;

import java.io.IOException;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;


public class SourceReaderTest {
    @Test
    public void shouldGetMethodNamesUsingEventImpl() throws IOException {
        SourceReader reader = new SourceReaderEventImpl(SourceReaderTest.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class"));
        assertEquals(newArrayList( "<init>()V", "getIntValue()I", "setIntValue(I)V"), reader.getMethodNames());
    }

    @Test
    public void shouldGetMethodNamesUsingObjectImpl() throws IOException {
        SourceReader reader = new SourceReaderObjectImpl(SourceReaderTest.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class"));
        assertEquals(newArrayList( "<init>()V", "getIntValue()I", "setIntValue(I)V"), reader.getMethodNames());
    }
}
