# Etapa 1: Construir la aplicación Angular
FROM node:18-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prods

# Etapa 2: Servir la aplicación con Nginx
FROM nginx:alpine
COPY --from=builder /app/dist/app-ip /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
