## ☕ Programação Orientada a Objetos em Java

Seja bem-vindo(a)! 🤗

Este repositório reúne materiais, tarefas, projetos, leituras e referências bibliográficas da disciplina **Programação Orientada a Objetos**, oferecida no **[Instituto Brasileiro de Ensino, Desenvolvimento e Pesquisa](http://idp.edu.br)** e ministrada pelo professor **[Fabricio Santana](https://github.com/fabriciosantana/)**. 

Durante o curso, serão abordados tópicos fundamentais, como introdução à programação, classes, objetos, herança, polimorfismo, encapsulamento e persistência, além de outros conceitos essenciais para a construção de aplicações robustas e escaláveis. 

Utilize este material como um recurso adicional para fortalecer seus conhecimentos e aprimorar suas habilidades na linguagem Java.

Nesta página você encontra:
* [Links importantes](#links-importantes)
* [Informações iniciais](#antes-de-começar)
* [Livros de referência](#livros-de-referência)
* [Artigos](#artigos)
* [Slides apresentados em sala](#slides-apresentados-em-sala)
* [Cursos de outras universidades](#outros-cursos)

### Links importantes
- [Plano de ensino](https://1drv.ms/w/s!Avnn2LcOmn0Y3l_dUnQKwrevbU8h?e=0YuCb2) (oficial)
- [Atividades](./assignments)
- [Como fazer?](./howto/)

### Antes de começar

Para executar os códigos de exemplo, realizar as atividades práticas e desenvolver o projeto, é essencial ter um computador e configurá-lo com as ferramentas apropriadas.

A escolha do **[computador](https://en.wikipedia.org/wiki/Computer)** e do **[sistema operacional](https://en.wikipedia.org/wiki/Operating_system)** pode impactar significativamente sua experiência no desenvolvimento de softwares.

Para programar em **[Java](https://en.wikipedia.org/wiki/Java_(programming_language))**, não é necessário um computador de alto desempenho, mas recomenda-se um processador moderno, com pelo menos **16 GB de RAM** e um SSD para garantir melhor desempenho na compilação e execução dos programas. 

Quanto ao sistema operacional, o **[Linux](https://en.wikipedia.org/wiki/Linux)** é amplamente utilizado por desenvolvedores devido à sua compatibilidade com ferramentas open-source e ambientes de desenvolvimento, mas o **[Windows](https://en.wikipedia.org/wiki/Microsoft_Windows)** e **[macOS](https://en.wikipedia.org/wiki/MacOS)** também oferecem suporte completo para Java. 

Independentemente do sistema operacional escolhido, seu código poderá ser executado em qualquer outro sistema operacional que possua um ambiente Java devidamente configurado com a **[Java Virtual Machine](https://en.wikipedia.org/wiki/Java_virtual_machine)** geralmente por meio do **[Java Development Kit (JDK)](https://en.wikipedia.org/wiki/Java_Development_Kit)**. Isso ocorre porque o **[Java é uma linguagem multiplataforma](https://en.wikipedia.org/wiki/Cross-platform_software)**, permitindo que programas escritos em Java sejam executados sem modificações em diferentes sistemas operacionais. 

Caso esteja utilizando o Windows, uma alternativa prática para desenvolver em um ambiente Linux é o **[Windows Subsystem for Linux (WSL)](https://en.wikipedia.org/wiki/Windows_Subsystem_for_Linux)**, que permite rodar distribuições Linux diretamente no Windows com desempenho quase nativo. Outra opção é utilizar um **container de desenvolvimento na nuvem**, como o **[GitHub Codespaces](https://docs.github.com/codespaces/overview)**, garantindo um ambiente isolado, portátil e fácil de configurar, sem a necessidade de instalar todas as dependências no sistema operacional principal.

Além de um computador e um sistema operacional, para desenvolver software em Java, é necessário instalar uma distribuição do **[Java Development Kit (JDK)](https://en.wikipedia.org/wiki/Java_Development_Kit)**. Há várias distribuições do JDK disponíveis, este repositório utiliza **[OpenJDK](https://en.wikipedia.org/wiki/OpenJDK)**, versão 21.

Embora seja possível desenvolver programas em Java utilizando qualquer **[editor de texto](https://en.wikipedia.org/wiki/Text_editor)** e um **[terminal](https://en.wikipedia.org/wiki/Terminal_emulator)**, recomenda-se o uso de um **[Ambiente de Desenvolvimento Integrado (Integrated Development Environment - IDE)](https://en.wikipedia.org/wiki/Integrated_development_environment)**. As IDEs tornam o desenvolvimento mais eficiente ao oferecer funcionalidades como edição avançada de código, compilação, testes, depuração, geração de pacotes e uma interface gráfica intuitiva.

Existem diversas IDEs para programação em Java no mercado, todas compatíveis com o código deste repositório. No entanto, recomenda-se a utilização do **[Visual Studio Code (VS Code)](https://code.visualstudio.com/)** devido à sua simplicidade, flexibilidade, extensibilidade e possibilidade de execução online, sem necessidade de instalação. Além disso, o VS Code oferece integração nativa com o **[GitHub Codespaces](https://github.com/features/codespaces)**, tornando o ambiente de desenvolvimento ainda mais acessível e eficiente.

Desenvolver software é um processo contínuo que exige colaboração e organização, frequentemente envolvendo vários desenvolvedores ao longo do tempo. Para gerenciar versões do código, facilitar o trabalho em equipe e manter um histórico estruturado das alterações, este repositório adota o **[Git](https://git-scm.com/)**, um sistema de controle de versão distribuído amplamente utilizado. O Git permite acompanhar mudanças no código, trabalhar em diferentes ramificações e sincronizar o projeto com repositórios remotos, como o **[GitHub](https://github.com/)**.

Em síntese, para aproveitar todo o conteúdo e praticar muito você precisa de no mínimo:
* Um computador com o sistema operacional de sua escolha, recomenda-se utilizar Linux (Ubuntu), Windows com WSL ou o Github Codespaces
* Instalar uma das distribuições do Java Development Kit (JDK), recomenda-se o OpenJDK 21
* Instalar uma IDE, recomenda-se o VS Code com os plugins para Java e Git

Se tudo isso é muito novo para você, invista um tempo em fortalecer sua base de conhecimento com os seguintes recursos:
* [Introduction to Linux](https://training.linuxfoundation.org/training/introduction-to-linux/)
* [Getting started with Visual Studio Code](https://code.visualstudio.com/docs/introvideos/basics)
* [Intro to GitHub](https://education.github.com/experiences/intro_to_github)
* [GitHub Foundations (Microsoft)](https://education.github.com/experiences/intro_to_github)

### Livros de referência

1. BUDD, Timothy. **An Introduction to Object-Oriented Programming**. 3. ed. Boston: Addison-Wesley, 2002. ISBN 0-201-76031-2.
2. DEITEL, Paul; DEITEL, Harvey. **Java: How to Program, Early Objects**. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.
3. SCHILDT, Herbert. **Java: The Complete Reference: Comprehensive Coverage of the Java Language**. 12. ed. New York: McGraw Hill, 2021. ISBN 978-1-26-046342-2.
4. SEGEWICK, Robert; WAYNE, Kevin. **Computer Science: An Interdisciplinary Approach**. Boston: Addison-Wesley, 2016. ISBN 978-0-13-407642-3.
5. WEISFELD, Matt. **The Object-Oriented Thought Process**. 5. ed. Boston: Addison-Wesley, 2019. ISBN 978-0-13-476872-4.

### Artigos

1. [The End of Programming as We Know It ](https://www.oreilly.com/radar/the-end-of-programming-as-we-know-it/)
1. [The Impact of AI on Computer Science Education](https://cacm.acm.org/news/the-impact-of-ai-on-computer-science-education/)
1. [English will become the most popular development language in 6 years](https://blog.almaer.com/english-will-become-the-most-popular-development-language-in-6-years/)
1. [Why Writing by Hand Is Better for Memory and Learning](https://www.scientificamerican.com/article/why-writing-by-hand-is-better-for-memory-and-learning/)
1. [Prompt Engineering](https://1drv.ms/b/c/187d9a0eb7d8e7f9/EdC4xMjHwO5HhxMNELjXqdsBmjfFcQzDVB9tFNcs7t7Z2A?e=hMOFg0)

### Slides apresentados em sala

|#|Conteúdo|Atividade em sala|
|---|---|---|
| 1 | [Apresentação da disciplina e contextualização](https://fabriciosantana.github.io/poo/01-introduction)| |
| 2 | [Configuração de ambiente, visão geral do github e procedimento para submissão de tarefas](https://fabriciosantana.github.io/poo/01a-hello/) | [Configuração do ambiente java](./howto/) e execução do [Hello, World!](./examples/00-hello) |
| 3 | [Plataforma Java - ferramentas, jshell, java e javac](https://fabriciosantana.github.io/poo/02-platform)| [Execução de código no jshell](./examples/02a-elements-primitives-jshell/) |
| 4 | [Elementos básicos da linguagem Java](https://fabriciosantana.github.io/poo/03-elements)| [Execução de código no jshell](./examples/02a-elements-primitives-jshell/) |

### Slides apresentados em sala (em revisão)
|#|Conteúdo|Atividade em sala|
|---|---|---|
| 4  | [Programação em Java - custom types, entrada e saída, operadores e controle de fluxo](https://1drv.ms/p/s!Avnn2LcOmn0Y3zPoINGBudmIix2X?e=H5Orac)| [Quizz: plataforma java, elementos da linguagem e tipos primitivos](https://idp2.vevox.com/#/share/AIMIDN010NEQOHBNNEZA/meetingdata/710808/session/714745/pollresults); <br> Análise de código: [estruturas de seleção](./examples/04-selection-statements/) e [estruturas de iteração](./examples/05-iteration-statements/)|
| 5 | Continuação aula anterior | Análise de código: [estruturas de seleção](./examples/04-selection-statements/) e [estruturas de iteração](./examples/05-iteration-statements/)|
| 6 | Continuação aula anterior | |
| 7 | [Programação Orientada a Objetos em Java - classes, objetos e métodos](https://1drv.ms/p/s!Avnn2LcOmn0Y3z07tfmzQYKuLXJK?e=WDMEbX)| |
| 8 | [Programação Orientada a Objetos em Java - classes, objetos, métodos, construtores, sobrecarga de construtores e métodos, modificadores de acesso, métodos get e set, encapsulamento, introdução ao tratamento de exceção, composição, membros de classe e instância](https://1drv.ms/p/s!Avnn2LcOmn0Y31s3uczqB-Lou_2O?e=q233L4) | |
| 9 | [Programação Orientada a Objetos em Java - herança, extends, override, super, abstract, polimorfismo, encapsulamento, package, import](https://1drv.ms/p/s!Avnn2LcOmn0Y32GgrYpPTFA8lUHl?e=u7L4jb) | Análise de código do programa [payroll](./examples/09-inheritance/payroll/) | 
| 10 | [Arrays](https://1drv.ms/p/s!Avnn2LcOmn0Y31mEsDxOHyKDT0OE?e=QwcIjL) | [Análise de código arrays](./examples/07-arrays) <br> |
| 11 | [ArrayList](https://1drv.ms/p/c/187d9a0eb7d8e7f9/Efnn2LcOmn0ggBjZLwAAAAABx1Nmn4wiFopjTu1n-YYpmw?e=YltGd9) | |
| 12 | [Tratamento de Exceções](https://fabriciosantana.github.io/poo/11-exception/) | |
| 13 | [Coleções genéricas](https://fabriciosantana.github.io/idp-marp-slides/html/poo-11-collections.html) | |
| 14 | [Manipulação de arquivos em Java](https://1drv.ms/p/c/187d9a0eb7d8e7f9/ER83TNCSyDBEu5m2MiR-xDkBBf8nV7BOBS-IKMNyMY0WjQ?e=ZJDNe6) |  |
| 15 | [Acesso a banco de dados com JDBC](https://fabriciosantana.github.io/poo/14-jdbc) | |
|  | Continuação aula anterior | [Estudo de caso: IDP Bank (Semana 1)](./assignments/06-projects/02-bank/) |
|  | Continuação aula anterior | [Estudo de caso: IDP Bank (Semana 2)](./assignments/06-projects/02-bank/) | Desenvolvimento do estudo de caso: IDP Bank (Semana 2)  |
|  | Continuação aula anterior | [Estudo de caso: IDP Bank (Semana 2)](./assignments/06-projects/02-bank/) | Desenvolvimento do estudo de caso: IDP Bank (Semana 2)  |
|  | Continuação aula anterior |  |


Além dos links na tabela acima, os slides também ficam disponíveis para download em PDF.

Use o padrão de URL:
`https://fabriciosantana.github.io/poo/exports/<nome-do-slide>.pdf`

Exemplos:
* `https://fabriciosantana.github.io/poo/exports/01-introduction.pdf`
* `https://fabriciosantana.github.io/poo/exports/02-platform.pdf`

### Outros Cursos

https://www.cs.cornell.edu/courses/JavaAndDS/definitions.html
https://www.cs.cornell.edu/info/people/tt/Principled_Programming.html
https://andrewcmyers.github.io/oodds/
