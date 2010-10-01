package org.thoughtworks.jproxygen.asm;

import com.google.common.base.Function;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 8, 2010
 * Time: 8:01:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class SourceReaderObjectImpl implements SourceReader {
    private InputStream classStream;

    public SourceReaderObjectImpl(InputStream classStream) {
        this.classStream = classStream;
    }

    public List<String> getMethodNames() throws IOException {
        ClassReader classReader = new ClassReader(classStream);
        ClassNode classNode = new ClassNode();
        classReader.accept(classNode,0);

        return transform(classNode.methods, new Function<MethodNode,String>(){
            public String apply(MethodNode methodNode) {
                return methodNode.name + methodNode.desc;
            }
        });
    }
}
