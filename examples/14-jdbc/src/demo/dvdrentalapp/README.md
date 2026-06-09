### Rodar o projeto manualmente

```bash
javac -d target/classes src/main/java/br/edu/idp/cc/poo/dvdrental/Main.java src/main/java/br/edu/idp/cc/poo/dvdrental/model/Actor.java src/main/java/br/edu/idp/cc/poo/dvdrental/dao/ActorDAO.java src/main/java/br/edu/idp/cc/poo/dvdrental/util/*.java
```

```bash
java -cp target/classes:lib/* br.edu.idp.cc.poo.dvdrental.Main
```

### Rodar o projeto com maven

As configuracoes de conexao com o banco ficam em:

```text
src/main/resources/application.properties
```

```properties
database.url=jdbc:postgresql://localhost:5432/postgres
database.user=postgres
database.password=postgres
```

```bash
mvn install
```

```bash
mvn compile
```

```bash
mvn exec:java -Dexec.mainClass="br.edu.idp.cc.poo.dvdrental.Main"
```

```bash
mvn -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=[SONAR_PROJECT_KEY] -Dsonar.token=[SONAR_TOKEN]
```
