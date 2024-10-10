# Simple REST Service
The first SEW exercise of the 5th form.

## How to use with Docker
### First time use 
#### Springboot Backend
using a terminal of your choice navigate into your project and run:
```
docker run -it --name nameforContainer -p 8888:8080 -v ${PWD}:/app -w /app maven bash
```
inside the bash of the container run:
```
mvn spring-boot:run
```
#### Vue-JS Frontend
using a terminal of your choice navigate into your project and run:
```
docker run -it --name nameforContainer -p 3000:5173 -v ${PWD}:/app -w /app node bash
```
inside the bash of the container run:
```
npm i
npm run dev -- --host
```

### Reuse Containers
#### Springboot Backend
if the container is currently stopped run:
```
docker start -it nameOfContainer bash
```
if not run:
```
docker exec -it nameOfContainer bash
```
inside the bash of the container run:
```
mvn spring-boot:run
```
#### Vue-JS Frontend
if the container is currently stopped run:
```
docker start -it nameOfContainer bash
```
if not run:
```
docker exec -it nameOfContainer bash
```
inside the bash of the container run:
```
npm run dev -- --host
```
