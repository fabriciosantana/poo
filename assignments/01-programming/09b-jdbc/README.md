## CRUD com JDBC no Banco DVD Rental

Desenvolva uma aplicação em Java orientada a objetos utilizando JDBC que seja capaz de realizar as operações de **criação, leitura, atualização e remoção (CRUD)** sobre a tabela `film` do banco de dados **dvdrental** (PostgreSQL).

### Requisitos Funcionais

O sistema deve permitir:

1. Inserir um novo filme
1. Buscar filme por ID
1. Listar atores de um filme, buscar filme por ID
1. Excluir ator por ID
1. Registrar em arquivo de log (`audit.log`) todas as alterações (inserção, atualização e exclusão)

### Requisitos Técnicos

1. O acesso ao bando de dados deve usar exclusivamente o pacote `java.sql` (JDBC puro)
1. Log de auditoria deve ser feito com `java.nio.file.Files` (arquivo `audit.log`)
1. Configuração da conexão em `db.properties`
