---
layout: frontcover
transition: none
title: IDP - POO
id: aula01a
lesson: Configuração de ambiente, visão geral do github e procedimento para submissão de tarefas
goals:
  - Configurar estação de desenvolvimento
  - Conhecer o github e procedimento para submissão de tarefas
  - Desenvolver, compilar, executar e testar programa Hello, World!
  - Submeter programa para o repositório da disciplina
---

---
layout: default
---

## Ferramentas para estação de desenvolvimento

<div class="text-xs mt-2 grid grid-cols-2 ">

<div>

- Revisar o [repositório da disciplina](https://github.com/fabriciosantana/poo/) no GitHub: todas as informações estarão lá!​
  - Ver instruções para instalação das ferramentas no diretório **howto**
- Preparar sua estação para desenvolvimento Java​
  - Sugestão: usar Linux para as atividades práticas​
    - [WSL​](https://learn.microsoft.com/pt-br/windows/wsl/install)
    - [GitHub Codespaces​](https://github.com/features/codespaces)
    - [Docker](https://code.visualstudio.com/docs/devcontainers/containers)
  - [VS Code](https://code.visualstudio.com/) e extensões Java (sugestão, há dezenas de IDEs)​
  - [JDK 21](https://docs.oracle.com/en/java/javase/21/) (sugestão: [OpenJDK](https://openjdk.org/), há dezenas de distribuição do JDK)​
  - [GitHub​](https://github.com/)
  - [SDKMAN](https://sdkman.io/) (pra quem precisa trabalhar com várias versões do JDK)​
  - [Junit 5​](https://junit.org/junit5/)
  - [Maven​](https://maven.apache.org/)
  
</div>

<div class="ml-20">

- Informações adicionais
  - [Introduction to Linux​](https://training.linuxfoundation.org/training/introduction-to-linux/)
  - [Getting started with Visual Studio Code​](https://code.visualstudio.com/docs/introvideos/basics)
  - [Intro to GitHub​](https://education.github.com/experiences/intro_to_github)
  - [GitHub Foundations (Microsoft)​](https://education.github.com/experiences/intro_to_github)

</div>

</div>

--- 

## Fluxo de trabalho para submissão de tarefas

<FigureWithCaption 
  src="images/git.png" 
  alt="Fluxo para envio de tarefas"
  link="http://github.com/fabriciosantana"
/>

--- 

## Primeiro programa Java

[Write Once, run everywhere](https://en.wikipedia.org/wiki/Write_once,_run_anywhere)

<FigureWithCaption
  src="images/hello.png"
  alt="Desenvolvendo programa Java"
  reference="SEDEGWICK, Robert; WAYNE, Kevin. Computer Science: An Interdisciplinary Approach. Boston: Addison-Wesley Professional, 2016."
/>

--- 

## Primeiro programa Java

Desenvolver código do programa HelloWorld
```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
  }
}
```
Compilar programa no terminal 

```bash
javac HelloWorld.java
```

Executar programa no terminal

```bash
java HelloWorld
"Hello, World!"
```

--- 

## Primeiro programa Java

Adicionar arquivo no controle de versão
```bash
git add HelloWorld.java
```

Enviar (comitar) arquivo no respositório
```bash
git commit -m "Programa HelloWorld"
```

Enviar alteração para o repositório
```bash
git push
```

Enviar pull request usando a interface web do github.com

---
layout: backcover
---