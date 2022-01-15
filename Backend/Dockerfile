FROM node:10

WORKDIR /usr

COPY package.json ./

COPY tsconfig.json ./

RUN npm install --quiet

COPY src ./src