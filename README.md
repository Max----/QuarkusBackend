# code-with-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Maxime's Doc

### TODO:

* Mix Api entre openapi et api generée

* Utiliser la generation d'interfaces *DONE*

* Mettre une DB en MangoDB

* Ecrire Findings dans ce README

### Findings

Generating Interface stubs with `openapi-generator-maven-plugin` has proven doable for non reactive services, using `jaxrs-spec` as generator  with options `<additionalProperties>interfaceOnly=true,useSwaggerAnnotations=false</additionalProperties>` but to use Quarkus reactive features no generator provide a usable stub. 
* `jaxrs-resteasy` generates with many outdated imports, the pom.xml had to incorporate:
```xml
<dependency>
      <groupId>io.swagger</groupId>
      <artifactId>swagger-annotations</artifactId>
      <version>1.5.24</version>
    </dependency>
    <dependency>
      <groupId>io.swagger</groupId>
      <artifactId>swagger-jaxrs</artifactId>
      <version>1.6.3</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
```
* Before running into even more import problems due to outdated libraries. At that point I stopped. I think the problem come from the generator creating an entire java servlet instead of just interfaces and all libraries being outdated in the servlet, like last update 2016 outdated. I did not find an option to create just interfaces.
* `jaxrs-jersey` has the same problems
* `jaxrs-cxf` has the same problems
* `jaxrs-spec` works, but only with non-reactive objects.





