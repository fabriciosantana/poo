### Tratamento de exceção

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

#### Descrição

Você deve criar um programa Java que simule a validação de dados ao construir objetos da classe `Phone`.
Essa classe deve representar um telefone, com nome e número de série, e validar os dados recebidos no construtor.

Se algum valor inválido for informado, uma exceção personalizada chamada `ValidationException` deve ser lançada, indicando o problema específico.
O programa principal deve instanciar objetos `Phone`, demonstrar o lançamento da exceção, e capturá-la exibindo mensagens adequadas ao usuário.

#### Especificação

1. Criar a classe `ValidationException`
* A classe deve estender a classe Exception.
* A classe deve ter dois construtores:
** um que recebe uma `String` com a mensagem de erro.
** um que receba uma `String` e uma Throwable (causa).
1. Criar a classe `Phone`
* Deve conter dois atributos privados:
** `name` do tipo `String`
** `serialNumber` do tipo `String` 
* O construtor da classe deve receber os dois valores e realizar as seguintes validações:
** Se `name` for nulo ou vazio (""), deve lançar uma ValidationException com a mensagem: "O nome do telefone não pode estar vazio."
** Se serialNumber for nulo, vazio ou não tiver exatamente 16 caracteres, deve lançar uma ValidationException com a mensagem: "O número de série deve conter exatamente 16 dígitos."
* Se os dados forem válidos, os atributos devem ser inicializados normalmente.
1. Criar a classe `PhoneApp`
* Deve conter o método main com os seguintes testes:
** Tentar criar um objeto Phone com nome vazio → capturar a exceção e imprimir a mensagem.
** Tentar criar um objeto Phone com número de série com menos de 16 dígitos → capturar e imprimir a mensagem.
** Criar um objeto Phone com dados válidos e imprimir uma mensagem de sucesso.