package org.thoughtworks.jproxygen;

import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 8, 2010
 * Time: 8:01:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class SourceReaderEventImpl implements SourceReader {
    private InputStream classStream;

    public SourceReaderEventImpl(InputStream classStream) {
        this.classStream = classStream;
    }

    public List<String> getMethodNames() throws IOException {
        ClassReader classReader = new ClassReader(classStream);
        ClassMethodVisitor classVisitor = new ClassMethodVisitor();
        classReader.accept(classVisitor, 0);
        return classVisitor.getMethodNames();
    }
}
