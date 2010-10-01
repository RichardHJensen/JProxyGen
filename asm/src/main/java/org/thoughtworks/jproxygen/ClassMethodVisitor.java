package org.thoughtworks.jproxygen;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.EmptyVisitor;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 8, 2010
 * Time: 8:41:16 PM
 * To change this template use File | Settings | File Templates.
 */
public  class ClassMethodVisitor extends ClassAdapter {
   private List methodNames = newArrayList();

   public ClassMethodVisitor() {
       super(new EmptyVisitor());
   }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        methodNames.add(name + desc);
        return new EmptyVisitor();
    }

    public List getMethodNames() {
           return methodNames;
    }
}
