### Books

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

---

### Especificação

Livros podem ser publicados em diversos formatos, como **livros impressos**, **audiolivros** e **ebooks**. Para representar essa diversidade de formatos de maneira orientada a objetos, você deve implementar um programa com uma **hierarquia de classes** que modela diferentes tipos de livros com seus respectivos atributos e comportamentos.

### Especificação

1. O programa deve criar uma classe base chamada `Book`, que representa um livro genérico.
2. A classe `Book` deve possuir os seguintes atributos:
   - `title` (`String`) → Título do livro
   - `year` (`int`) → Ano de publicação
   - `author` (`String`) → Nome do autor
3. A classe `Book` deve possuir um construtor que inicializa todos os seus atributos.
4. A classe `Book` deve sobrescrever (`override`) o método `toString()` para retornar uma string com as informações básicas do livro (título, autor e ano).
5. O programa deve conter uma subclasse `PrintBook` que herda de `Book` e deve conter:
   - `publisher` (`String`) → Editora do livro
   - `isbn` (`String`) → Código ISBN do livro
6. A classe `PrintBook` deve sobrescrever o método `toString()` herdado de `Book`, incluindo as informações de `publisher` e `isbn`.
7. O programa deve conter uma subclasse `AudioBook` que também herda de `Book` e deve conter:
   - `fileSizeInMB` (`double`) → Tamanho do arquivo em megabytes
   - `playLengthInMinutes` (`int`) → Duração em minutos do áudio
   - `narrator` (`String`) → Nome do narrador
8. A classe `AudioBook` também deve sobrescrever o método `toString()`, incluindo as informações de `fileSizeInMB`, `playLengthInMinutes` e `narrator`.
9. O programa principal (`BookApp`) deve:
   - Instanciar objetos das classes `Book`, `PrintBook` e `AudioBook`.
   - Imprimir no console as informações de cada livro, usando o método `toString()`.