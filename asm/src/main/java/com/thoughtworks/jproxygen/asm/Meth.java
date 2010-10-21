package com.thoughtworks.jproxygen.asm;

import java.util.Arrays;

public class Meth {
    private final String rv;
    private final String name;
    private final String[] args;

    public Meth(String rv, String name, String... args) {
        this.rv = rv;
        this.name = name;
        this.args = args;
    }

    @Override
    public final String toString() {
        String str = rv + ' ' + name + (args == null ? "" : Arrays.asList(args));
        return str.replace('[','(').replace(']',')');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Meth meth = (Meth) o;

        if (!Arrays.equals(args, meth.args)) return false;
        if (name != null ? !name.equals(meth.name) : meth.name != null) return false;
        if (rv != null ? !rv.equals(meth.rv) : meth.rv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rv != null ? rv.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (args != null ? Arrays.hashCode(args) : 0);
        return result;
    }
}
