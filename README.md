

## Objetivo:
 A partir de uma URL, obter o trecho de texto contido no nível mais profundo da estrutura HTML de seu conteúdo. 

-------
## Requisitos técnicos:

| ID    | Descrição do Requisito                                                                                                                                                                                                                                                                   | Condição    | Atendido      |
| ----- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------- | ------------- |
| RT-1  | A solução deve ser desenvolvida como um programa Java a ser compilado e executado pela linha de comando, utilizando o JDK 17.                                                                                                                                                            | Obrigatório | Completamente |
| RT-2  | Não é permitido o uso de quaisquer bibliotecas e frameworks externos ao JDK. Também não é permitido o uso de packages e classes nativos do JDK relacionados à manipulação de HTML, XML ou DOM (como javax.xml ou quaisquer outros).                                                      | Obrigatório | Completamente |
| RT-3  | Para a compilação do programa deve ser suficiente executar o seguinte comando a partir do diretório que contém o(s)arquivo(s) de código fonte, sem quaisquer alterações: javac HtmlAnalyzer.java                                                                                         | Obrigatório | Completamente |
| RT-4  | Para a execução do programa deve ser suficiente executar o seguinte comando, a partir do diretório onde foi feita a compilação (item anterior), alterando apenas o argumento que contém a URL a ser analisada para uma URL válida: java HtmlAnalyzer inserir-url-aqui                    | Obrigatório | Completamente |
| RT-5a | O programa deve gerar apenas os seguintes tipos de output no console padrão: Linha de trecho de texto identificado no HTML.                                                                                                                                                              | Obrigatório | Completamente |
| RT-5b | A solução seja capaz de identificar estruturas HTML mal-formadas, retornando nesse caso a mensagem "malformed HTML".                                                                                                                                                                     | Opcional    | Parcialmente  |
| RT-5c | Mensagem "URL connection error" (caso não seja possível obter o conteúdo HTML por falha de conexão).                                                                                                                                                                                     | Obrigatório | Completamente |
| RT-6a | O código fonte da solução (apenas arquivos .java e opcionalmente um README.md, compatíveis com UTF-8) deve ser entregue em um arquivo tar (.tar ou .tar.gz), cujo nome deve ser igual ao nome do(a) candidato(a), sem acentos ou cedilhas e com espaços substituídos por underscore (_). | Obrigatório | Completamente |
| RF-6b | Não deve haver diretórios dentro do arquivo tar. Para um candidato chamado “Fulano de Tal”, o arquivo entregue deve ter o nome fulano_de_tal.tar (ou .tar.gz).                                                                                                                           | Obrigatório | Completamente |
