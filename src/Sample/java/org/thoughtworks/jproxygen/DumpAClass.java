package org.thoughtworks.jproxygen;

import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 22, 2010
 * Time: 8:30:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DumpAClass {
    PrintWriter pw = new PrintWriter(System.out);
    TraceClassVisitor visitor = new TraceClassVisitor(pw);

    visitor.visitEnd();Ê

}
