# Trabalho 4 - Algorítmo e Estrutura de Dados
Fazer um programa em linguagem C, C++ ou Java para gerenciar um dicionário, implementado usando a estrutura de dados TRIE.

# Data de entrega:
25/11/2019 até as 23:59 hs no e-mail algestruturadados.unioeste@gmail.com . En-
tregar apenas os códigos fontes descompactados, informando os nomes dos alunos. São descontados 25%
da nota por dia de atraso.
Fazer um programa em linguagem C, C++ ou Java para gerenciar um dicionário, implementado usando
a estrutura de dados TRIE.

# O programa deve seguir as seguintes regras:
* O programa deve ler um arquivo .txt contendo palavras e construir uma TRIE correspondente.
* As palavras no arquivo texto não estão necessariamente ordenadas alfabeticamente.
* O programa não deve fazer distinção entre maiúsculas e minúsculas.
* Palavras com acento e caracteres especiais devem ser ignoradas (não inseridas na TRIE).
* Nos arquivos textos de entrada há uma palavra por linha.

# O programa deve permitir ao usuário os seguintes tipos de consultas:
* Consultar palavra: dada uma palavra w, imprimir na tela as palavras do dicionário que tem
w como prefixo separadas por vı́rgula, limitadas ao número de 10 palavras. Por exemplo:
w = neuro, poderia ter como saı́da: neurociencia, neurogenese, neurogenico, neuroglia,
neurologia, neurologista, neuronio, neuropatia, neuropediatra, neuropsicologia
* Imprimir dicionário: imprime todas as palavras armazenadas no dicionário
* Carregar arquivo de stopwords: remove do dicionário todas as palavras contidas no arquivo
carregado

# BÔNUS: 
A distância de edição entre duas cadeias de caracteres é o número mı́nimo de inserções de
caracteres simples, deleções ou substituições necessárias para converter uma cadeia na outra. Por exemplo,
a distância entre mala e bala é 1; entre mala e malandro é 4, entre aberta e alerta é 1, entre aberta e
Alberta é 1. A distância entre qualquer palavra e ela própria é 0 (zero).
Implementar a funcionalidade Consultar Semelhante: dada uma palavra w e um número inteiro n
(limitado a 3 no máximo), imprimir na tela as palavras cuja distância de edição de w seja no máximo n.
Por exemplo: w =escreve e n = 2, poderia ter como saı́da: escreve, escreveis, escrevem, escreves,
escrevera. A pontuação dessa funcionalidade (1,0 ponto) será adicionada à nota da 4 a prova tal que não
ultrapasse o limite de 10 pontos.


O trabalho deverá ser apresentado oralmente para o professor com a presença dos integrantes do grupo, em
data a ser marcada. A avaliação do trabalho é condicionada à apresentação oral. No caso do grupo não
fazer a apresentação oral, receberá nota ZERO!

# Para avaliação do trabalho serão considerados:
* organização do código (identação, legibilidade e comentários) e emprego adequado das estruturas de
dados: peso 1.
* funcionamento das operações solicitadas:
– Consultar palavra: peso 3
– Imprimir dicionário: peso 3– Tratamento de stopwords: peso 4
* apresentação oral: peso 1
Trabalhos copiados ou plagiados receberão nota zero!
