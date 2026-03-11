---
layout: frontcover
transition: none
title: IDP - POO
id: aula03
lesson: Elementos da linguagem Java
goals:
  - Reconhecer os elementos da linguagem Java
  - Executar no jshell comandos da linguagem Java
---

---
layout: default
lesson: Plataforma e linguagem Java
---

## Elementos da linguagem Java

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- _operators​_

</div>

<div>
</div>

</div>

---

## Elementos da linguagem Java - _identifiers_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- **_identifiers​_**
- _keywords​_
- _literals​_
- _separators​_
- _operators​_

</div>

<div>

- composto por uma sequência de caracteres, letras ou números
- deve iniciar com letra
- case sensitive

<FigureWithCaption
    src="images/identifiers.png"
    alt="Java identifiers"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.8"
/>

</div>

</div>

---

## Elementos da linguagem Java - _keywords_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- **_keywords​_**
- _literals​_
- _separators​_
- _operators​_


</div>

<div>

- palavras reservadas: não podem ser usados como identificadores
- _literals_ pré-definidos: _true_, _false_, _null_

<FigureWithCaption
    src="images/keywords.png"
    alt="Java keywords"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.9"
/>

</div>

</div>

---

## Elementos da linguagem Java - _literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

- representa um valor constante, podendo ser:
    - número: inteiro ou decimal
    - caractere: 'A'
    - booleano: _true_ ou _false_
    - string (texto): "Abc"

<FigureWithCaption
    src="images/literals.png"
    alt="Java literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.10"
/>

</div>

</div>

---

## Elementos da linguagem Java - _integer literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/literalsInteger.png"
    alt="Java integer literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-IntegerLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _integer literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

```bash
jshell> 10 // decimal integer literal
$1 ==> 10

jshell> 0X10 // hexadecimal integer literal
$2 ==> 16

jshell> 010 // octal integer literal
$3 ==> 8

jshell> 0B10 // binary integer literal
$4 ==> 2
```

</div>

</div>

---

## Elementos da linguagem Java - _floating point literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/literalsFloating.png"
    alt="Java floating point literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.10.2"
/>

</div>

</div>

---

## Elementos da linguagem Java - _floating point literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

```bash
jshell> 10F // decimal float literal
$1 ==> 10.0

jshell> 10E2F // decimal float literal
$2 ==> 1000.0

jshell> 10.0F // decimal float literal
$3 ==> 10.0

jshell> 10.0 // decimal double literal
$4 ==> 10.0

jshell> 10D // decimal double literal
$5 ==> 10.0

jshell> 10E2 // decimal double literal
$6 ==> 1000.0
```

</div>

</div>

---

## Elementos da linguagem Java - _boolean literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/literalsBoolean.png"
    alt="Java boolean literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-BooleanLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _boolean literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

```bash
jshell> true // boolean literal
$1 ==> true

jshell> false // boolean literal
$2 ==> false
```

</div>

</div>

---

## Elementos da linguagem Java - _character literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/literalsCharacter.png"
    alt="Java character literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-CharacterLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _character literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

```bash
jshell> 'A'
$1 ==> 'A'

jshell> 'a'
$2 ==> 'a'

jshell> '$'
$3 ==> '$'

jshell> '\u0024'
$4 ==> '$'
```

</div>

</div>

---

## Elementos da linguagem Java - _String literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/literalsString.png"
    alt="Java string literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-StringLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _String literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

```bash
jshell> ""
$1 ==> ""

jshell> "Programação Orientada a Objetos"
$2 ==> "Programação Orientada a Objetos"

jshell> "Programação " + 
   ...> "Orientada a " +
   ...> "Objetos" +
$3 ==> "Programação Orientada a Objetos"
```

</div>

</div>

---

## Elementos da linguagem Java - _separators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- **_separators​_**
- _operators​_

</div>

<div>

- _tokens_ que possuem significado de acordo com o contexto

<FigureWithCaption
    src="images/separators.png"
    alt="Java separators"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.11"
/>

</div>

</div>

---

## Elementos da linguagem Java - _separators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- **_separators​_**
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/separatorsDetails.png"
    alt="Java separators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>


---

## Elementos da linguagem Java - _operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**

</div>

<div>

- aritiméticos
- relacionais
- lógicos
- bitwise

<FigureWithCaption
    src="images/operators.png"
    alt="Java operators"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.12"
/>

</div>

</div>

---

## Elementos da linguagem Java - _arithmetic operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - **_arithmetic_**
    - _relacional_
    - _logical_
    - _bitwise_

</div>

<div>

<FigureWithCaption
    src="images/operatorsArithmetic.png"
    alt="Java arithmetic operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _arithmetic operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - **_arithmetic_**
    - _relacional_
    - _logical_
    - _bitwise_

</div>

<div>

```bash
jshell> 10 + 10 // adição
$1 ==> 20

jshell> 10 - 10 // subtração
$2 ==> 0

jshell> 10 * 10 // multiplicação
$3 ==> 100

jshell> 10 / 10 // divisão
$4 ==> 1

jshell> 23 % 10 // módulo
$5 ==> 3

jshell> 10 + 0B1010 + 012 + 0XA // bases diferentes
$6 ==> 40
```

</div>

</div>

---

## Elementos da linguagem Java - _relational operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - **_relacional_**
    - _logical_
    - _bitwise_


</div>

<div>

<FigureWithCaption
    src="images/operatorsRelational.png"
    alt="Java relational operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _relational operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - **_relacional_**
    - _logical_
    - _bitwise_

</div>

<div>

```bash
jshell> 1 + 1 == 2 // igual a
$1 ==> true

jshell> 1 + 1 ! = 3 // diferente de  
$2 ==> true

jshell> 1 + 1 > 3 // maior que
$3 ==> false

jshell> 1 + 1 < 3 // menor que
$4 ==> true

jshell> 1 + 1 > = 2 // maior ou igual que
$5 ==> true

jshell> 1 + 1 < = 2 // menor ou igual que
$6 ==> true
```

</div>

</div>

---

## Elementos da linguagem Java - _logical operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - _relacional_
    - **_logical_**
    - _bitwise_

</div>

<div>

<FigureWithCaption
    src="images/operatorsBooleanLogical.png"
    alt="Java boolean logical operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _logical operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - _relacional_
    - **_logical_**
    - _bitwise_

</div>

<div>

```bash
jshell> 1 + 1 == 2 && 1 - 1 != 2 // E
$1 ==> true

jshell> 1 + 1 == 2 || 1 - 1 > 2 // OU
$2 ==> true

jshell> 1 + 1 == 2 && 1 - 1 > 2
$3 ==> false

jshell> 1 + 1 == 2 ^ 1 - 1 > 2 // OU exclusivo
$4 ==> true

jshell> 1 + 1 == 2 ^ 1 - 1 < 2 // igual a 
$5 ==> false

jshell> 1 + 1 == 2 ? true : false // op. ternário
$6 ==> true
```

</div>

</div>

---

## Elementos da linguagem Java - _bitwise operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - _relacional_
    - _logical_
    - **_bitwise_**

</div>

<div>

<FigureWithCaption
    src="images/operatorsBitwise.png"
    alt="Java bitwise operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _bitwise operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - _relacional_
    - _logical_
    - **_bitwise_**

</div>

<div>

```bash
jshell> 0B10  // 0B00000000000000000000000000000010
$1 ==> 2 

jshell> ~0B10 // 0B11111111111111111111111111111101
$2 ==> -3 

jshell> 0B101 & 0B100 // 0B100
$3 ==> 4

jshell> 0B101 ^ 0B100 //0B001
$4 ==> 1

jshell> 0B101 | 0B100 //0B101
$5 ==> 5

jshell> 0B101>>1 // 0B10
$6 ==> 2

jshell> 0B101<<1 // 0B1010
$7 ==> 10
```
</div>

</div>

--- 

## Elementos da linguagem Java

<div class="mt-4 grid grid-cols-2">
<div>

- _Data Types_

- _Variables_

- _Declarations_

- _Statements_

</div>

</div>

--- 

## Elementos da linguagem Java - _Data Types_

<div class="mt-4 grid grid-cols-2">
<div>

- **_Data Types_**
    - **_Primitive types_**: 
        - são os tipos de dados mais básicos​
        - Java possui 8 tipos primitivos
    - **_Reference types_**
        - _built-in_ x _custom_
- _Variables_
- _Declarations_
- _Statements_

</div>

<div>

- **_Primitive types_**

<div class="grid grid-cols-2 border border-gray-300 text-center text-base w-full">
  <!-- Cabeçalho -->
  <div class="bg-blue-700 text-white font-bold p-2 border-r border-white">
    Números inteiros<br/><em>(Integers)</em>
  </div>
  <div class="bg-blue-700 text-white font-bold p-2">
    Números reais ou de ponto flutuante<br/><em>(floating-point numbers)</em>
  </div>

  <!-- Conteúdo números inteiros -->
  <div class="bg-blue-50 p-4 border-t border-gray-300 border-r">
    byte<br/>
    short<br/>
    <strong>int</strong><br/>
    long
  </div>

  <!-- Conteúdo números reais -->
  <div class="bg-blue-50 p-4 border-t border-gray-300">
    <br/>
    <strong>float</strong><br/>
    <strong>double</strong>
  </div>

  <!-- Cabeçalho inferior -->
  <div class="col-span-1 bg-blue-700 text-white font-bold p-2 border-t border-white">
    Caractere
  </div>
  <div class="col-span-1 bg-blue-700 text-white font-bold p-2 border-t border-white">
    Valor booleano
  </div>

  <!-- Conteúdo inferior -->
  <div class="bg-blue-50 p-4 border-t border-gray-300 border-r">
    char
  </div>
  <div class="bg-blue-50 p-4 border-t border-gray-300">
    boolean
  </div>
</div>

</div>

</div>

--- 

## Elementos da linguagem Java - _Data Types_

<div class="mt-4 grid grid-cols-2">
<div>

- **_Data Types_**
    - **_Primitive types_**: 
        - são os tipos de dados mais básicos​
        - Java possui 8 tipos primitivos
    - **_Reference types_**
        - _built-in_ x _custom_
- _Variables_
- _Declarations_
- _Statements_

</div>

<div>

- **_Primitive types Wrappers_**

<div class="grid grid-cols-2 text-center text-black border border-gray-300 text-sm">
  <!-- Cabeçalho -->
  <div class="bg-blue-700 text-white font-bold p-2 border border-white">
    Tipo Primitivo
  </div>
  <div class="bg-blue-700 text-white font-bold p-2">
    Classe Wrapper
  </div>

  <!-- Linha 1 -->
  <div class="bg-blue-50 p-1 border border-gray-300">byte</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Byte.html" class="underline text-blue-600" target="_blank">Byte</a>
  </div>

  <!-- Linha 2 -->
  <div class="bg-blue-50 p-1 border border-gray-300">short</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html" class="underline text-blue-600" target="_blank">Short</a>
  </div>

  <!-- Linha 3 -->
  <div class="bg-blue-50 p- border border-gray-300">char</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html" class="underline text-blue-600" target="_blank">Character</a>
  </div>

  <!-- Linha 4 -->
  <div class="bg-blue-50 p-1 border border-gray-300">int</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html" class="underline text-blue-600" target="_blank">Integer</a>
  </div>

  <!-- Linha 5 -->
  <div class="bg-blue-50 p-1 border border-gray-300">long</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html" class="underline text-blue-600" target="_blank">Long</a>
  </div>

  <!-- Linha 6 -->
  <div class="bg-blue-50 p-1 border border-gray-300">float</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Float.html" class="underline text-blue-600" target="_blank">Float</a>
  </div>

  <!-- Linha 7 -->
  <div class="bg-blue-50 p-1 border border-gray-300">double</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html" class="underline text-blue-600" target="_blank">Double</a>
  </div>

  <!-- Linha 8 -->
  <div class="bg-blue-50 p-1 border border-gray-300">boolean</div>
  <div class="bg-blue-50 p-1 border border-gray-300">
    <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html" class="underline text-blue-600" target="_blank">Boolean</a>
  </div>
</div>


</div>

</div>

---

## Elementos da linguagem Java - _Data Types_

Tamanho dos tipos primitivos

<div class="grid grid-cols-5 text-center text-xs border border-gray-300">
  <!-- Cabeçalhos -->
  <div class="bg-blue-700 text-white font-bold p-2 border border-white">Tipo Primitivo</div>
  <div class="bg-blue-700 text-white font-bold p-2 border border-white">Tamanho<br>(em bits)</div>
  <div class="bg-blue-700 text-white font-bold p-2 border border-white">Mínimo</div>
  <div class="bg-blue-700 text-white font-bold p-2 border border-white">Máximo</div>
  <div class="bg-blue-700 text-white font-bold p-2">Qtd. números</div>

  <!-- Linha: byte -->
  <div class="bg-blue-50 p-1 border border-gray-300">byte</div>
  <div class="bg-blue-50 p-1 border border-gray-300">8</div>
  <div class="bg-blue-50 p-1 border border-gray-300">-128 (-2⁷)</div>
  <div class="bg-blue-50 p-1 border border-gray-300">127 (2⁷-1)</div>
  <div class="bg-blue-50 p-1 border border-gray-300">2⁸ = 256</div>

  <!-- Linha: short -->
  <div class="bg-blue-100 p-1 border border-gray-300">short</div>
  <div class="bg-blue-100 p-1 border border-gray-300">16</div>
  <div class="bg-blue-100 p-1 border border-gray-300">-32.768 (-2¹⁵)</div>
  <div class="bg-blue-100 p-1 border border-gray-300">32.767 (2¹⁵-1)</div>
  <div class="bg-blue-100 p-1 border border-gray-300">2¹⁶ = 65.536</div>

  <!-- Linha: int -->
  <div class="bg-blue-50 p-1 border border-gray-300">int</div>
  <div class="bg-blue-50 p-1 border border-gray-300">32</div>
  <div class="bg-blue-50 p-1 border border-gray-300">-2.147.483.648 (-2³¹)</div>
  <div class="bg-blue-50 p-1 border border-gray-300">2.147.483.647 (2³¹-1)</div>
  <div class="bg-blue-50 p-1 border border-gray-300">2³² = 4.294.967.296</div>

  <!-- Linha: long -->
  <div class="bg-blue-100 p-1 border border-gray-300">long</div>
  <div class="bg-blue-100 p-1 border border-gray-300">64</div>
  <div class="bg-blue-100 p-1 border border-gray-300">-9.223.372.036.854.775.808</div>
  <div class="bg-blue-100 p-1 border border-gray-300">9.223.372.036.854.775.807</div>
  <div class="bg-blue-100 p-1 border border-gray-300">2⁶⁴ = 18.446.744.073.709.551.616</div>

  <!-- Linha: float -->
  <div class="bg-blue-50 p-1 border border-gray-300">float</div>
  <div class="bg-blue-50 p-1 border border-gray-300">32</div>
  <div class="bg-blue-50 p-1 border border-gray-300">1.40129846432481707e−45</div>
  <div class="bg-blue-50 p-1 border border-gray-300">3.4028234663852886E+38</div>
  <div class="bg-blue-50 p-1 border border-gray-300"></div>

  <!-- Linha: double -->
  <div class="bg-blue-100 p-1 border border-gray-300">double</div>
  <div class="bg-blue-100 p-1 border border-gray-300">64</div>
  <div class="bg-blue-100 p-1 border border-gray-300">4.94065645841246544e−324</div>
  <div class="bg-blue-100 p-1 border border-gray-300">1.7976931348623157E+308</div>
  <div class="bg-blue-100 p-1 border border-gray-300"></div>

  <!-- Linha: boolean -->
  <div class="bg-blue-50 p-1 border border-gray-300">boolean</div>
  <div class="bg-blue-50 p-1 border border-gray-300"></div>
  <div class="bg-blue-50 p-1 border border-gray-300"></div>
  <div class="bg-blue-50 p-1 border border-gray-300">true or false</div>
  <div class="bg-blue-50 p-1 border border-gray-300"></div>

  <!-- Linha: char -->
  <div class="bg-blue-100 p-1 border border-gray-300">char</div>
  <div class="bg-blue-100 p-1 border border-gray-300">16</div>
  <div class="bg-blue-100 p-1 border border-gray-300">\u0000</div>
  <div class="bg-blue-100 p-1 border border-gray-300">\uFFFF</div>
  <div class="bg-blue-100 p-1 border border-gray-300">2¹⁶ = 65.536</div>
</div>

---

## Elementos da linguagem Java - _Data Types_

Tamanho dos tipos primitivos

- Como inteiros com sinal são representados no computador? [Two’s complement​](https://en.wikipedia.org/wiki/Two%27s_complement)
    - Exemplo 8 bits:​
        * 5:  00000101​
        * -5: 11111011 (inverte-se os bits da representação positiva e soma-se 1)​

--- 

## Elementos da linguagem Java - **_Variables_**

<div class="mt-4 grid grid-cols-2">
<div>

- _Data Types_

- **_Variables_**

- _Declarations_

- _Statements_

</div>

<div>

- type identifier [ = value ][, identifier [= value ] ...];
- toda variável tem um tipo, um nome (identificador), um tamanho (bytes) e um valor​
-  inferência de tipo para variável local (var v = 1;)​
- escopo e inicialização
- conversão de tipos

</div>

</div>

--- 

## Elementos da linguagem Java

<div class="mt-4 grid grid-cols-1">
<div>

- **_identifiers_**: nomes que identificam variáveis, classes, métodos, etc.​
- **_keywords_**: não podem ser usadas como identificadores​
- **_literals_**: representação do valor de um tipo primitivo, String ou null​
- **_separators_**: separam trechos de código​
- **_operators_**: realizam operações sobre variáveis e valores (literals)​

- **_variables_**: local na memória para armazenar valor de certo tipo​
- **_data types_**: primitive type e reference type​

- **_declarations_**: int x;​
- **_expressions_**: x + 5;​
- **_statements_**: int y = x + 5​

</div>

</div>

--- 

## 1ª Atividade

- Implementar os programas​ de acordo com especificação disponível no repositório da disciplina
  - Calculadora de índice de massa corporal (IMC)​
  - Calculadora da Área de um Polígono Regular​
  - Sequência de Fibonnaci​
  - Elefante visitando amigo​
  - Senha forte

- Prazo: conforme ambiente virtual

---
layout: backcover
---
