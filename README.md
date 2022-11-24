## Intro
The code in this repo reproduces an odd compilation error with the latest amazoncorretto:11.0.17 jdk

### Detail
```
❯ mvn --version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: /opt/homebrew/Cellar/maven/3.8.6/libexec
Java version: 11.0.17, vendor: Amazon.com Inc., runtime: /Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home
Default locale: en_GB, platform encoding: UTF-8
OS name: "mac os x", version: "12.2.1", arch: "aarch64", family: "mac"
```

```
❯ mvn clean compile test-compile
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< com.imggaming.example:jdk-11-compile >----------------
[INFO] Building jdk-11-compile 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ jdk-11-compile ---
[INFO] Deleting /Users/card74944/temp/jdk-11-compile/target
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ jdk-11-compile ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/card74944/temp/jdk-11-compile/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.10.1:compile (default-compile) @ jdk-11-compile ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/card74944/temp/jdk-11-compile/target/classes
compiler message file broken: key=compiler.misc.msg.bug arguments=11.0.17, {1}, {2}, {3}, {4}, {5}, {6}, {7}
java.lang.NullPointerException
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.visitIdent(Flow.java:2467)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCIdent.accept(JCTree.java:2264)
        at jdk.compiler/com.sun.tools.javac.tree.TreeScanner.scan(TreeScanner.java:49)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$BaseAnalyzer.scan(Flow.java:398)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scan(Flow.java:1453)
        at jdk.compiler/com.sun.tools.javac.tree.TreeScanner.visitSelect(TreeScanner.java:302)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.visitSelect(Flow.java:2403)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCFieldAccess.accept(JCTree.java:2130)
        at jdk.compiler/com.sun.tools.javac.tree.TreeScanner.scan(TreeScanner.java:49)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$BaseAnalyzer.scan(Flow.java:398)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scan(Flow.java:1453)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scanExpr(Flow.java:1709)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.visitApply(Flow.java:2333)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1650)
        at jdk.compiler/com.sun.tools.javac.tree.TreeScanner.scan(TreeScanner.java:49)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$BaseAnalyzer.scan(Flow.java:398)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scan(Flow.java:1453)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scanExpr(Flow.java:1709)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scanExprs(Flow.java:1721)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.visitNewClass(Flow.java:2339)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCNewClass.accept(JCTree.java:1705)
        at jdk.compiler/com.sun.tools.javac.tree.TreeScanner.scan(TreeScanner.java:49)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$BaseAnalyzer.scan(Flow.java:398)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scan(Flow.java:1453)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scanExpr(Flow.java:1709)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.visitLambda(Flow.java:2360)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$LambdaAssignAnalyzer.visitLambda(Flow.java:1387)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCLambda.accept(JCTree.java:1827)
        at jdk.compiler/com.sun.tools.javac.tree.TreeScanner.scan(TreeScanner.java:49)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$BaseAnalyzer.scan(Flow.java:398)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.scan(Flow.java:1453)
        at jdk.compiler/com.sun.tools.javac.comp.Flow$AssignAnalyzer.analyzeTree(Flow.java:2510)
        at jdk.compiler/com.sun.tools.javac.comp.Flow.analyzeLambdaThrownTypes(Flow.java:250)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitLambda(Attr.java:2615)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCLambda.accept(JCTree.java:1827)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$4.complete(DeferredAttr.java:376)
        at jdk.compiler/com.sun.tools.javac.comp.ArgumentAttr$ArgumentType.complete(ArgumentAttr.java:364)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:337)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:323)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$MethodResultInfo.check(Resolve.java:1060)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$4.checkArg(Resolve.java:887)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$AbstractMethodCheck.argumentsAcceptable(Resolve.java:775)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$4.argumentsAcceptable(Resolve.java:896)
        at jdk.compiler/com.sun.tools.javac.comp.Infer.instantiateMethod(Infer.java:181)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:605)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.checkMethod(Resolve.java:644)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkMethod(Attr.java:4131)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkIdInternal(Attr.java:3924)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkMethodIdInternal(Attr.java:3825)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkId(Attr.java:3814)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitSelect(Attr.java:3707)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCFieldAccess.accept(JCTree.java:2130)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitApply(Attr.java:2006)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1650)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$4.complete(DeferredAttr.java:376)
        at jdk.compiler/com.sun.tools.javac.comp.ArgumentAttr$ArgumentType.complete(ArgumentAttr.java:364)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:337)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:323)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$MethodResultInfo.check(Resolve.java:1060)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$4.checkArg(Resolve.java:887)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$AbstractMethodCheck.argumentsAcceptable(Resolve.java:775)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$4.argumentsAcceptable(Resolve.java:896)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:618)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.checkMethod(Resolve.java:644)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkMethod(Attr.java:4131)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkIdInternal(Attr.java:3924)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkMethodIdInternal(Attr.java:3825)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.checkId(Attr.java:3814)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitSelect(Attr.java:3707)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCFieldAccess.accept(JCTree.java:2130)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitApply(Attr.java:2006)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1650)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribExpr(Attr.java:695)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitVarDef(Attr.java:1174)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCVariableDecl.accept(JCTree.java:972)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStat(Attr.java:724)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStats(Attr.java:743)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitBlock(Attr.java:1294)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCBlock.accept(JCTree.java:1036)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStat(Attr.java:724)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStats(Attr.java:743)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitBlock(Attr.java:1294)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCBlock.accept(JCTree.java:1036)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr.attribSpeculative(DeferredAttr.java:501)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr.attribSpeculative(DeferredAttr.java:483)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr.attribSpeculativeLambda(DeferredAttr.java:458)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredAttrNode$StructuralStuckChecker.canLambdaBodyCompleteNormally(DeferredAttr.java:875)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredAttrNode$StructuralStuckChecker.visitLambda(DeferredAttr.java:853)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCLambda.accept(JCTree.java:1827)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredAttrNode$StructuralStuckChecker.complete(DeferredAttr.java:807)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredType.check(DeferredAttr.java:337)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredAttrNode.process(DeferredAttr.java:754)
        at jdk.compiler/com.sun.tools.javac.comp.DeferredAttr$DeferredAttrContext.complete(DeferredAttr.java:601)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.rawInstantiate(Resolve.java:620)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.selectBest(Resolve.java:1563)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.findMethodInScope(Resolve.java:1733)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.findMethod(Resolve.java:1802)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.findMethod(Resolve.java:1776)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$10.doLookup(Resolve.java:2654)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve$BasicLookupHelper.lookup(Resolve.java:3293)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.lookupMethod(Resolve.java:3543)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.resolveQualifiedMethod(Resolve.java:2651)
        at jdk.compiler/com.sun.tools.javac.comp.Resolve.resolveQualifiedMethod(Resolve.java:2645)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.selectSym(Attr.java:3732)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitSelect(Attr.java:3612)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCFieldAccess.accept(JCTree.java:2130)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitApply(Attr.java:2006)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCMethodInvocation.accept(JCTree.java:1650)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribExpr(Attr.java:702)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitExec(Attr.java:1773)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCExpressionStatement.accept(JCTree.java:1468)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStat(Attr.java:724)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStats(Attr.java:743)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitBlock(Attr.java:1294)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCBlock.accept(JCTree.java:1036)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStat(Attr.java:724)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.visitMethodDef(Attr.java:1098)
        at jdk.compiler/com.sun.tools.javac.tree.JCTree$JCMethodDecl.accept(JCTree.java:866)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribTree(Attr.java:655)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribStat(Attr.java:724)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribClassBody(Attr.java:4694)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribClass(Attr.java:4585)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attribClass(Attr.java:4514)
        at jdk.compiler/com.sun.tools.javac.comp.Attr.attrib(Attr.java:4459)
        at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.attribute(JavaCompiler.java:1337)
        at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.compile(JavaCompiler.java:973)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.lambda$doCall$0(JavacTaskImpl.java:104)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.handleExceptions(JavacTaskImpl.java:147)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.doCall(JavacTaskImpl.java:100)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.call(JavacTaskImpl.java:94)
        at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess(JavaxToolsCompiler.java:136)
        at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile(JavacCompiler.java:182)
        at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute(AbstractCompilerMojo.java:1209)
        at org.apache.maven.plugin.compiler.CompilerMojo.execute(CompilerMojo.java:198)
        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:137)
        at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2(MojoExecutor.java:370)
        at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute(MojoExecutor.java:351)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:215)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:171)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:163)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:117)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:81)
        at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:56)
        at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:294)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:192)
        at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:105)
        at org.apache.maven.cli.MavenCli.execute(MavenCli.java:960)
        at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:293)
        at org.apache.maven.cli.MavenCli.main(MavenCli.java:196)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:282)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:225)
        at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:406)
        at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:347)
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] An unknown compilation problem occurred
[INFO] 1 error
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.884 s
[INFO] Finished at: 2022-11-24T10:43:41+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.10.1:compile (default-compile) on project jdk-11-compile: Compilation failure
[ERROR] An unknown compilation problem occurred
[ERROR] 
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
