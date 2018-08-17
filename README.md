# sumOneProcessoSeletivo
Serviço de ordenação de livros para o processo seletivo da SumOne.

# Sobre o sistema
O sistema foi desenvolvido em java, itilizando padrão REST

Foi utilizado no projeto, Framework Spring e sistema de automação de compilação Gradle, sendo que foi utilizado o Gradle Wrapper para facilitar a execução.

# Instruções
Para rodar basta, na pasta raiz do projeto, executar o comando:
gradlew bootRun

Para gerar um jar e rodar à partir dele basta utilizar, na raiz do projeto, os seguintes comandos:
gradlew build
java -jar build/libs/gs-rest-service-0.1.0.jar

# Dependências
Deve-se ter o java instalado

#APLI
O serviço foi desenvolvido para rodar na porta 8080, no localhost

# Endpoints
| Endpoint      | descrição                         |
|:--------------|:----------------------------------|
| `/sortBoooks` | Retorna a lista de livros passada como parâmetro ordenada segundo critérios definidos no arquivo de configuração

# Parâmetros
Objetos JSON esperados no body da requisição

| Parâmetro     | descrição                         |
|:--------------|:----------------------------------|
| 'books'       | Armazena o array de objetos 'book' ('title', author, 'editionYear') 
| 'title'       | Armazena o título do livro
| 'author'      | Armazena o nome do autor do livro  
| 'editionYear' | Armazena o ano da edição do livro 


# Respostas
Exatamente os mesmos esperados pela requisição

# Arquivo de configuração
o arquivo de configuração espera que para cada parâmetro escolhido de ordenação, o mesmo seja inserido em formato de texto comum contendo exatamente o mesmo nome do parâmetro esperado pela requisição, seguido de ':' com a palavra 'ascending', caso a ordenaão de escolha seja ascendente, ou 'descending', caso seja descendente (na prática, qualquer coisa que não seja 'ascending', sera visto como 'descending'

Exemplo:
author: ascending, title: descending

# Exceções
Caso o arquivo de configuração não esteja corretamente definido, a requisição ira responder com erro 500, com a mensagem 'OrderingException'

Caso não seja definida nenhuma regra de ordenação, a requisição retorna status 200 com um objeto json contendo uma lista vazia de 'books'
