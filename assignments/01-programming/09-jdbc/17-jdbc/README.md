### IDP Flix

Você foi contratado(a) como desenvolvedor(a) na startup IDPFlix. Sua primeira tarefa é desenvolver um programa em Java que realize as seguintes operações:

- Importar uma nova lista de filmes contida no arquivo de texto [new_films.txt](./data/new_films.txt) para a tabela `film` do banco de dados `dvd_rental`. O arquivo de dados possui o seguinte formato:
    ```bash
    title;language_id;rent_duration;rental_rate;replacement_cost
    ```
- Atualizar em 10% o valor de locação (`rental_rate`) de todos os filmes.
- Listar no console os filmes com duração de locação (`rent_duration`) igual  a 99, exibindo apenas as colunas `title` e `rental_rate`.

Para concluir a tarefa utilize o banco de dados `dvd_rental` configurado em sala de aula.

O código deve ser submetido no diretório `07-flix/submissions/seu-nome/src`

#### Requisitos de implementação

1. Criar uma classe modelo para a tabela `film`, com os seguintes atributos:
    - `String title`
    - `int languageId`
    - `int rentalDuration`
    - `double rentalRate`
    - `double replacementCost`
1. Criar uma classe para leitura do arquivo de texto
    - Utilizar `java.nio.file.Files.readAllLines()`
    - Obter o caminho do arquivo com `Paths.get("caminho_do_arquivo")`
    - Tratar exceções com `try-catch`
1. Criar classe principal para importar os filmes do arquivo de texto para o banco de dados, atualizar o valor de locação de todos os filmes e listar os filmes com duração de locação igual a 99
    - Usar `DriverManager.getConnection()` para obter conexão com banco de dados via JDBC.
        - É necessário ter o [driver JDBC do PostgreSQL](https://jdbc.postgresql.org/download/postgresql-42.7.6.jar) no classpath do projeto.
    - Utilizar `PreparedStatement` para:
        - inserir os filmes no banco de dados (`INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)`)
        - atualizar o valor de locação (`UPDATE film SET rental_rate = rental_rate * 1.1`)
        - listar os filmes com duração de locação igual a 99 (`SELECT title, rental_rate FROM film WHERE rent_duration = 99`)
    - Usar `try-with-resources` para garantir o fechamento automático dos recursos.