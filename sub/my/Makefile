.POSIX:
.SUFFIXES:

JAVA_SOURCES = mod/java/Files_FileDesc.java  mod/java/Files.java \
               mod/java/OberonRuntime.java  mod/java/Os.java  mod/java/Out.java
MOD_SOURCES = mod/Hello.Mod
build:
	mkdir -p out/
	java -cp $(OBERON_BIN) oberonc out $(MOD_SOURCES)

run:
	rm -rf ./out/
	mkdir -p ./out/
	java -cp $(OBERON_BIN) oberonc ./out ./mod/Hello.Mod
	java -cp $(OBERON_BIN):./out Hello

test:

clean:
	rm -rf out/ tests/out/
