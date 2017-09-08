package org.dustinl.ast_customizer;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.dustinl.ast_customizer.CupidAstFactory;

import groovy.lang.GroovyClassLoader;

public class CupidClassPaser {
    private GroovyClassLoader gcl;

    private static CupidClassPaser parser = new CupidClassPaser();

    CupidClassPaser() {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        CompilerConfiguration cc = new CompilerConfiguration();
        cc.setSourceEncoding("UTF-8");
        cc.addCompilationCustomizers(CupidAstFactory.getSandbox());
        gcl = new GroovyClassLoader(this.getClass().getClassLoader(), cc);
    }

    public Class parse(File scriptFlie) throws IOException {
        return gcl.parseClass(scriptFlie);
    }

    public Class parse(String script) {
        return gcl.parseClass(script);
    }

    public static CupidClassPaser getParser() {
        return parser;
    }
}
