# Exportação de Atores para CSV

Você foi contratado para ajudar a equipe de uma locadora que utiliza a base de dados **dvdrental**. A equipe precisa de um programa simples em Java para exportar uma lista de atores cadastrados no banco para um arquivo CSV.

A aplicação deve conectar ao banco com **JDBC**, executar uma consulta SQL fornecida, armazenar os resultados em uma **coleção** e gravar um arquivo **CSV**.

Não é necessário criar menu, ler dados do teclado ou receber argumentos de linha de comando.

## Organização dos arquivos

- Dentro de `assignments/07-exams/2026.1-2-actor-export/submissions/`, crie um diretório com o seu nome (`nome-sobrenome/`).
- Coloque todo o código-fonte dentro de `src/`.
- Salve as configurações de acesso ao banco em `db.properties` no diretório raiz da sua submissão, no mesmo nível de `src/`.
- Baixe o driver JDBC do PostgreSQL e coloque o arquivo `.jar` em uma pasta `lib/`, no mesmo nível de `src/`.
- Gere o CSV de saída no caminho informado pela chave `csv.path`.

### Formato do `db.properties`

```properties
db.url=jdbc:postgresql://<HOST>:<PORT>/dvdrental
db.user=<USER>
db.password=<PASSWORD>
csv.path=actors.csv
```

## Consulta SQL obrigatória

Use exatamente a consulta abaixo:

```sql
SELECT
    actor_id,
    first_name,
    last_name
FROM actor
ORDER BY actor_id
LIMIT 20;
```

## Especificação técnica

Implemente o sistema seguindo os requisitos abaixo.

1. Crie a classe `ActorExport` com atributos privados:
   - `id` (`int`)
   - `firstName` (`String`)
   - `lastName` (`String`)
1. Implemente um construtor que inicialize todos os atributos.
1. Implemente os métodos de leitura necessários.
1. Implemente um método `toCsvLine()` que retorne os dados separados por vírgula.
1. Crie a classe principal `ActorExportApp` com o método `public static void main(String[] args)`.
1. No `main`, carregue o arquivo `db.properties` usando `java.util.Properties` e `java.nio.file.Files.newInputStream`.
1. Abra a conexão com `DriverManager.getConnection(...)`.
1. Execute a consulta fornecida usando `Statement`.
1. Para cada linha do `ResultSet`, crie um objeto `ActorExport` e armazene-o em um `ArrayList<ActorExport>`.
1. Grave o CSV usando `Files.newBufferedWriter`, com o cabeçalho:

```csv
Id,Nome,Sobrenome
```

## Exemplo de execução

```bash
cd assignments/07-exams/2026.1-2-actor-export/submissions/<seu-diretorio>
mkdir -p lib
curl -L -o lib/postgresql-42.7.8.jar https://jdbc.postgresql.org/download/postgresql-42.7.8.jar
javac -d bin src/*.java
java -cp "bin:lib/postgresql-42.7.8.jar" ActorExportApp
```

Ao final da execução, o arquivo indicado em `csv.path` deve ser criado com os atores encontrados.

## Entrega

- Valide a compilação antes de submeter.
- Faça commit das alterações no seu repositório fork/clonado.
- Abra um pull request para o repositório principal.
- Submeta o link do pull request no ambiente virtual.
