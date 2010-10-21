package com.thoughtworks.jproxygen.asm;

import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SourceReaderEventImpl implements SourceReader {
    private InputStream classStream;

    public SourceReaderEventImpl(InputStream classStream) {
        this.classStream = classStream;
    }

    public List<Meth> getMethods() throws IOException {
        ClassReader classReader = new ClassReader(classStream);
        ClassMethodVisitor classVisitor = new ClassMethodVisitor();
        classReader.accept(classVisitor, 0);
        return classVisitor.getMethods();
    }
}
