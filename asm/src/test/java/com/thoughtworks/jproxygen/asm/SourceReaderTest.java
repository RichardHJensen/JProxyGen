package com.thoughtworks.jproxygen.asm;

import com.thoughtworks.jproxygen.sample.AClassWithOnlyOnePrimitive;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;


public class SourceReaderTest {
    @Test
    public void shouldGetMethodNamesUsingEventImpl() throws IOException {
        InputStream stream = AClassWithOnlyOnePrimitive.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class");
        List<Meth> methods = new SourceReaderEventImpl(stream).getMethods();
        assertEquals(newArrayList( new Ctr("V"), new Meth("I", "getIntValue") , new Meth("V", "setIntValue", "I")), methods);
    }

    @Test
    public void shouldGetMethodNamesUsingObjectImpl() throws IOException {
//        InputStream stream = AClassWithOnlyOnePrimitive.class.getResourceAsStream("AClassWithOnlyOnePrimitive.class");
//        List<String> actual = new SourceReaderObjectImpl(stream).getMethods();
//        assertEquals(newArrayList( "<init>()V", "getIntValue()I", "setIntValue(I)V"), actual);
    }
}
