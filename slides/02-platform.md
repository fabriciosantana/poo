---
layout: frontcover
transition: none
title: IDP - POO
id: aula02
lesson: Plataforma Java - ferramenta, jshell, java e javac
goals:
  - Compreender os aspectos introdutórios de programação de computadores
  - Conhecer a plataforma Java e suas principais ferramentas
  - Experimentar código Java no jshell
---

---
layout: default
lesson: Plataforma Java
---

## O que é programação?

<div class="mt-6 text-3xl text-center" v-click>
    “Programação é a arte de 
    <span class="text-blue-700 font-bold">dizer</span> <br/>
    ao computador 
    <span class="text-blue-700 font-bold">o que fazer</span>”
    <Reference
      reference="Donal Knuth, autor da série de livros The Art of Computer Programming"
    />

</div>
<br/>
<div class="mt-6 text-3xl text-center" v-click>
    “Um 
    <span class="bg-yellow-300 px-1">algoritmo</span> 
    é um 
    <span class="text-blue-700 font-bold">conjunto de instruções</span> <br/>
    para concluir uma 
    <span class="text-blue-700 font-bold">tarefa</span>”
    <Reference
      reference="BHARGAVA, Aditya Y. Grokking Algorithms. 2. ed. Shelter Island: Manning Publications, 2024. ISBN 978-1-63343-853-8."
    />
</div>

---

## O que é programação?

**Programar é se comunicar com o computador**

- Elementos da comunicação ( Emissor --> Receptor)
  - Canal (meio)
  - Referente (conteúdo)
  - Mensagem (forma)
  - Código (signos)
- Elementos da linguagem
  - Léxico (vocabulário)  
  - Sintaxe (estrutura)  
  - Semântica (significado)
    
---

## Como o computador executa uma tarefa?

<FigureWithCaption
  src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Von_Neumann_Architecture.svg/1280px-Von_Neumann_Architecture.svg.png"
  alt="Organização do computador"
  link="https://en.wikipedia.org/wiki/Von_Neumann_architecture"
/>

---

## Qual a função de um programa?

Manipular dados

<FigureWithCaption
  src="images/data.png"
  alt="Manipulação de dados"
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Qual a função de um programa?

Manipular dados

<FigureWithCaption
  src="images/byte.png"
  alt="Medida de dados"
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Como instruir um computador?

<div class="grid grid-cols-2">

<div>

[Linguagem de programação](https://en.wikipedia.org/wiki/Programming_language)
- [Linguagem de máquina](https://en.wikipedia.org/wiki/Machine_code)
- [Linguagem assembly](https://en.wikipedia.org/wiki/Assembly_language)
- [Linguagem de alto nível](https://en.wikipedia.org/wiki/High-level_programming_language)
  - ex.: Java

</div>

<div>
  <FigureWithCaption
    src="images/computer-languages.png"
    alt="Linguagens"
    link="http://www.btechsmartclass.com/c_programming/C-Computer-Languages.html"
  />
</div>

</div>

---

## Qual o próximo passo?

<div class="grid grid-cols-2">

<div>

Progresso dos modelos da openAI em codificação:​
- 1º modelo de raciocínio: top 1 milhão​
- o1 (setembro/2024): top 10.000​
- o3 (janeiro/2025): top 175​
- modelo interno (fevereiro/2025): top 50​
- Final de 2025: top 1​

</div>

<div>
  <VideoWithOutQuote
    videoId=8LmfkUb2uIY:1201
    sourceUrl="https://www.youtube.com/watch?v=8LmfkUb2uIY"
  />
</div>

</div>

---

## Qual o próximo passo?

<FigureWithCaption
    src="images/icpc.png"
    alt="ICPC 2025"
    link="https://deepmind.google/blog/gemini-achieves-gold-medal-level-at-the-international-collegiate-programming-contest-world-finals/"
  />

---

## O que é a plataforma Java?

Java é um conjunto de softwares e especificações de computador que fornece uma plataforma de software para desenvolver aplicativos e implantá-los em um ambiente de computação multiplataforma.

<ReferenceLink
  reference="https://en.wikipedia.org/wiki/Java_(software_platform)"
  />

---

## O que usar para programar Java?

Plataformas Java
- **Java SE (Standard Edition)**
- Java EE (Enterprise Edition) / Jakarta EE
- Java ME (Micro Edition)
- Java Card

<Reference
  reference="MUGHAL, Khalid; STRELNIKOV, Vasily. OCP Oracle Certified Professional Java SE 17 Developer (Exam 1Z0-829) Programmer's Guide. Oracle Press, 2023."
/>

---

## Principais características do Java

- Implementa vários paradigmas de programação
  - Programação orientada a objetos
  - Programação procedural
  - Programação funcional
- Bytecode interpretado pela Java Virtual Machine (JVM)
- Arquitetura neutra e portabilidade do ByteCode (_Write Once, run everywhere_)
- Simplicidade
- Dinâmico e ditribuído
- Robusto e seguro
- Performance e multithread

<Reference
  reference="MUGHAL, Khalid; STRELNIKOV, Vasily. OCP Oracle Certified Professional Java SE 17 Developer (Exam 1Z0-829) Programmer's Guide. Oracle Press, 2023."
/>

---

## Ferramentas Java

Java Development Kit (JDK)

- jshell: read-eval-print-loop (REPL)​
- javac: compila código java em byte code​
- java: executa uma aplicação java​
- jar: compacta os arquivos para distribuição​
- javadoc: gera documentação do código​
- jpackage: para distribuição como um executável​
- ...​
  
<ReferenceLink
  reference="https://docs.oracle.com/en/java/javase/21/docs/specs/man/index.html​"
/>

---

## O que usar para programar Java?

Ferramentas 
- Java Development Kit (JDK)
  - Instalar Java e outras ferramentas conforme orientações no [repositório da disciplina](https://github.com/fabriciosantana/poo)
  - Confirmar se o Java está instalado em sua estação de trabalho
```bash{1|2-4}
@fabriciosantana ➜ /workspaces/poo (2025.2) $ java --version
openjdk 21.0.2 2024-01-16
OpenJDK Runtime Environment (build 21.0.2+13-58)
OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
```

---

## jshell

Ambiente REPL (_Read-Eval-Print-Loop_) para aprendizado e exução rápida de código

- Iniciar o **jshell**
```bash
$ jshell
|  Welcome to JShell -- Version 21.0.2
|  For an introduction type: /help intro
jshell> 
```

- Escrever qualquer **declaração**, **instrução** ou **expressão** Java
```bash
jshell> "Hello, World!"
$1 ==> "Hello, World!"
```

- Executar comandos **jshell** começam sempre com "/"
```bash
jshell> /exit
|  Goodbye
```
---

## jshell 

Ambiente REPL (_Read-Eval-Print-Loop_) para aprendizado e exução rápida de código

- Comandos jshell

```bash
jshell>/list​
jshell>/edit [option]​
jshell>/drop {name|id|startID-endID}​
jshell>/save [options] file​
jshell>/open file​
jshell>/reload​
jshell>/reset​
jshell>/history​
jshell>/types [option]​
jshell>/vars​
jshell>/help
```
<ReferenceLink
  reference="https://docs.oracle.com/en/java/javase/21/docs/specs/man/jshell.html"
/>


---

## Por que usar o jshell?

- Permite testar código Java sem criar arquivos `.java`
- Feedback imediato para aprender sintaxe e semântica
- Ideal para explorar tipos primitivos e operadores
- Comandos úteis descritos em `README.md`
- REPL segue ciclo *Read → Evaluate → Print → Loop*
- Ambiente mantém estado entre comandos (variáveis, métodos e classes)

---
layout: backcover
---