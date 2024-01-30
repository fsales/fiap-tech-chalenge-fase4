![GitHub](https://img.shields.io/github/license/fsales/fiap-tech-chalenge-fase4)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/fsales/fiap-tech-chalenge-fase4)
![GitHub language count](https://img.shields.io/github/languages/count/fsales/fiap-tech-chalenge-fase4)
![GitHub top language](https://img.shields.io/github/languages/top/fsales/fiap-tech-chalenge-fase4)
![GitHub issues](https://img.shields.io/github/issues/fsales/fiap-tech-chalenge-fase4)
[![Create release](https://github.com/fsales/fiap-tech-chalenge-fase4/actions/workflows/create-release.yml/badge.svg)](https://github.com/fsales/fiap-tech-chalenge-fase4/actions/workflows/create-release.yml)
[![Publish Image Registry - Branch Develop](https://github.com/fsales/fiap-tech-chalenge-fase4/actions/workflows/git-flow-publish-image-develop.yml/badge.svg)](https://github.com/fsales/fiap-tech-chalenge-fase4/actions/workflows/git-flow-publish-image-develop.yml)


<p align="center">
 <img src="https://img.shields.io/static/v1?label=GitHub&message=@fsales&color=8257E5&labelColor=000000" alt="@fsales" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Tech%20Chalenge&color=8257E5&labelColor=000000" alt="Tech Chalenge" />
</p>

# :bookmark_tabs: Tech Chalenge

- [:bookmark\_tabs: Tech Chalenge](#bookmark_tabs-tech-chalenge)
  - [🛠️ Linguagem e ferramentas](#️-linguagem-e-ferramentas)
  - [🏫 Dados Acadêmicos](#-dados-acadêmicos)
    - [🏬 Instituição](#-instituição)
    - [🧑🏻‍🎓Curso](#curso)
    - [Aluno](#aluno)
  - [Pré-requisitos](#pré-requisitos)
  - [Como Executar](#como-executar)
    - [IDE de desenvolvimento](#ide-de-desenvolvimento)
  - [Clean Architecture](#clean-architecture)
    - [Organização do Projeto](#organização-do-projeto)
    - [Consideração](#consideração)
    - [:hammer: Funcionalidades do projeto](#hammer-funcionalidades-do-projeto)
  - [Nexstream - Sistema de compartilhamento de videos](#nexstream---sistema-de-compartilhamento-de-videos)
    - [Endpoints](#endpoints)
- [API de Categoria](#api-de-categoria)
  - [Criar Categoria](#criar-categoria)
    - [\[POST\] /categorias](#post-categorias)
  - [Detalhar Categoria](#detalhar-categoria)
    - [\[GET\] /categorias/{id}](#get-categoriasid)
- [API de Vídeo](#api-de-vídeo)
  - [Criar Vídeo](#criar-vídeo)
    - [\[POST\] /videos](#post-videos)
  - [Atualizar Vídeo](#atualizar-vídeo)
    - [\[PUT\] /videos](#put-videos)
  - [Detalhar Vídeo](#detalhar-vídeo)
    - [\[GET\] /videos/{id}](#get-videosid)
  - [Listar Vídeo](#listar-vídeo)
    - [\[GET\] /videos](#get-videos)
  - [Excluir Vídeo](#excluir-vídeo)
    - [\[DELETE\] /videos/{id}](#delete-videosid)
  - [Desafio encontrado durante o desenvolvimento](#desafio-encontrado-durante-o-desenvolvimento)
  - [Referência](#referência)
  

> Tech Challenge para avaliação da Fase IV da Pós Graduação em Arquitetura e Desenvolvimento Java.

## 🛠️ Linguagem e ferramentas

[![logo java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=kofi&logoColor=white)](#)

[![logo mongodb](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/)

[![logo spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![logo spring-boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)

[![logo git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![logo github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com)
[![logo github action](https://img.shields.io/badge/Github%20Actions-282a2e?style=for-the-badge&logo=githubactions&logoColor=367cfe)](https://docs.github.com/pt/actions)

[![logo eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)](https://www.eclipse.org/)
[![logo intellij](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/pt-br/idea/)

[![logo curl](https://img.shields.io/badge/curl-093754.svg?style=for-the-badge&logo=curl-idea&logoColor=white)](https://curl.se/)
[![logo Google-chrome](https://img.shields.io/badge/Google_chrome-4285F4?style=for-the-badge&logo=Google-chrome&logoColor=white)](https://www.google.pt/intl/pt-PT/chrome/?brand=FHFK&gclid=CjwKCAjwnOipBhBQEiwACyGLuu4mCvDZcz9NfyfYpBcLdbDQXuIG2WbyC85RYuP3SLSiNGUcNE9hyRoCXxkQAvD_BwE&gclsrc=aw.ds)
[![logo postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)](https://www.postman.com/)
[![logo swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)](https://swagger.io/)

## 🏫 Dados Acadêmicos

### 🏬 Instituição

Faculdade FIAP

### 🧑🏻‍🎓Curso

Pós-Graduação em Arquitetura e Desenvolvimento Java

### Aluno

| [<img src="https://avatars.githubusercontent.com/u/816101?v=4" width=115><br><sub>Fábio de Oliveira Sales</sub>](https://github.com/fsales) |
| :---: |

[![Linkedin Badge](https://img.shields.io/badge/-Fábio%20Sales-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/fabio-oliveira-sales/)](https://www.linkedin.com/in/fabio-oliveira-sales/)
[![Gmail Badge](https://img.shields.io/badge/-fabio.oliveira.sales@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:fabio.oliveira.sales@gmail.com)](mailto:fabio.oliveira.sales@gmail.com)

## Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:

- Java 17
- Git
- Docker
- IDE de desenvolvimento:
  - Eclipse
  - IntelliJ IDEA
  - VSCode
  - Outras
- Navegador:
  - Google Chrome
  - Outro
- Postman, CURL ou utilize o Swagger

## Como Executar

1. Abrir o terminal

- Git Bash
- CMD
- Bash
- Outros

2. **Clonar repositório.**
  git [https://github.com/fsales/fiap-tech-chalenge-fase4.git](https://github.com/fsales/fiap-tech-chalenge-fase4.git).

```sh
git clone  https://github.com/fsales/fiap-tech-chalenge-fase4.git  fiap-tech-chalenge-fase4
```

### IDE de desenvolvimento

1. **Acessar o diretório** `fiap-tech-chalenge-fase4/nex-stream`.

```sh
cd  /fiap-tech-chalenge-fase4/nex-stream
```

2. **Construir o projeto utilizando o maven.**

```sh
./mvnw clean package
```

## Clean Architecture
A Arquitetura Limpa[^1], proposta por Robert C. Martin, visa criar sistemas de software bem estruturados e fáceis de manter. Os principais pontos são:

1. Divisão em Camadas: Organização em camadas concêntricas para separar responsabilidades.
2. Princípio da Dependência: As dependências apontam para dentro, mantendo a independência das camadas.
3. Entidades: Representam as principais estruturas de dados e regras de negócio.
4. Casos de Uso: Orquestram a interação entre entidades, contendo as regras de negócio específicas.
5. Interfaces de Usuário: Representam as interfaces com o mundo exterior.
6. Frameworks e Drivers: Camadas mais externas com detalhes de implementação específicos.

### Organização do Projeto
<details>
  <summary>Organização do Projeto Nexstream</summary>

```
└───nexstream
    ├───domain
    │   └───core
    │       ├───categoria
    │       │   ├───dto
    │       │   ├───model
    │       │   └───repository
    │       ├───page
    │       └───video
    │           ├───dto
    │           ├───model
    │           └───repository
    ├───infrastructure
    │   ├───database
    │   │   └───mongo
    │   │       ├───adapter
    │   │       ├───entity
    │   │       ├───mapper
    │   │       └───repository
    │   │           └───impl
    │   ├───spring
    │   │   └───handler
    │   └───swagger
    ├───presentation
    │   └───rest
    │       ├───controller
    │       │   ├───categoria
    │       │   │   └───swagger
    │       │   └───video
    │       │       └───swagger
    │       ├───dto
    │       │   ├───categoria
    │       │   │   ├───request
    │       │   │   │   └───swagger
    │       │   │   └───response
    │       │   │       └───swagger
    │       │   └───video
    │       │       ├───request
    │       │       │   └───swagger
    │       │       └───response
    │       │           └───swagger
    │       ├───exception
    │       │   └───handler
    │       │       └───dto
    │       │           └───serializacao
    │       ├───mapper
    │       │   ├───categoria
    │       │   └───video
    │       └───validation
    │           └───groups
    └───usecase
        ├───categoria
        │   ├───dto
        │   └───impl
        └───video
            ├───dto
            └───impl
```

</details>

### Consideração
> O desenvolvimento deste projeto foi influenciado pelos princípios da Clean Architecture, promovendo uma estrutura modular e organizada. Embora a aplicação desses princípios tenha sido adaptada às necessidades específicas do projeto, a abordagem da Clean Architecture foi considerada durante a concepção da arquitetura do sistema.

### :hammer: Funcionalidades do projeto
- `API de Vídeo`: Uma API de compartilhamento de vídeos que possibilita a criação, atualização, listagem e exclusão.

## Nexstream - Sistema de compartilhamento de videos

### Endpoints

> Para fazer as requisições HTTP pode ser utilizado:

1. [Swagger](http://127.0.0.1:8080/webjars/swagger-ui/index.html)

2. [CURL](https://curl.se/docs/manual.html)

# API de Categoria

## Criar Categoria
![](/doc/img/api-categoriasswagger.PNG)
### [POST] /categorias

1. Swagger

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Categoria#/Api%20de%20Categoria/cadastrar
```

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/categorias' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "titulo": "Comédia"
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "id": "65b84b73ea1ea52f1e38037c",
  "titulo": "Comédia"
}
```

</details>

## Detalhar Categoria
![](/doc/img/api-categoriasswagger-get.PNG)

### [GET] /categorias/{id}

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Categoria#/Api%20de%20Categoria%20-%20GET/detalhar
```

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/categorias/65b84b73ea1ea52f1e38037c' \
  -H 'accept: */*'
```

<summary>Resposta</summary>

```json
{
  "id": "65b84b73ea1ea52f1e38037c",
  "titulo": "Comédia"
}
```

# API de Vídeo

## Criar Vídeo

![](/doc/img/api-videos-swagger.PNG)
### [POST] /videos

1. Swagger

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Video#/API%20de%20Video/cadastrar
```

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/videos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "titulo": "Oppenheimer",
  "descricao": "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.",
  "categoria": "Drama",
  "url": "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA"
}'
```

<details>

<summary>Resposta</summary>

```json
{
  "id": "65b846cf547b2f431b1f7e82",
  "titulo": "Oppenheimer",
  "descricao": "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.",
  "url": "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA",
  "categoria": "Drama",
  "dataPublicacao": "29/01/2024"
}
```

</details>

## Atualizar Vídeo
![](/doc/img/api-videos-put-swagger.PNG)
### [PUT] /videos

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Video#/API%20de%20Video/atualizar
```

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/videos/65b846cf547b2f431b1f7e82' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "titulo": "Oppenheimer",
  "descricao": "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.",
  "categoria": "Drama",
  "url": "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA"
}'
```
<details>

<summary>Resposta</summary>

```json
{
  "id": "65b846cf547b2f431b1f7e82",
  "titulo": "Oppenheimer",
  "descricao": "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.",
  "url": "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA",
  "categoria": "Drama",
  "dataPublicacao": "29/01/2024"
}
```

</details>


## Detalhar Vídeo
![](/doc/img/api-videos-get-swagger.PNG)

### [GET] /videos/{id}

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Video#/API%20de%20Video%20-%20GET/detalhar
```

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/videos/65b846cf547b2f431b1f7e82' \
  -H 'accept: */*'
```

<summary>Resposta</summary>

```json
{
  "id": "65b846cf547b2f431b1f7e82",
  "titulo": "Oppenheimer",
  "descricao": "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.",
  "url": "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA",
  "categoria": "Drama",
  "dataPublicacao": "29/01/2024"
}
```

</details>

## Listar Vídeo
![](/doc/img/api-videos-get-all-swagger.PNG)

### [GET] /videos

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Video#/API%20de%20Video%20-%20GET/listarTodos
```

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/videos?titulo=Oppenheimer&descricao=A%20hist%C3%B3ria%20do%20envolvimento%20de%20J.%20Robert%20Oppenheimer%20na%20cria%C3%A7%C3%A3o%20da%20bomba%20at%C3%B3mica%20durante%20a%20Segunda%20Guerra%20Mundial.&categoria=Drama&dataPublicacao=29%2F01%2F2024&page=0&size=20&sort=string' \
  -H 'accept: */*'
```

<summary>Resposta</summary>

```json
{
  "content": [
    {
      "id": "65b846cf547b2f431b1f7e82",
      "titulo": "Oppenheimer",
      "descricao": "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.",
      "url": "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA",
      "categoria": "Drama",
      "dataPublicacao": "29/01/2024"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalElements": 1,
  "totalPages": 1,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```

</details>

## Excluir Vídeo
![](/doc/img/api-videos-delete-swagger.PNG)

### [DELETE] /videos/{id}

```shell
http://127.0.0.1:8080/webjars/swagger-ui/index.html?urls.primaryName=Video#/API%20de%20Video/delete
```

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/videos/65b846cf547b2f431b1f7e82' \
  -H 'accept: */*'
```

## Desafio encontrado durante o desenvolvimento
Durante o desenvolvimento do projeto, foi necessário adquirir conhecimento sobre o framework Reactor para estabelecer uma base inicial de desenvolvimento com o Spring WebFlux. Quanto ao sistema de banco de dados, optei por utilizar o MongoDB.

## Referência

[^1]: [Livro "Clean Architecture: A Craftsman's Guide to Software Structure and Design" por Robert C. Martin](#).

