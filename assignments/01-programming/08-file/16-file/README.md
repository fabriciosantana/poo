### Relatório de Compras por Cliente

#### Objetivo

Criar um programa Java que leia um arquivo contendo registros de compras realizadas por clientes, calcule o total de compras por cliente e gere um arquivo de saída com um relatório consolidado. O programa deve utilizar exclusivamente as novas classes de manipulação de arquivos do pacote [`java.nio.file`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/package-summary.html) e estruturas básicas como [`ArrayList`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html).

#### Requisitos

- O programa deve receber como parâmetro de entrada duas strings representando o caminho do arquivo de entrada e saída
    - O caminho do arquivo de entrada deve apontar para o arquivo [compras.txt](./compras.txt)
    - O programa deve gravar o arquivo de saída
- Cada linha do arquivo possui o seguinte formato: `nomeCliente`,`nomeProduto`,`valor`
- Exemplo:
    ```
    João,ProdutoA,100.0
    Maria,ProdutoB,200.0
    João,ProdutoC,50.0
    ```
- O programa deve processar os dados e gerar o arquivo de saída com o total de compras acumulado por cliente.
- Exemplo de saída esperada:
    ```
    João: 150.0
    Maria: 200.0
    ```

- O programa deve ignorar linhas malformadas (com menos de 3 campos).
- O programa deve tratar exceções de leitura de arquivos e conversão numérica.

#### Requisitos de Implementação

- Utilizar obrigatoriamente as classes:
    - [`Path`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Path.html) e [`Files`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html) para leitura e escrita de arquivos.
    - [`ArrayList`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html) para armazenar os dados de clientes e totais de compras.
- A lógica de acumulação dos valores por cliente deve ser feita por meio de comparação de nomes nas listas paralelas (`ArrayList<String>` e `ArrayList<Double>`).
- Ao final do processamento, a saída deve ser gravada no arquivo `report.txt`.
- O programa deve ser implementado em uma única classe com o método `main`.