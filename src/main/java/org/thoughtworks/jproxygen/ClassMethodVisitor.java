package org.thoughtworks.jproxygen;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.EmptyVisitor;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 8, 2010
 * Time: 8:41:16 PM
 * To change this template use File | Settings | File Templates.
 */
public  class ClassMethodVisitor extends ClassAdapter {

   public ClassMethodVisitor() {
       super(new EmptyVisitor());
       ClassVisitor tv = new TraceClassVisitor(new PrintWriter(System.out));
   }

    


}
