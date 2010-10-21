package com.thoughtworks.jproxygen.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.EmptyVisitor;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public  class ClassMethodVisitor extends ClassAdapter {
   private List<Meth> methods = newArrayList();

   public ClassMethodVisitor() {
       super(new EmptyVisitor());
   }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        Type[] types = Type.getArgumentTypes(desc);
        Type rv = Type.getReturnType(desc);
        Meth meth = new Meth(rv.toString(), name, args(types));
        methods.add(meth);
        return new EmptyVisitor();
    }

    private String[] args(Type[] types) {
        String[] args = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            args[i] = types[i].toString();
        }
        return args;
    }

    public List<Meth> getMethods() {
           return methods;
    }
}
