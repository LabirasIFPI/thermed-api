# TherMed ❄️💊 API - API do Sistema de Monitoramento de Medicamentos Termolábeis

## 🔎 Sobre o Projeto

TherMed API é um componente crítico do sistema de monitoramento de medicamentos termolábeis, responsável por receber alertas de dispositivos de monitoramento e notificar os responsáveis via Telegram quando ocorrem violações de temperatura, sejam elas muito baixas ou muito altas.

Medicamentos termolábeis exigem armazenamento em faixas de temperatura controlada. Qualquer desvio pode comprometer a eficácia e segurança desses medicamentos. Nossa API funciona como o elo entre os dispositivos de monitoramento e as equipes responsáveis, garantindo uma resposta rápida a situações críticas.

## 🦾 Funcionalidades

- Recebimento de alertas de temperatura em tempo real
- Processamento das informações de alerta
- Integração com a API do Telegram para notificações instantâneas
- Notificação a múltiplos destinatários (equipe de manutenção e usuário responsável)
- Armazenamento de alertas em banco de dados (PostgreSQL)

## 🛠️ Arquitetura

A API é construída em Java e expõe um único endpoint RESTful que recebe notificações de dispositivos IoT que monitoram temperaturas de armazenamento de medicamentos. Veja mais em: https://github.com/LabirasIFPI/ther-med

## 📍 Endpoint

### POST /alert

Recebe alertas dos dispositivos de monitoramento quando as temperaturas ultrapassam os limites estabelecidos.

**Corpo da Requisição (JSON):**
```json
{
  "deviceId": "string",
  "temperature": int,
  "maxTemperature": int,
  "minTemperature": int
}
```

**Parâmetros:**
- `deviceId`: Identificador único do dispositivo que está reportando o alerta
- `temperature`: Temperatura atual registrada pelo dispositivo (em graus Celsius)
- `maxTemperature`: Limite máximo de temperatura permitido para o dispositivo
- `minTemperature`: Limite mínimo de temperatura permitido para o dispositivo

## ✅ Pré-requisitos

- Java 21 ou superior
- Maven 3.6 ou superior
- Acesso à API do Telegram (Bot Token)
- Banco de dados PostgreSQL (para armazenamento de associações entre dispositivos e usuários

## 🔗 Integrações

### 📞 Telegram

A API se integra com a plataforma Telegram para enviar notificações instantâneas quando temperaturas irregulares são detectadas. As notificações são enviadas para:

- Grupo de Manutenção TherMed: Recebe todos os alertas para monitoramento centralizado
- Usuário Responsável: A pessoa associada ao dispositivo específico que gerou o alerta

### 🐘 PostgreSQL Local

A API também é integrada com uma instância local de um banco de dados no PostgreSQL apenas para fins de desenvolvimento. Confira o conteúdo do banco de forma abstraída:

- Dispositivos: possuem descrição, string identificadora, local, id do chat do usuário associado a ele
- Alertas: possuem timestamp do alerta e id do dispositivo que gerou um alarme

## ⚙️ Desenvolvimento

### 🗃️ Estrutura do Projeto

```
thermed-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── thermed/
│   │   │           ├── controllers/
│   │   │           │   └── AlertController.java    // Controlador REST responsável por receber e processar requisições
│   │   │           ├── mappers/
│   │   │           │   └── AlertMapper.java        // Classe auxiliar para processar entidades de requisições e criar respostas personalizadas
│   │   │           ├── model/                      // Entidades
│   │   │           │   └── dto/
│   │   │           │     └── AlertRequestDto.java  // Entidade que representa uma requisição à API
│   │   │           │     └── AlertResponseDto.java // Entidade que representa uma resposta à API
│   │   │           │   └── Alert.java
│   │   │           │   └── Device.java
│   │   │           ├── services/                   // Serviços para gerenciar lógicas de negócio e acessos aos repositories
│   │   │           │   ├── AlertService.java
│   │   │           │   └── DeviceService.java
│   │   │           │   └── TelegramService.java
│   │   │           ├── repositories/               // Abstrações de acesso ao banco de dados PostgreSQL
│   │   │           │   └── DeviceRepository.java
│   │   │           │   └── AlertRepository.java
│   │   │           └── ThermedApiApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── thermed/
│                   └── controllers/
│                       └── AlertControllerTest.java
├── pom.xml
└── README.md
```

## 🧑🏻 Autor

Xamã Cardoso Mendes Santos
