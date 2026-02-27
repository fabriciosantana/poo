
## Manipulação de arquivos em java

Referência: https://www.w3resource.com/java-exercises/io/index.php

Crie a classe `FileApp` (`submissions/<nome-sobrenome>/src/FileApp.java`) e implemente todas as operações descritas abaixo diretamente no método `main`, sempre imprimindo o nome da operação e os resultados obtidos (não crie métodos auxiliares).

Utilize classes e interfaces do pacote [java.nio](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/package-summary.html)

## Operações

1. **List Files in Directory**: liste todos os nomes de arquivos existentes no direótio `data`;
1. **Check Path Exists**: verifique se o arquivo `clients.txt` existe (`true` ou `false`) antes de utilizar o caminho.
1. **Read File Line by Line**: leia o arquivo `clients.txt` exibindo cada linha na ordem em que aparece e prefixe a saída com o número da linha.
1. **Append Text to File**: leia entrada do usuário e acrescente novas linhas ao final arquivo `clients.txt` e mostre apenas as linhas adicionadas.
1. **Write Text File**: escreva dados formatados no novo arquivo `clients_new.txt`, confirme o sucesso da gravação e em seguida leia o arquivo para exibir o conteúdo.
1. **Copy File**: use `Files.copy` para duplicar `clients.txt` em `backup/clients_backup.txt`, defina a opção StandardCopyOption como REPLACE_EXISTING.
1. **Delete**: tente remover `backup/old-clients.txt` com `Files.delete`, capturando `NoSuchFileException` para relatar ausência versus
     falha de permissão.
1. **Directory Tree Walk**: percorra recursivamente data com `Files.walk`, filtrando apenas arquivos modificados nas últimas 24h e imprimindo o tamanho com Files.size.
1. **File Attributes and Metadata**: leia atributos básicos do arquivo `clients.txt` via `Files.readAttributes` (tamanho, criação, última modificação) e exiba-os formatados.
