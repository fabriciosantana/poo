## Atividades práticas de programação em java

Nesta página você encontra:
* [Instruções gerais para entrega das atividades](#instruções-gerais-para-entrega-das-atividades)
* [Instruções para testes locais das atividades](#instruções-para-testes-locais-das-atividades)
* [Como compilar, empacotar, decompilar e executar programa java na linha de comando](#como-compilar-empacotar-decompilar-e-executar-programa-java-na-linha-de-comando)
* [Lista de atividades](#lista-de-atividades)

### Instruções gerais para entrega das atividades

* Realizar fork do repositório da disciplina
```bash
gh repo fork fabriciosantana/poo
```
* Clonar seu repositório que você acabou de clonar (substituir `seu-usuario` por seu login no github)
```bash
git clone https://github.com/seu-usuario/poo.git
```
* Adicionar o repositório original como remoto
```bash
git remote add upstream https://github.com/fabriciosantana/poo.git
```
* Verificar a configuração dos repositórios remotos
```bash
git remote -v
```

* Atualizar fork para evitar conflitos
```bash
git fetch upstream
git checkout 2025.1
git merge upstream/2025.1
```
```bash
gh repo set-default fabriciosantana/poo
```
```bash
gh repo sync
```
* Criar um diretório com seu nome e sobrenome dentro do diretório da atividade, conforme exemplo abaixo(o nome do último diretório deve ser seu nome e sobrenome em caixa baixa):
```bash
mkdir poo/assignments/00-hello/submissions/fabricio-santana/src  
```
* Desenvolver programa Java dentro do seu diretório atendendo os requisitos da especificação e os requisitos de implementação
* Comitar alterações em seu repositório
```bash
git add .   
git commit -m "minha solução da tarefa"
git push
```
* Enviar um pull request
```bash
gh pr create --base 2025.1 --head seu-usuario:2025.1 --title "Minha tarefa XXX" --body "Descrição das alterações realizadas."
```
* Observar se os testes do pull request rodaram com sucesso
* Submeter link do pull request no [ambiente virtual](https://ambientevirtual.idp.edu.br/)
* Cumprir prazo de entrega

### Instruções para testes locais das atividades

Cada atividade é acompanhada de testes unitários. Para avaliar seu código antes de submetê-lo, execute os seguintes comandos a partir de seu diretório pessoal de cada atividade

* Criar diretório para armazenar as dependências
 ```bash
 mkdir -p lib
 ```
* Baixar o junit
```bash
 curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
```
* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.
```bash
 javac -cp "lib/*" -d bin src/*.java ../../test/*.java
 ```
 * Executar testes unitários e verificar o resultado no console
 ```bash
 java -jar lib/junit-platform-console-standalone-1.11.4.jar --class-path bin --scan-class-path
 ```

### Como compilar, empacotar, decompilar e executar programa java na linha de comando

Execute os comandos abaixo para compilar, empacotar, decompilar e executar programa java na linha de comando 

* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.
```bash
javac -cp "lib/*" -d bin src/*.java test/*.java
```
* Executar programa java
```bash
java -cp bin/ HelloWorld
```
* Executar testes unitários e verificar o resultado no console
```bash
java -jar lib/junit-platform-console-standalone-1.11.4.jar execute --class-path target --scan-class-path
```
* Criar um jar com o programa
```bash
jar --create --file bin/HelloWorld.jar --main-class HelloWorld -C bin/ HelloWorld.class
```
* Executar programa java por meio do jar
```bash
java -jar bin/HelloWorld.jar
```

```bash
javap -cp bin/ -c HelloWorld
```

### Lista de atividades

|Semana| Atividades |
|---|---|
| 0 | [Hello, World!](./00-hello) |
| 1 | [Calculadora de índice de massa corporal (IMC)](./01-imc)|
|   | [Calculadora da Área de um Polígono Regular](./02-area) |
|   | [Sequência de Fibonnaci](./03-fibonacci) |
|   | [Elefante visitando amigo](./04-elephant) |
|   | [Senha forte](./05-password) |
| 2 | [Calculadora de frequência cardíaca alvo](./06-heart) |
|   | [Registro de saúde digital](./07-health) |
|   | [Palíndromos](08-palindrome) |
|   | [Conjectura de Collatz](./09-collatz) |
|   | [Mediana de três](./10-median)  |
| 3 | [Parking](./11-parking)  |
|   | [Savings Account](./12-savings) |
| 4 | [Books](./13-books)  |