package org.thoughtworks.jproxygen.asm;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: Sep 10, 2010
 * Time: 2:07:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SourceReader {
    List<String> getMethodNames() throws IOException;
}
