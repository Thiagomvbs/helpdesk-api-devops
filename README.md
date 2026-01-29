# 🛠️ HelpDesk API — Backend + DevOps

API de HelpDesk desenvolvida em **Spring Boot**, com foco em **boas práticas de backend** e **fundamentos de DevOps**, utilizando **Docker, Nginx e PostgreSQL**.

O projeto foi pensado como **MVP funcional**, evoluindo gradualmente para um sistema mais robusto, observável e pronto para produção.

---

## 🎯 Objetivo do Projeto

- Construir uma API REST realista para HelpDesk
- Praticar arquitetura backend com Java e Spring Boot
- Aplicar conceitos fundamentais de DevOps na prática
- Servir como **projeto de portfólio**

---

## 🧰 Tecnologias Utilizadas

- **Java 22+**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Nginx (Reverse Proxy)**
- **Maven**
- **Git & GitHub**

---

## 🧱 Arquitetura

- API containerizada com Spring Boot
- Banco de dados PostgreSQL em container dedicado
- Nginx atuando como proxy reverso
- Healthcheck para monitoramento básico da aplicação
- Logs padronizados para observabilidade inicial


---

## 📦 Funcionalidades Implementadas

### 👤 Usuários
- Criar usuário
- Listar usuários
- Buscar usuário por ID

### 🎫 Chamados
- Criar chamado
- Listar chamados
- Relacionamento com usuário
- Status automático (ABERTO)

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Docker
- Docker Compose

### Subir a aplicação
```bash
docker compose up --build

