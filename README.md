# 🛍️ Sistema Saavedra Modas

Sistema web desenvolvido para controle de faturamento diário da **Loja Saavedra Modas**.

O projeto nasceu como trabalho acadêmico, mas foi estruturado e publicado para uso real no dia a dia da loja, com foco em simplicidade, estabilidade e controle financeiro por canais de recebimento.

---

## 📌 Status do Projeto

✅ Sistema online em produção  
✅ Login funcionando com JWT  
✅ Banco online conectado no Supabase  
✅ Deploy realizado no Render  
✅ Docker testado localmente  
✅ Layout responsivo para PC e celular  
✅ APIs protegidas com Spring Security  
✅ Sistema pronto para uso real  

---

## 🎯 Objetivo

O objetivo principal do sistema é controlar o faturamento da loja de forma simples e confiável.

O sistema permite registrar vendas diariamente, consultar histórico, corrigir lançamentos e gerar relatórios financeiros por período e por canal de recebimento.

Este sistema **não tem foco em estoque, produtos ou clientes** neste momento.

O foco é exclusivamente:

- Valor vendido
- Data da venda
- Canal de recebimento
- Total por período
- Total por canal
- Histórico financeiro

---

## 🧠 Problema que o sistema resolve

Antes do sistema, o controle financeiro da loja dependia de anotações, conferências manuais e cálculos separados por canais de recebimento.

Com o sistema, cada venda é registrada com:

- Data
- Valor
- Canal de recebimento

A partir disso, o sistema calcula automaticamente:

- Faturamento do dia
- Faturamento por período
- Faturamento do mês atual
- Faturamento dos últimos 30 dias
- Faturamento do ano atual
- Total por canal de recebimento

---

## 🧾 Exemplo de uso real

Exemplo de vendas em um dia:

```text
Venda 1 → R$ 100,00 → Dinheiro
Venda 2 → R$ 250,00 → PIX PagBank Paula
Venda 3 → R$ 80,00 → Cartão PagBank Victor
```

O sistema registra cada venda individualmente e depois permite gerar relatórios como:

```text
Dinheiro: R$ 100,00
PIX PagBank Paula: R$ 250,00
Cartão PagBank Victor: R$ 80,00

Total Geral: R$ 430,00
```

---

## 🛠️ Tecnologias Utilizadas

### Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Security
- Spring Data JPA
- Hibernate
- Maven
- Lombok
- JWT

### Frontend

- Thymeleaf
- HTML
- CSS
- JavaScript

### Banco de Dados

- PostgreSQL local para desenvolvimento
- PostgreSQL online no Supabase para produção

### Deploy e Infraestrutura

- Docker
- Docker Desktop
- Render
- Supabase
- GitHub

### Ferramentas de Desenvolvimento

- IntelliJ IDEA
- Postman
- Git
- GitHub
- PowerShell
- Docker Desktop

---

## 🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas.

Estrutura principal:

```text
com.saavedramodas.loja

controller
domain
dto
exception
repository
security
service
```

Fluxo da aplicação:

```text
Tela HTML/JavaScript
        ↓
Controller
        ↓
Service
        ↓
Repository
        ↓
Banco de Dados PostgreSQL
```

---

## 📂 Organização das Camadas

### Controller

Responsável por receber requisições HTTP.

Exemplos:

- Login
- Cadastro de venda
- Cadastro de canal
- Consulta de histórico
- Relatórios

O Controller não deve conter regra de negócio pesada. Ele recebe a requisição e chama o Service.

---

### Service

Camada onde ficam as regras de negócio.

Exemplos:

- Validar dados
- Buscar canal por ID
- Salvar venda
- Editar venda
- Calcular totais
- Gerar relatórios
- Validar usuário e senha

---

### Repository

Responsável pela comunicação com o banco de dados.

Utiliza Spring Data JPA.

Exemplo:

```text
UsuarioRepository
CanalRecebimentoRepository
LancamentoRepository
```

---

### Domain / Entity

Representa as tabelas do banco.

Entidades principais:

```text
Usuario
CanalRecebimento
Lancamento
```

---

### DTO

Objetos usados para entrada e saída de dados.

Evita expor diretamente as entidades.

Exemplos:

```text
LoginRequestDTO
LoginResponseDTO
CanalRecebimentoRequestDTO
LancamentoRequestDTO
RelatorioResponseDTO
```

---

### Security

Camada de segurança.

Responsável por:

- Configurar Spring Security
- Validar JWT
- Gerar token
- Proteger APIs
- Tratar token inválido ou expirado

---

### Exception

Camada para tratamento de erros.

Centraliza respostas de erro e evita que o sistema quebre de forma desorganizada.

---

## 🗃️ Entidades do Sistema

## 👤 Usuario

Representa o usuário autorizado a acessar o sistema.

Campos principais:

```text
id
username
password
role
```

A senha é salva criptografada com BCrypt.

Exemplo:

```text
username: admin
role: ADMIN
password: hash BCrypt
```

---

## 💳 CanalRecebimento

Representa os meios de recebimento da loja.

Campos:

```text
id
nome
```

Exemplos de canais:

```text
Dinheiro
PIX PagBank Paula
PIX PagBank Victor
Cartão PagBank Paula
Cartão PagBank Victor
```

### Decisão importante

Canais **não são excluídos pela interface**.

Motivo:

Uma venda antiga referencia um canal. Se o canal for apagado, o histórico financeiro pode ficar inconsistente ou os relatórios podem ser afetados.

Portanto:

```text
✅ Cadastrar canal
✅ Editar canal
❌ Excluir canal pela tela
```

---

## 💰 Lancamento

Representa uma venda ou entrada financeira.

Campos:

```text
id
valor
data
canalRecebimento
```

Relacionamento:

```text
Muitos lançamentos podem pertencer a um canal.
```

Exemplo:

```text
Venda de R$ 150,00
Data: 03/07/2026
Canal: PIX PagBank Paula
```

---

## 🖥️ Telas do Sistema

## 🔐 Login

Tela inicial do sistema.

Campos:

- Usuário
- Senha

Fluxo:

```text
Usuário informa login e senha
        ↓
Frontend envia para /auth/login
        ↓
Backend valida no banco
        ↓
Backend gera token JWT
        ↓
Frontend salva token no localStorage
        ↓
Usuário acessa o sistema
```

---

## 🏠 Home

Tela principal do sistema.

Mostra:

- Faturamento de hoje
- Data atual
- Quantidade de vendas realizadas
- Atalhos para as funcionalidades principais

---

## 💵 Nova Venda

Tela usada no dia a dia da loja.

Campos:

- Valor
- Data
- Canal de recebimento

A venda é enviada para o backend e salva na tabela de lançamentos.

---

## 📋 Histórico

Tela para consultar vendas cadastradas.

Funcionalidades:

- Buscar vendas por data
- Editar venda
- Excluir venda cadastrada incorretamente
- Ver canal, data e valor de cada venda

Essa tela resolve o problema de não precisar saber o ID da venda manualmente.

---

## 📊 Relatórios

Tela mais importante do sistema.

Tipos de relatório:

- Diário
- Por período
- Mês atual
- Últimos 30 dias
- Ano atual

Cada relatório retorna:

- Total por canal
- Total geral

---

## ⚙️ Canais

Tela para gerenciar os canais de recebimento.

Funcionalidades:

- Cadastrar canal
- Listar canais
- Editar nome do canal

Não existe botão de excluir canal por decisão de segurança histórica.

---

## 🔐 Segurança e Autenticação

O sistema usa autenticação com **JWT**.

### Como funciona

1. O usuário faz login.
2. O backend valida usuário e senha.
3. O backend gera um token JWT.
4. O frontend salva esse token no navegador.
5. Toda requisição para API protegida envia o token.
6. O backend valida o token antes de permitir acesso.

---

## 🧩 app.js

O arquivo `app.js` centraliza funções importantes do frontend:

```text
salvarToken()
buscarToken()
removerToken()
usuarioEstaLogado()
logout()
headersAutenticados()
apiFetch()
protegerPagina()
```

A função mais importante é `apiFetch()`.

Ela substitui o `fetch()` comum para enviar automaticamente o token JWT nas requisições.

Exemplo:

```javascript
apiFetch("/lancamentos", {
    method: "POST",
    body: JSON.stringify(venda)
});
```

Isso envia o header:

```text
Authorization: Bearer TOKEN
```

---

## 🔒 Spring Security

O `SecurityConfig` foi configurado para liberar páginas HTML e arquivos estáticos, mas proteger APIs.

Páginas liberadas:

```text
/
/home-page
/lancamentos-page
/historico-page
/relatorios-page
/canais-page
/auth/**
/css/**
/js/**
/img/**
```

APIs protegidas:

```text
/canais/**
/lancamentos/**
/relatorios/**
/home/**
```

Essa decisão foi tomada porque links HTML normais não enviam token no header. Quem envia token são as chamadas JavaScript usando `apiFetch()`.

---

## 🛡️ JwtFilter

O `JwtFilter` intercepta requisições protegidas.

Ele verifica:

- Se existe header Authorization
- Se começa com Bearer
- Se o token é válido
- Se o usuário existe
- Se o token não expirou

Se o token estiver inválido ou expirado, o sistema retorna erro de autenticação e o frontend redireciona para o login.

---

## 🌐 Rotas e Endpoints

## Autenticação

```text
POST /auth/login
```

---

## Canais

```text
GET /canais
POST /canais
GET /canais/{id}
PUT /canais/{id}
```

---

## Lançamentos

```text
GET /lancamentos
POST /lancamentos
GET /lancamentos/{id}
GET /lancamentos/data?data=AAAA-MM-DD
PUT /lancamentos/{id}
DELETE /lancamentos/{id}
```

---

## Relatórios

```text
GET /relatorios/diario?data=AAAA-MM-DD

GET /relatorios/periodo?dataInicio=AAAA-MM-DD&dataFim=AAAA-MM-DD

GET /relatorios/mes-atual

GET /relatorios/ultimos-30-dias

GET /relatorios/ano-atual
```

---

## ⚙️ Configuração da Aplicação

O `application.properties` foi preparado para funcionar localmente e em produção sem expor senhas.

Exemplo:

```properties
spring.application.name=loja

spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/loja_saavedra}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:postgres}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:}

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

jwt.secret=${JWT_SECRET:dev-secret-local}
jwt.expiration=${JWT_EXPIRATION:86400000}

server.port=${PORT:8080}
```

---

## 🔑 Variáveis de Ambiente em Produção

No Render foram configuradas variáveis de ambiente.

Principais:

```text
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
JWT_SECRET
JWT_EXPIRATION
SPRING_JPA_HIBERNATE_DDL_AUTO
```

Essas variáveis evitam colocar senhas dentro do GitHub.

---

## 🐳 Docker

O projeto possui Dockerfile.

O Docker permite empacotar a aplicação para rodar de forma padronizada em qualquer ambiente que suporte container.

### Diferença importante

```text
Dockerfile = receita
Imagem Docker = aplicação empacotada
Container = aplicação rodando
```

---

## Dockerfile

O Dockerfile usado no projeto:

```dockerfile
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## Explicação do Dockerfile

### Etapa 1

```dockerfile
FROM maven:3.9.9-eclipse-temurin-21 AS build
```

Usa uma imagem com Maven e Java 21 para compilar o projeto.

---

### Etapa 2

```dockerfile
WORKDIR /app
```

Define a pasta de trabalho dentro do container.

---

### Etapa 3

```dockerfile
COPY pom.xml .
COPY src ./src
```

Copia o projeto para dentro do ambiente Docker.

---

### Etapa 4

```dockerfile
RUN mvn clean package -DskipTests
```

Compila o projeto e gera o `.jar`.

---

### Etapa 5

```dockerfile
FROM eclipse-temurin:21-jdk
```

Cria a imagem final apenas com Java 21.

---

### Etapa 6

```dockerfile
COPY --from=build /app/target/*.jar app.jar
```

Copia o `.jar` gerado na etapa de build.

---

### Etapa 7

```dockerfile
EXPOSE 8080
```

Informa que a aplicação usa a porta 8080.

---

### Etapa 8

```dockerfile
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Comando usado para iniciar a aplicação.

---

## .dockerignore

Arquivo usado para evitar que arquivos desnecessários entrem na imagem Docker.

Conteúdo:

```text
target
.git
.idea
*.iml
.env
.DS_Store
```

---

## Comandos Docker Locais

Criar imagem:

```bash
docker build -t saavedra-modas .
```

Rodar container local:

```bash
docker run --name saavedra-modas-app -p 8080:8080 -e SPRING_DATASOURCE_URL="jdbc:postgresql://host.docker.internal:5432/loja_saavedra" -e SPRING_DATASOURCE_USERNAME="postgres" -e SPRING_DATASOURCE_PASSWORD="SENHA_LOCAL" -e JWT_SECRET="CHAVE_JWT" saavedra-modas
```

Listar imagens:

```bash
docker images
```

Listar containers rodando:

```bash
docker ps
```

Listar todos os containers:

```bash
docker ps -a
```

Parar container:

```bash
docker stop saavedra-modas-app
```

Remover container:

```bash
docker rm saavedra-modas-app
```

---

## ☁️ Deploy

O deploy final ficou assim:

```text
GitHub → Render → Supabase
```

### GitHub

Armazena o código fonte do projeto.

### Render

Hospeda a aplicação Spring Boot usando Docker.

### Supabase

Hospeda o banco PostgreSQL online.

---

## 🌍 Produção

A aplicação foi publicada no Render.

O banco online foi criado no Supabase.

O Render conecta no Supabase usando variáveis de ambiente.

O banco online começa vazio, separado do banco local.

Isso significa:

```text
Vendas locais de teste não sobem para produção.
Canais locais de teste não sobem para produção.
Usuário local não sobe automaticamente para produção.
```

O usuário admin foi criado manualmente no Supabase.

---

## 🧪 Testes Realizados

Testado localmente:

- Login
- Cadastro de venda
- Histórico
- Edição de venda
- Exclusão de venda
- Cadastro de canal
- Edição de canal
- Relatórios
- Segurança com token
- Token inválido
- Docker local

Testado online:

- Login
- Cadastro de canal
- Cadastro de venda
- Histórico
- Relatórios
- PC
- Mobile

---

## 🔄 Fluxo de Atualizações Futuras

Para criar uma melhoria:

```bash
git checkout main
git pull
git checkout -b feat/nome-da-melhoria
```

Depois desenvolver, testar localmente e testar com Docker.

Criar imagem para teste:

```bash
docker build -t saavedra-modas:teste .
```

Rodar localmente:

```bash
docker run --name saavedra-modas-teste -p 8080:8080 -e SPRING_DATASOURCE_URL="jdbc:postgresql://host.docker.internal:5432/loja_saavedra" -e SPRING_DATASOURCE_USERNAME="postgres" -e SPRING_DATASOURCE_PASSWORD="SENHA_LOCAL" -e JWT_SECRET="CHAVE_JWT" saavedra-modas:teste
```

Se tudo funcionar:

```bash
git add .
git commit -m "feat: descricao da melhoria"
git push -u origin feat/nome-da-melhoria
```

Depois abrir Pull Request no GitHub ou fazer merge na main.

Quando a main receber push, o Render pode fazer deploy automático.

Se não fizer:

```text
Render → Manual Deploy → Deploy latest commit
```

---

## 🧷 Tags de versão

Quando uma versão estável estiver pronta:

```bash
git tag v1.0.0
git push origin v1.0.0
```

Essa tag marca oficialmente a primeira versão estável do sistema.

---

## 🗄️ Backup

Como o sistema armazena faturamento real, backup é importante.

Recomendação inicial:

```text
Backup manual semanal
Backup antes de grandes atualizações
Backup mensal de fechamento
```

O backup deve ser feito no banco Supabase.

O sistema local e o sistema online usam bancos diferentes.

---

## 🔐 Cuidados de Segurança

Nunca commitar:

```text
Senha do banco
JWT_SECRET real
Connection string com senha
Arquivos .env
```

Antes de deixar o repositório público, verificar se não existem senhas no histórico.

Comandos úteis:

```bash
git grep -n "password"
git grep -n "jwt.secret"
git grep -n "postgresql://"
```

---

## 📌 Decisões Importantes do Projeto

### 1. Não excluir canais pela interface

Motivo:

Evitar perda de histórico e inconsistência nos relatórios.

---

### 2. Cadastrar venda por venda

Motivo:

Permitir histórico completo, edição futura e relatórios confiáveis.

---

### 3. Usar JWT

Motivo:

Permitir autenticação segura entre frontend e backend.

---

### 4. Usar Docker

Motivo:

Facilitar deploy e permitir rodar o sistema em diferentes ambientes.

---

### 5. Usar Supabase

Motivo:

Ter PostgreSQL online gratuito para produção.

---

### 6. Usar Render

Motivo:

Hospedar a aplicação Spring Boot com Docker de forma simples.

---

## 🚀 Melhorias Futuras

- Filtro no histórico por canal
- Filtro no histórico por período
- Exportação de relatório em PDF
- Botão de logout visível
- Troca de senha pela interface
- Dashboard mensal mais completo
- Backup automático
- Domínio personalizado
- PWA para instalar no celular
- Página de configurações administrativas
- Tela de comparação entre meses
- Relatório de fechamento mensal

---

## 🧾 Resumo Final

O Sistema Saavedra Modas está pronto para uso real.

Ele permite controlar o faturamento diário da loja de forma simples, segura e organizada.

O sistema possui:

- Backend em Java/Spring Boot
- Frontend com Thymeleaf, HTML, CSS e JavaScript
- Banco PostgreSQL
- Login com JWT
- Deploy em nuvem
- Docker
- Render
- Supabase
- Responsividade para celular
- Histórico e relatórios financeiros

Status final:

```text
✅ Sistema funcionando localmente
✅ Sistema funcionando em Docker
✅ Sistema funcionando online
✅ Sistema funcionando no celular
✅ Sistema pronto para uso real
```

---

## 👨‍💻 Autor

Desenvolvido por Victor Hugo / Saavedra Modas.

Projeto acompanhado, estruturado e documentado durante o desenvolvimento completo.
