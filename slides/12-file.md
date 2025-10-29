---
layout: frontcover
transition: none
title: IDP - POO
id: aula12
lesson: Manipulação de arquivos em Java
goals:
  - Escrever conteúdo formatado em arquivos com `Formatter`
  - Ler arquivos usando `java.nio.file.Path` e `Scanner`
  - Tratar exceções comuns em operações de I/O
---

---
layout: default
lesson: Manipulação de arquivos
---

## Manipulação de arquivos

- Dados armazenados em variáveis e arrays são temporários​
    - Os dados são perdidos quando o escopo ou o programa termina​
- Arquivos: solução para retenção de dados no longo prazo​
    - Dados persistentes​
- Para um programa Java, um arquivo é um fluxo sequencial de bytes ( **stream of bytes**)

<FigureWithCaption
  src="images/file.png"
  alt="Manipulação de arquivos"
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Fluxo de dados (**Stream**)

- Quando um programa Java é iniciado, ele cria 3 objetos de fluxo de dados (**stream**​)
    - [System.in](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#in): standard input stream (é um [InputStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStream.html)​
    - [System.out](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out): standard output stream (é um [PrintStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/PrintStream.html))​
    - [System.err](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#err): standard error stream (é um [PrintStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/PrintStream.html))​
- Esses fluxo de dados podem ser redirecionados​
    - [setIn​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#setIn(java.io.InputStream))
    - [setOut​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#setOut(java.io.PrintStream))
    - [setErr​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#setErr(java.io.PrintStream))

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Pacotes para manipulação de arquivos

- [java.io](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/package-summary.html): oferece classes e interfaces para entrada e saída de dados por fluxos (**_streams_**), serialização de objetos e manipulação de arquivos e diretórios no sistema de arquivos.
- [java.nio](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/package-summary.html): introduz uma forma mais moderna e eficiente de trabalhar com entrada e saída em Java, usando buffers para armazenar dados, canais para conectar-se a arquivos ou redes e recursos que permitem processar informações de forma mais rápida e sem bloquio.

---

## Principais classes e interfaces de manipulação de arquivos

- [java.nio.file.Paths​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Paths.html)
    - oferece métodos estáticos usados para recuperar um objeto do tipo Path representando um arquivo ou diretório​
- [java.nio.file.Files​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html)
    - oferece métodos estáticos para manipulação de arquivos e diretórios​ (copy, move, exists)
- [java.nio.file.Path](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Path.html) (interface)​
    - objetos de classes que implementam a interface Path representa a localização de um arquivo ou diretório​
- [java.nio.file.DirectoryStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/DirectoryStream.html) (interface)​
    - objetos de classes que implementam essa interface pode iterar sobre o conteúdo de um diretório​

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Tipos de arquivos

- Texto: **_character-based streams_**
    - dados são processados como uma sequência de caracteres​
        - [java.io.Reader​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Reader.html)
        - [java.io.Writer​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Writer.html)
        - [java.util.Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html): segmenta tokens usando espaços em branco, também pode ser usadad para ler arquivos
        - [java.util.Formatter​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html): permite que dados formatados sejam enviados para qualquer fluxo baseado em texto de maneira semelhante ao método System.out.printf.

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Tipos de arquivos

- Binário: **_binary-based streams_**
    - dados são processados como uma sequência de bytes
        - [java.io.InputStream​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStream.html)
            - [java.io.FileInputStream​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/FileInputStream.html)
        - [java.io.OutputStream​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/OutputStream.html)
            - [java.io.FileOutputStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/FileOutputStream.html)

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Arquivos de texto sequenciais

- Registros são armazenados na ordem​
    - Criar​
    - Ler​
    - Atualizar​
    - Apagar​

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Serialização e Desserialização

- Serializar: persistir em arquivo o estado de um objeto​
- Desserializar: ler o estado de um objeto a partir de um arquivo​
- XML: eXtensible Markup Language​
- JSON: JavaScript Object Notation​

- `try-with-resources` garante fechamento do arquivo

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Boas práticas de I/O

- Valide se o arquivo existe antes de ler (Files.exists)
- Evite sobrescrever arquivos importantes (verifique permissões)
- Trate NoSuchElementException ao ler dados mal formatados
- Prefira BufferedWriter/Reader para arquivos grandes
- Considere serializar dados estruturados em CSV/JSON para facilitar interoperabilidade
- Diagrama de estados ajuda a definir quando abrir/fechar recursos

---
layout: backcover
---
