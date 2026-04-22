# Relatório de Gastos por Cliente

Você recebeu a tarefa de gerar um relatório consolidado de quanto cada cliente já gastou na locadora de filmes. Para atender a tarefa, você deve desenvolver uma aplicação Java que **conecte em um banco relacional, execute uma consulta SQL predefinida, armazene o resultado em coleções e grave um arquivo CSV**, sempre tratando exceções de forma segura.

## Organização dos arquivos
- Dentro de `challenges/09-rentals/submissions/`, crie um diretório com o seu nome (`nome-sobrenome/`) e dentro desse um diretório chamado `src`.
- Coloque todo o código-fonte dentro de `src/`.
- Salve as configurações de acesso ao banco em `db.properties` no diretório raiz da sua submissão (mesmo nível de `src/` e `bin/`).
- Baixe o driver JDBC do PostgreSQL ([postgresql-42.7.8.jar](https://jdbc.postgresql.org/download/postgresql-42.7.8.jar)) e coloque o `.jar` em uma pasta `lib/` no mesmo nível de `src/`.
- Gere o CSV de saída em `rentals.csv` no mesmo diretório onde o programa é executado (raiz da submissão).

### Formato do `db.properties`
```
db.url=jdbc:postgresql://<HOST>:<PORT>/<DATABASE>
db.user=<USER>
db.password=<PASSWORD>
csv.path=rentals.csv
```

## Base de dados

- A equipe de análise de dados forneceu a consulta abaixo, que deve receber um parâmetro representando o valor mínimo gasto:
```sql
SELECT  c.first_name as "Nome",
        c.last_name as "Sobrenome",
        c.email as "Email",
        SUM(p.amount) as "Valor Gasto"
FROM 
    rental r JOIN 
    customer c ON c.customer_id = r.customer_id JOIN
    payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id
GROUP BY c.first_name, c.last_name, c.email
HAVING SUM(p.amount) > ?
ORDER BY SUM(p.amount) desc;
```

- A equipe de banco de dados forneceu as credenciais do servidor:
    - `host`: `aws-1-us-east-2.pooler.supabase.com`
    - `port`: `5432`
    - `database`: `dvdrental`
    - `user`: `postgres.jhwxqtsivcmpfvpkpykn`
    - `password`: `<SENHA_FORNECIDA>`

## Especificação técnica

Implemente o sistema seguindo os seguintes requisitos.

1. Crie a classe `RentalSummary` com atributos privados `firstName`, `lastName`, `email` e `amount` (`double`).
1. Implemente construtor que inicialize todos os atributos e um `toString()` que retorne todos os valores separados por vírgula (`Nome,Sobrenome,Email,Valor Gasto`) para facilitar a gravação em CSV.
1. Utilize `ArrayList<RentalSummary>` para armazenar o resultado da consulta antes de gravar o arquivo.
1. Crie a classe principal `RentalReportApp` com o método `public static void main(String[] args)`.
1. A classe principal deve receber **um argumento de linha de comando** representando o valor mínimo gasto a ser aplicado na consulta (ex.: `100`); não leia esse valor pelo teclado.
1. No `main`, carregue o arquivo `db.properties` (localizado na raiz da submissão) usando `java.util.Properties` e `java.nio.file.Files.newInputStream`, validando se todas as chaves obrigatórias existem.
1. Abra a conexão JDBC com `DriverManager.getConnection(...)`.
1. Execute a consulta fornecida usando `PreparedStatement`, setando o parâmetro numérico do `HAVING`, e use `try-with-resources` para fechar `Connection`, `PreparedStatement` e `ResultSet`.
1. Para cada linha retornada, converta para `RentalSummary` e armazene na coleção em memória.
1. Gere o arquivo CSV no caminho informado em `csv.path` utilizando `Files.newBufferedWriter`, gravando cabeçalho `Nome,Sobrenome,Email,Valor Gasto` e uma linha por registro.

## Entrega
- Faça commit das alterações no seu repositório fork/clonado.
- Submeta o link do PR no ambiente virtual.

## Recomendação para execução local

- Substitua `<seu-diretorio>` pelo diretório criado dentro de `submissions/` e ajuste o valor mínimo passado como argumento conforme necessário.

```bash
cd challenges/09-rentals/submissions/<seu-diretorio>
```

- Se necessário, crie o diretório para armazenar a dependência do driver do postgres

```bash
mkdir -p lib
```

- Se necessário, faça download do driver
```bash
curl -L -o lib/postgresql-42.7.8.jar https://jdbc.postgresql.org/download/postgresql-42.7.8.jar
```

- Compile o programa

```bash
javac -d bin src/*.java
```

- Execute o programa

```bash
java -cp "bin:lib/postgresql-42.7.8.jar" RentalReportApp 200
```
