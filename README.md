Trabalho 3 – Web Services (WS) / API REST
Disciplina: Sistemas Distribuídos
Alunos:

Michel Barbosa Brasil
Rian Christian Brito

1. Introdução

Este trabalho teve como objetivo reimplementar o serviço remoto desenvolvido no Trabalho 2 utilizando a arquitetura cliente-servidor baseada em Web Services (WS) ou APIs, substituindo a comunicação via RMI por comunicação HTTP. A aplicação foi desenvolvida utilizando o framework Spring Boot, permitindo a disponibilização de serviços remotos através de endpoints REST.

O sistema implementado consiste em uma API para gerenciamento de estoque de suplementos alimentares, possibilitando a consulta de produtos e a realização de compras por clientes remotos.

2. Tecnologias Utilizadas
Java 17
Spring Boot
Maven
HTTP/REST
JSON
Visual Studio Code
Git/GitHub
3. Descrição do Serviço

O serviço remoto disponibiliza operações para gerenciamento de um estoque de suplementos alimentares.

Os produtos armazenados possuem informações como:

Identificador (ID)
Nome
Preço
Quantidade em estoque
Marca

A comunicação ocorre através do protocolo HTTP utilizando mensagens em formato JSON.

4. Modelagem do Sistema
Classes Entidade

O sistema possui as seguintes entidades:

Produto

Classe base que representa um produto genérico.

Atributos:

private Long id;
private String nome;
private double preco;
private int quantidade;
Suplemento

Especialização da classe Produto.

Atributos adicionais:

private String marca;

Relação:

Suplemento é um Produto

Caracterizando herança.

Categoria

Representa categorias de suplementos.

Exemplos:

Proteínas
Creatinas
Vitaminas
Pré-Treinos
5. Arquitetura da Aplicação

A aplicação foi organizada seguindo uma arquitetura em camadas.

Cliente
   |
HTTP/JSON
   |
Controller
   |
Service
   |
Model
Controller

Responsável por receber requisições HTTP.

Service

Implementa as regras de negócio.

Model

Representa as entidades do domínio.

6. Endpoints Implementados
Listar Produtos

Método:

GET /api/produtos

Descrição:

Retorna todos os produtos cadastrados.

Exemplo de resposta:

[
  {
    "id": 1,
    "nome": "Whey Protein",
    "preco": 120.0,
    "quantidade": 10,
    "marca": "Growth"
  }
]
Consultar Produto por ID

Método:

GET /api/produtos/{id}

Descrição:

Retorna um produto específico.

Comprar Produto

Método:

POST /api/comprar

Corpo da requisição:

{
  "id": 1,
  "quantidade": 2
}

Descrição:

Reduz a quantidade disponível do produto em estoque.

7. Comunicação Cliente-Servidor

A comunicação foi implementada utilizando o padrão requisição-resposta.

Fluxo:

Cliente
   |
HTTP Request
   |
Servidor API
   |
Processamento
   |
HTTP Response
   |
Cliente

As mensagens trocadas utilizam JSON como formato de representação externa dos dados.

Exemplo:

{
  "id": 1,
  "quantidade": 2
}
8. Testes Realizados

Foram realizados testes através do navegador e do PowerShell.

Exemplo de requisição:

Invoke-RestMethod `
-Uri "http://localhost:8080/api/comprar" `
-Method Post `
-ContentType "application/json" `
-Body '{"id":1,"quantidade":2}'

Resultado:

Produto encontrado.
Quantidade reduzida corretamente.
Resposta retornada ao cliente.

Também foram realizados testes para:

Consulta de produtos.
Consulta individual por ID.
Compra de produtos.
Verificação de estoque insuficiente.

Todos os testes executados obtiveram sucesso.

9. Diferenças em Relação ao Trabalho 2

No Trabalho 2 a comunicação foi implementada através de Remote Method Invocation (RMI).

No Trabalho 3 a comunicação passou a utilizar HTTP e APIs REST.

Principais vantagens da API:

Independência de linguagem.
Facilidade de integração.
Uso de padrões amplamente adotados na indústria.
Comunicação baseada em JSON.

Dessa forma, clientes desenvolvidos em linguagens diferentes, como Python e JavaScript, podem consumir os serviços disponibilizados pelo servidor Java.

10. Conclusão

O objetivo do trabalho foi alcançado com sucesso através da implementação de uma API REST utilizando Spring Boot.

A aplicação permitiu a disponibilização de serviços remotos para gerenciamento de estoque de suplementos alimentares utilizando comunicação cliente-servidor baseada em HTTP.

A utilização de JSON como representação externa dos dados garantiu interoperabilidade entre diferentes linguagens de programação, atendendo aos requisitos da proposta.

Além disso, a arquitetura desenvolvida servirá como base para futuras evoluções do sistema distribuído, incluindo mecanismos de comunicação indireta e processamento assíncrono.
