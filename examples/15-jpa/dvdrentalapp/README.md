- Criar diretório para armazenar as dependências

```bash
mkdir lib
```

- Baixar manualmente as dependências do JPA

```bash
wget https://jdbc.postgresql.org/download/postgresql-42.7.7.jar -P lib
wget https://repo1.maven.org/maven2/jakarta/persistence/jakarta.persistence-api/3.2.0/jakarta.persistence-api-3.2.0.jar -P lib
wget https://repo1.maven.org/maven2/jakarta/xml/bind/jakarta.xml.bind-api/4.0.2/jakarta.xml.bind-api-4.0.2.jar -P lib
wget https://repo1.maven.org/maven2/jakarta/activation/jakarta.activation-api/2.1.1/jakarta.activation-api-2.1.1.jar -P lib
wget https://repo1.maven.org/maven2/jakarta/transaction/jakarta.transaction-api/2.0.1/jakarta.transaction-api-2.0.1.jar -P lib
wget https://repo1.maven.org/maven2/jakarta/inject/jakarta.inject-api/2.0.1/jakarta.inject-api-2.0.1.jar -P lib
wget https://repo1.maven.org/maven2/org/hibernate/orm/hibernate-core/7.0.2.Final/hibernate-core-7.0.2.Final.jar -P lib
wget https://repo1.maven.org/maven2/org/hibernate/models/hibernate-models/1.0.0/hibernate-models-1.0.0.jar -P lib
wget https://repo1.maven.org/maven2/org/glassfish/jaxb/jaxb-runtime/4.0.5/jaxb-runtime-4.0.5.jar -P lib
wget https://repo1.maven.org/maven2/org/glassfish/jaxb/jaxb-core/4.0.5/jaxb-core-4.0.5.jar -P lib
wget https://repo1.maven.org/maven2/com/fasterxml/classmate/1.7.0/classmate-1.7.0.jar -P lib
wget https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/1.15.11/byte-buddy-1.15.11.jar -P lib
wget https://repo1.maven.org/maven2/org/antlr/antlr4-runtime/4.13.2/antlr4-runtime-4.13.2.jar -P lib
wget https://repo1.maven.org/maven2/org/jboss/logging/jboss-logging/3.6.1.Final/jboss-logging-3.6.1.Final.jar -P lib
wget https://repo1.maven.org/maven2/com/sun/istack/istack-commons-runtime/4.1.1/istack-commons-runtime-4.1.1.jar -P lib
```

```bash
javac -cp "lib/*" -d bin src/main/java/br/edu/idp/cc/poo/dvdrental/HeartRatesTest.java src/main/java/br/edu/idp/cc/poo/dvdrental/dao/ActorDAO.java src/main/java/br/edu/idp/cc/poo/dvdrental/model/Actor.java src/main/java/br/edu/idp/cc/poo/dvdrental/util/AuditLogger.java
```

```bash
mkdir -p bin/META-INF
cp src/main/resources/META-INF/persistence.xml bin/META-INF/
```

```bash
java -cp bin:lib/* br.edu.idp.cc.poo.dvdrental.Main
```



