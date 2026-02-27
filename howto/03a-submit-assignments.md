### Instruções gerais para entrega das atividades

* Criar um diretório com seu nome e sobrenome dentro do diretório da atividade, conforme exemplo abaixo(o nome do último diretório deve ser seu nome e sobrenome em caixa baixa):
```bash
mkdir poo/assignments/01-programming/00-hello/submissions/fabricio-santana/src  
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
gh pr create --base 2026.1 --head seu-usuario:2026.1 --title "Minha tarefa XXX" --body "Descrição das alterações realizadas."
```
* Observar se os testes do pull request rodaram com sucesso
* Submeter link do pull request no [ambiente virtual](https://ambientevirtual.idp.edu.br/)
* Cumprir prazo de entrega conforme ambiente virtual