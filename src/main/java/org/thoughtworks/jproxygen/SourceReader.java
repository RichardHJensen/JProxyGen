package org.thoughtworks.jproxygen;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.commons.EmptyVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 8, 2010
 * Time: 8:01:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class SourceReader {
    private InputStream classStream;


    public List<String> getMethodNames() throws IOException {
        //System.out.println(classStream.getClass());
        ClassReader classReader = new ClassReader(classStream);
        classReader.accept(new TraceClassVisitor(new PrintWriter(System.out)), 0);
        return null;

    }

    public void setClassByteStream(InputStream aClass) {
        classStream = aClass;
    }
}
