package org.dustinl.ast_customizer

import org.codehaus.groovy.control.customizers.SecureASTCustomizer
import org.kohsuke.groovy.sandbox.SandboxTransformer

final class CupidAstFactory {
    private CupidAstFactory() {
    }

    public static SecureASTCustomizer getAstCustomizer() {
        return new SecureASTCustomizer(
                // Do not allow method creation.
                methodDefinitionAllowed: true,

                // Do not allow closure creation.
                closuresAllowed: true,

                // No package allowed.
                packageAllowed: false,

                // White or blacklists for imports.
//        importsBlacklist: ['java.util.Date'],
                importsWhitelist: ['java.util'],
//        staticImportsWhitelist: ['java.util'],
                // or staticImportBlacklist
//        staticStarImportsWhitelist: [],
                // or staticStarImportsBlacklist

                // Make sure indirect imports are restricted.
                indirectImportCheckEnabled: true,

                // Only allow plus and minus tokens.
//        tokensWhitelist: [PLUS, MINUS, EQUAL],
                // or tokensBlacklist

                // Disallow constant types.
//        constantTypesClassesWhiteList: [Integer, Object, String],
                // or constantTypesWhiteList
                // or constantTypesBlackList
                // or constantTypesClassesBlackList

                // Restrict method calls to whitelisted classes.
                // receiversClassesWhiteList: [],
                // or receiversWhiteList
                // or receiversClassesBlackList
                // or receiversBlackList

                // Ignore certain language statement by
                // whitelisting or blacklisting them.
//        statementsBlacklist: [IfStatement],
                // or statementsWhitelist

                // Ignore certain language expressions by
                // whitelisting or blacklisting them.
//        expressionsBlacklist: [MethodCallExpression]
                // or expresionsWhitelist
        )
    }

    public static SandboxTransformer getSandbox() {
        return new SandboxTransformer();
    }
}
