# 🚗 Documentação Front-End

## ✅ Pré-requisitos

Antes de iniciar, você precisa ter instalado em sua máquina:

- [Node.js](https://nodejs.org/) (versão LTS recomendada)
- [NPM](https://www.npmjs.com/) (gerenciador de pacotes que já vem com o Node)

## 📦 Instalação

1. No terminal, dentro da pasta front-end do projeto, execute:

```
npm install
```

2. Na mesma pasta, instale as dependências do projeto:
```
npm install react-router-dom
npm install swiper
```

3. Inicie o projeto:
```
npm run dev
```

Após isso, o site estará acessível em http://localhost:5173/

# 🚗 Documentação Back-End

## ✅ Como executar?

1. Rode o docker compose
```
docker compose up
```
2. Crie o banco
- importando o arquivo ou colando o código em forma de SQL 
3. Rode o java:
   
- Entre no arquivo AlugaAquiApplication.java e no campo Run and Debug no vs code
- No InteliJJ use o campo de RUN dele
- Verifique em localhost:8080/carros : deverá retornar um json
4. Acesse o front-end
- conforme descrtio no primeiro campo de **Instalação** Acesse a pagina http://localhost:5173/ e você terá acesso ao front-end consumido os dados do back-end
