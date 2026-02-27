## Eliminar nomes duplicados

Desenvolva um programa que permita ao usuário cadastrar uma lista de nomes, armazenando-os de forma que não haja nomes duplicados, e possibilite pesquisar por nome posteriormente.

### Especificação de Requisitos

#### Requisitos de Negócio

1. O sistema deve permitir ao usuário digitar uma série de nomes próprios (primeiros nomes).
2. Os nomes devem ser armazenados sem duplicação.
3. O sistema deve permitir ao usuário pesquisar por um nome e informar se ele está ou não na coleção.
4. A entrada de nomes deve ser encerrada por um valor especial (por exemplo, `"fim"`).
5. A pesquisa por nomes pode ser feita múltiplas vezes até o usuário encerrar com outro comando (ex: `"sair"`).

#### Requisitos Técnicos

* Utilizar a interface `Set` para armazenar os nomes, com uma implementação concreta como `HashSet` ou `TreeSet`.
* Utilizar `Scanner` para entrada de dados do usuário via terminal.
* Os nomes devem ser tratados de forma **case-insensitive** (por exemplo, "ana" e "Ana" devem ser considerados iguais).
* Ao final, o programa deve:
  * Exibir todos os nomes cadastrados (ordenados se usar `TreeSet`).
  * Permitir buscas repetidas até o comando `"sair"`.

#### Exemplo de Execução

```
Digite os nomes (digite 'fim' para encerrar):
> Ana
> Bruno
> ana
> Carlos
> FIM

Nomes cadastrados:
[Ana, Bruno, Carlos]

Pesquisar nomes (digite 'sair' para encerrar):
> bruno
Nome encontrado.
> joão
Nome não encontrado.
> sair
```