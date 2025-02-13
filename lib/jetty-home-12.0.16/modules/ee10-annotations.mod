# DO NOT EDIT THIS FILE - See: https://jetty.org/docs/

[description]
Enables Annotation scanning for deployed web applications.

[environment]
ee10

[depend]
ee10-plus

[ini]
ee10.asm.version?=9.7.1
ee10.jakarta.annotation.api.version?=2.1.1

[lib]
lib/jetty-ee10-annotations-${jetty.version}.jar
lib/ee10-annotations/asm-${ee10.asm.version}.jar
lib/ee10-annotations/asm-analysis-${ee10.asm.version}.jar
lib/ee10-annotations/asm-commons-${ee10.asm.version}.jar
lib/ee10-annotations/asm-tree-${ee10.asm.version}.jar
lib/ee10-annotations/jakarta.annotation-api-${ee10.jakarta.annotation.api.version}.jar

[jpms]
add-modules:org.objectweb.asm
