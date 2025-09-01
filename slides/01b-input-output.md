---
layout: frontcover
transition: none
title: IDP - POO
id: aula01b
lesson: Entrada e saída de dados em programa Java
goals:
  - Conhecer os principais mecanismos de entrada e saída de dados em aplicação console
---

---
layout: default
---

## Entrada e saída

Classes Java para entrada e saída de dados

* **Entrada de dados**

    * [java.util.Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html): melhor opção para ler dados do teclado de forma simples
    * [java.io.BufferedReader](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedReader.html): mais rápido e eficiente que o Scanner      
        * [java.lang.System.in](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#in): lê bytes e não texto ou número
    * [java.io.Console](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Console.html): funciona apenas em terminais fora da IDE
    
* **Saída de dados**
    * [java.lang.System.out](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out): fluxo de saída padrão
    * [java.lang.System.err](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#err): fluxo de saída para mensagens de erro

<ReferenceLink
    link="https://docs.oracle.com/en/java/javase/21/docs/api/"
    reference="Java® Platform, Standard Edition & Java Development Kit Version 21 API Specification"
/>

---

## Entrada e saída

[java.util.Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html)

```java
Scanner input = new Scanner(System.in);

int i = input.nextInt();
double d = input.nextDouble();
float f = input.nextFloat();
boolean b = input.nextBoolean();
String s = input.next();
String x = input.nextLine();

input.close();
```

* new Scanner(System.in): cria um scanner que lê do teclado.
* input.next*(): lê os dados da entrada
* input.close(): libera o recurso quando não for mais necessário.
---

## Entrada e saída

[java.io.BufferedReader](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedReader.html)

```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String s = reader.readLine();  // lê uma linha inteira do console
```

* [System.in](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#in): fluxo de entrada padrão (teclado).
* [InputStreamReader(System.in)](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStreamReader.html): transforma os bytes em caracteres.
* [BufferedReader](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedReader.html): envolve o InputStreamReader e fornece o método readLine().
* [readLine()](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedReader.html#readLine()): → sempre retorna uma String (até o ENTER).
* Para números (int, double, etc.), é necessário converter manualmente:
    * [Integer](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html).parseInt(...)
    * [Double](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Double.html).parseDouble(...)

---

## Entrada e saída

[java.io.Console](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Console.html)

```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String s = reader.readLine();  // lê uma linha inteira do console
```
