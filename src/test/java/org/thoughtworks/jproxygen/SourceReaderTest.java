package org.thoughtworks.jproxygen;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;


public class SourceReaderTest {
    @Test
    public void shouldGetMethodNames() throws IOException {
        SourceReader reader = new SourceReader();
        reader.setClassByteStream(SourceReaderTest.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class"));
        assertEquals(newArrayList( "<init>()V", "getIntValue()I", "setIntValue(I)V"), reader.getMethodNames());
    }
}
