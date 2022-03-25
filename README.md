#   BikeFit Expert System

![image](https://img.shields.io/github/languages/top/stopasola/bike-fit-expert-system)

## Introdução


   O domínio do conhecimento se refere ao modal urbano que mais cresceu nestes últimos anos [1] , a
bicicleta, que pode ser utilizada para as mais variadas finalidades e para os mais variados perfis de
ciclistas, desde meio de transporte, instrumento de trabalho, equipamento para prática de diversos
esportes e até mesmo para o mais singelo passeio no parque.

   A área de atuação do sistema é uma prescrição com objetivo principal de recomendar a um ciclista, ou
alguém que está querendo ingressar no esporte, a melhor combinação de peças de bicicleta possíveis e
seus respectivos tamanhos e atributos. Essa recomendação será feita se baseando no perfil da
pessoa em questão, em algumas características físicas dela como, por exemplo, sua altura, no uso principal
que é pretendido para a bicicleta e, finalmente, no valor total que a pessoa pretende gastar. O sistema
também pode fazer recomendações de acessórios adicionais para acompanhar a compra da bicicleta e
aproveitar melhor seus benefícios.

   A utilidade deste sistema se mostra bastante válida para uma pessoa leiga no assunto ser capaz de
realizar a compra amparada com informações baseada em fatos adquiridos de um especialista qualificado e de
informações adquiridas de diversas fabricantes de renome internacional, isso protege o cliente de ficar
a mercê do vendedor, e também buscar por peças que condizem com sua estatura e sexo, entregando um
conforto inicial e benefícios a saude do ciclista a longo prazo, uma vez que equipamentos de tamanhos
diferentes podem causar dores e até mesmo lesões [2].

   O especialista escolhido para a consulta e mentoria no desenvolvimento foi o Acadêmico de Engenharia de Automação Guilherme Takashiba, atleta de
ciclismo amador na categoria cross country (mountain bike), entusiasta do mundo do ciclismo e mecânico nas
horas vagas.

## Desenvolvimento

#### Aquisição de conhecimento

   O processo de aquisição de conhecimento foi, em sua maior parte, buscado através dos diversos anos de
experiência que o especialista tem na área. Também foram adquiridos informações por buscas através da
internet sobre o assunto [3,4,5,6] que, posteriormente, foram verificadas pelo especialista.

## Regras do objetivo

#### Tamanho do Quadro:

###### Masculino:

|Tamanho quadro| Estatura mínima| Estatura máxima|
| :---: | :---: | :---: | 
|15 |1,60 |1,70|
|17 |1,71 |1,75
|19 |1,76 |1,80
|21 |1,81 |>1,82

###### Feminino:

|Tamanho quadro |Estatura mínima |Estatura máxima|
| :---: | :---: | :---: | 
|15 |1,60 |1,65|
|17 |1,66 |1,72|
|19 |1,73 |>1,74|


   Aqui, temos uma tabela demonstrando as relações entre a altura de uma pessoa do gênero masculino ou
feminino e o tamanho do quadro adequado para essa pessoa.

   A posição do corpo de uma pessoa enquanto usa a bicicleta bem como o controle geral da bicicleta é
dependente do tamanho do quadro que a bicicleta possui. 

   Um tamanho de quadro incoerente com a altura de uma pessoa, ou seja, uma pessoa utilizando uma
bicicleta com um quadro muito pequeno ou muito grande comparado a sua estatura, pode gerar uma série de
problemas, dentre os mais comuns [2] temos:

- Dores nas costas
- Dores nos pulsos
- Fadiga muscular acelerada
- Risco aumentado de quedas ou colisões

   Por esses motivos e, devido a importância do tamanho de um quadro apropriado, o sistema deve ler
corretamente a altura de uma pessoa e, a partir disso, entregar um quadro com o tamanho ideal para ela.

#### Valor da bicicleta:

|Categoria | Valor |Mínimo Máxima|
| :---: | :---: | :---: | 
|Entrada |R$: 1200,00 |R$: 2200,00|
|Média |R$: 2201,00 |R$: 4500,00|
|Premium |R$: 4501,00 |R$: 6000,00|
|Competição Entrada |R$: 6001,00 |R$: 7500,00|
|Competição Média |R$: 7501,00 > |R$: 7501,00|


   Na hora da compra, o valor pretendido para uma pessoa gastar em uma bicicleta é um dado essencial.
É claro que, pensando em um escopo global, o valor de uma bicicleta pode variar muito como, por exemplo, 
bicicletas de competição avançada vendidas a um valor de 70 mil reais mas, para fins genéricos, decidimos 
que o sistema deve dividir o valor de uma bicicleta nas 5 categorias:

```Entrada,Média, Premium, Competição Entrada, Competição Média```

   Com valores variando de R$: 1200,00 para bicicletas de entrada até valores maiores que R $7500,00 reais para as bicicletas de 
competição média. 
   Vale pontuar que existem bicicletas abaixo do valor mínimo definido, porém devido a grande parte dos 
equipamentos de bicicletas serem importados,  e a desvalorização do real, infelizmente não é possível encontrar bicicletas com 
qualidade mínima e com durabilidade que não acarrete problemas ao cliente em um curto prazo. 
Por fim ressaltamos que não foi incluída a categoria Competição Avançada, pois se tratam de bicicletas de nível profissional de alto custo,
na qual os atletas possuem aconselhamento de mecânicos profissionais.

#### Tipo de uso:

|Utilização |Categoria Bicicleta|
| :---: | :---: | 
|Passeio cidade |urbana|
|Longas Viagens |cicloturismo|
|Trabalho |Cargueira|
|Estrada de chão/cidade|gravel|
|Estrada de chão/Trilha|Mountain bike|
|Ciclismo de estrada |speed|


   A escolha da utilização principal da bicicleta também pode ser um fator decisivo na hora de escolher as peças ideias para a montagem de uma. É claro que, bicicletas são versáteis da sua própria maneira e, geralmente, caso você escolha uma utilização principal de, por exemplo, trilha, você não ficará limitado apenas a trilha.
Ainda assim, a maior utilização da bicicleta pode definir a categoria mais adequada para tal situação. Bicicletas tem categorias diferentes e cada categoria tem seus pontos fortes e fracos e, por isso, o uso principal de uma bicicleta é um fator importante na sua escolha.


#### Escolha Pneu:

|Utilização |Pneu - tipo |Pneu - largura|
| :---: | :---: | :---: | 
|Passeio cidade |slick |1.7|
|Longas Viagens |misto |2.2|
|Trabalho | misto |2.0|
|Estrada de chão/cidade|misto|2.2|
|Estrada de chão/Trilha|cravado|2.5|
|Ciclismo de estrada|slick1.5|


   A partir da escolha de um uso principal sobre a bicicleta, podemos decidir qual o melhor tipo de pneu para a bicicleta bem como a melhor largura.
Para as opções do tipo de pneus temos os pneus slick, cravado e misto. O tipo de pneu pode influenciar na velocidade da bicicleta, no conforto, segurança e, geralmente, cada tipo é mais apropriado para certos terrenos. Pneus slick são mais lisos e feitos para superfícies lisas, e não são ideais para superfícies muito irregulares como é encontrado em trilhas, por exemplo. Pneus cravados tem um volume maior de ar comparado aos outros tipos para uma melhor absorção de impacto e melhor aderência à estrada, sendo mais adequados para superfícies irregulares, com o custo de ter uma velocidade reduzida comparado a um pneu slick. Já o pneu misto, como já diz o nome, é um pneu que tenta juntar o melhor de ambos os mundos, tendo uma categoria mista que é bem utilizada em qualquer tipo de terreno. 
A largura do pneu também é importante nessa escolha. Na largura temos o fato de que pneus maiores possuem uma maior aderência enquanto pneus menores são mais eficientes em transformar a força do pedal em movimento, sendo mais rápidos. Caso um ciclismo de estrada seja o seu objetivo principal e velocidade deve ser priorizada, um pneu mais estreito é acreditado ser mais adequado mas, ao mesmo tempo, se o seu uso principal é direcionado a trilhas, velocidade é um fator menos essencial enquanto sua aderência deve ser um fator mais decisivo e, então, um pneu mais largo é sugerido.

#### Material  do quadro


|Categoria Valor|Quadro - Material|
| :---: | :---: |
|Entrada|aço|
|Média|alumínio simples|
|Premium|alumínio tripla espessura|
|Competição Entrada|alumínio quádrupla espessura|
|Competição Média|carbono|


   De acordo com nossa base de conhecimento, o fator decisivo para se escolher o material de um quadro é unicamente baseado no valor desejado para gastar. Isso se deve ao fato de que todos os quadros são capazes de lidar com os diferentes usos que a bicicleta pode prover ao ciclista, apenas, com qualidades diferentes.
Por exemplo, quanto maior o valor, menos peso e mais durabilidade irá se conseguir no quadro de uma bicicleta. Caso o peso seja um fator decisivo no uso desejado da bicicleta, um valor maior deve ser investido para atingir tal objetivo. Para um uso diário e comum, o peso da bicicleta não deve impactar significativamente na capacidade da sua bicicleta e, o fator mais decisivo será a durabilidade do material. 
Um quadro em carbono por exemplo, dentro da categoria do mountain bike profissional é quase que unanimidade, pois geralmente possui um peso menor e suas características de material permitem que o quadro “trabalhe” não repassando as trepidações do terreno em sua totalidade para o ciclista, tais propriedades garantem conforto e vantagem para qualquer pessoa, mas o valor agregado só é justificado em ambientes de competição.


#### Relação:


|Categoria Valor|Utilização|Relação / Nome|
| :---: | :---: | :---: | 
|Entrada|Passeio cidade / Trabalho|3x7 - shimano tourney|
|Média|Passeio cidade / Trabalho|3x8 - shimano altus|
|Premium|Passeio cidade / Trabalho|3x9 - shimano alivio|
|Entrada|Estrada de chão/cidade /Trilha|3x8 - shimano altus|
|Média|Estrada de chão/cidade /Trilha|2x9 - shimano altus|
|Premium|Estrada de chão/cidade /Trilha|2x9 - shimano alivio|
|Competição Entrada|Estrada de chão/cidade /Trilha|1x12 - shimano deore|
|Competição Média|Estrada de chão/cidade /Trilha|1x12 - shimano sx|
|Entrada|Ciclismo de estrada / Viagem|1x8 - shimano claris|
|Média|Ciclismo de estrada / Viagem|1x10 - shimano tiagra|
|Premium|Ciclismo de estrada / Viagem|1x11 - shimano Ultegra|
|Competição Entrada / Média|Ciclismo de estrada / Viagem |1x11 - shimano Dura-Ace|


   A relação é constituída por diversos componentes da bicicleta, sendo eles, coroas dianteiras e traseiras, corrente, câmbio dianteiro e traseiro, pedivela e passadores de marcha. Todos os itens citados são responsáveis pela movimentação da bicicleta e qual a força empregada para superar diferentes inclinações ou para atingir maiores velocidades. 
A relação é geralmente descrita por meio de dois números, que correspondem ao número de coroas dianteiras e traseiras respectivamente (uma relação 3x9 por exemplo, possui 3 coroas dianteiras e nove coroas traseiras, correspondendo a uma bicicleta de 27 marchas), a combinação está diretamente relacionada ao tipo de uso que o ciclista vai percorrer, e ao preço pago no equipamento. 
O sistema, além de entregar a relação, também descreve a marca e família correspondente. Usamos apenas a marca Shimano [7], pois a mesma é líder mundial em vendas, reconhecida no mundo todo por sua qualidade e é encontrada em todo o território nacional, facilitando futuras reposições e manutenções. 
A família Shimano é composta por todos os itens que compõem a relação, sendo recomendado pela fabricante usar todas as peças da mesma família para um melhor funcionamento e durabilidade. 


#### Selim:

|Utilização|Selim| 
| :---: | :---: |
|Passeio cidade|Selim largo e com bastante preenchimento|
|Longas Viagens|Selim médio e com bastante preenchimento|
|Trabalho|Selim largo e com bastante preenchimento|
|Estrada de chão/cidade|Selim médio vazado|
|Estrada de chão/Trilha|Selim médio vazado|
|Ciclismo de estrada|Selim estreito e vazado|



   Quanto mais inclinado o ciclista fica sobre a bicicleta, ou quanto mais agressiva for a forma de pilotar, mais estreito, comprido e plano é o selim. Quanto mais ereto fica o ciclista ou mais tranquila a pilotagem, mais curto, largo e curvo deve ser o selim.
Em bicicletas de passeio, a posição de pilotagem é muito relaxada e natural, e, em alguns casos, o ciclista mantém a coluna totalmente ereta. Neste estilo de pilotagem, não se espera muito desempenho, então pode-se dar espaço a mais conforto. Por isso, os selins para passeio são largos e possuem preenchimento alto.
Em mountain bikes, temos selins com menos preenchimento, mas ainda curvos, e com narizes mais longos. É aqui que começam a aparecer mais selins vazados. Selins vazados tem como proposta aliviar a pressão no períneo, especialmente, mas não unicamente, para ciclistas homens. 
Em bicicletas de estrada, a posição de pilotagem é ainda mais inclinada, e a cadência da pedalada é maior. Por isso, os selins são mais estreitos e lisos, permitindo melhor movimentação das coxas. São mais planos, mas ainda podem apresentar alguma curvatura. Nessa modalidade é mais comum ver selins sem preenchimento, ou com preenchimentos muito finos.


#### Amortecedor

|Categoria Valor|Utilização|Amortecedor|
| :---: | :---: | :---: | 
|Entrada|Passeio cidade / Trabalho|Não|
|Média|Passeio cidade / Trabalho|Não|
|Premium|Passeio cidade / Trabalho|Não|
|Entrada|Estrada de chão/cidade |Não|
|Média|Estrada de chão/cidade|Não|
|Premium|Estrada de chão/cidade |Não|
|Entrada|Ciclismo de estrada / Viagem|Não|
|Média|Ciclismo de estrada / Viagem|Não|
|Premium|Ciclismo de estrada / Viagem|Não|
|Entrada|Estrada de chão/Trilha|Mola|
|Média|Estrada de chão/Trilha|Hidráulica|
|Premium|Estrada de chão/Trilha|Ar|


   A suspensão é a peça que vai oferecer vantagens em transpor terrenos acidentados, e também dar mais conforto ao pedal. O uso de suspensão dianteira é justificado por especialistas apenas em bicicletas de trilha, uma vez que acrescenta bastante peso à bicicleta, e caso não seja um equipamento de qualidade, pode atrapalhar o ciclista. 
Temos algumas categorias de suspensão, sendo elas, as suspensões de mola, que consistem em uma versão duplicada da opção com elastômero, mas sem as ‘rolhas’. Seu sistema é mole diante de terrenos acidentados, o que faz com que a bicicleta ‘pule’ muito. 
As suspensões a ar consistem no melhor resultado encontrado no mercado. Possuem a câmara de ar, que pode ser calibrada de acordo com o peso do ciclista e possuem  um sistema hidráulico, com ajustes de compressão e trava.

#### Freio

|Categoria Valor|Utilização|Freio|
| :---: | :---: | :---: | 
|Entrada|Ciclismo de estrada|ferradura - shimano claris|
|Média|Ciclismo de estrada|ferradura - shimano tiagra|
|Premium|Ciclismo de estrada|ferradura - shimano ultegra|
|Entrada|-|v-brake|
|Média|-|disco mecânico|
|Premium|-|disco hidráulico|
|Competição Entrada|-disco hidráulico|
|Competição Média|-|disco hidráulico|


   A escolha do freio depende, em grande parte, do valor a ser gasto na bicicleta. Porém, bicicletas com o objetivo de ciclismo de estrada, 
mais conhecidas como bicicletas speed, desempenham melhor com um freio de ferradura em valores mais baixos, por serem leves e possuirem uma 
frenagem melhor em situações com um forte atrito e, por isso, para ciclismo de estrada na faixa dos valores de entrada, média e premium, um freio 
de ferradura, com um modelo diferente para cada valor, é recomendado. 
   Já para todos os outros modelos de bicicleta, a escolha do freio depende, 
somente, do valor. Todos os freios recomendados funcionam perfeitamente, porém, caso tenha-se a opção de gastar mais em uma bicicleta, é possível 
adquirir um freio superior, com mais força e mais seguro. Para valores de entrada, um v-brake é recomendado. 
   Para valores na faixa média, um freio  a disco mecânico é recomendado. Já para todos os outros valores, um freio a disco hidráulico será a melhor opção.
	

#### Aro : 


|Utilização|Tamanho|
| :---: | :---: |
|Passeio cidade|26|
|Longas Viagens|29|
|Trabalho|26|
|Estrada de chão/cidade|29|
|Estrada de chão/Trilha|29|
|Ciclismo de estrada|29|


   O tamanho do aro irá depender da utilização principal da bicicleta. É recomendado que, para os casos de uso de passeio na cidade ou trabalho, o aro 26 seja escolhido. Isso se dá pelo motivo do aro 26 conseguir mais torque do que o aro 29, sendo mais eficiente ao colocar a força do pedal nas rodas até certa velocidade, ideal para velocidades menores e menor esforço ao pedalar. 
Com isso em mente, o aro 29 tem um desempenho superior em todos os outros casos de uso. Isso se dá porque o aro 29 é capaz de entregar uma jornada com mais conforto na bicicleta e, a partir de uma certa velocidade, o aro 29 possui uma performance superior ao aro 26.


## Tópicos utilizados

Estratégia de inferência: Forward chaining
Tipo de raciocínio: Indutivo, por meio de uma série de perguntas feitas ao usuário
Representação de conhecimento: Regras de produção

## Parecer do especialista

   Com base nos resultados alcançados e por meio das diversas validações e testes implementados, o especialista se mostrou bastante satisfeito com o 
resultado alcançado pelo sistema, segundo o mesmo:

- “ O sistema entrega ótimos resultados principalmente para ciclistas leigos que não conhecem o básico do funcionamento de uma bicicleta, com os 
resultados entregues pelo sistema, o mesmo terá condições de não ser enganado por um vendedor ou até mesmo adquirir informações que muitos vendedores 
nem mesmo tem, o sistema entrega exatamente o que foi proposto para o público alvo, e pode garantir economia de dinheiro e benefícios a saúde do cliente,
evitando possíveis lesões” 

- Takashiba, Guilherme  


Referências:

[1] Mercado de bicicletas tem crescimento de 26% na pandemia. Disponível em: [https://revistapegn.globo.com/Negocios/noticia/2021/03/mercado-de-bicicletas-tem-crescimento-de-26-na-pandemia.html](https://revistapegn.globo.com/Negocios/noticia/2021/03/mercado-de-bicicletas-tem-crescimento-de-26-na-pandemia.html). Acesso em: 17/06/2021.

[2] Bicycle-Related Injuries. Disponível em: [https://www.aafp.org/afp/2001/0515/p2007.html](https://www.aafp.org/afp/2001/0515/p2007.html). Acesso em: 18/06/2021.

[3] Road bike groupsets: everything you need to know. Disponível em: [https://www.bikeradar.com/advice/buyers-guides/road-bike-groupsets-everything-you-need-to-know/](https://www.bikeradar.com/advice/buyers-guides/road-bike-groupsets-everything-you-need-to-know/). Acesso em: 17/06/2021. 

[4] Competitive cyclist. Disponível em: [https://www.competitivecyclist.com/Store/catalog/fitCalculatorBike.jsp#fitcalc-main](https://www.competitivecyclist.com/Store/catalog/fitCalculatorBike.jsp#fitcalc-main). Acesso em: 18/06/2021.

[5] Sizing guide. Disponível em: [https://www.rutlandcycling.com/content/sizing-guide.aspx](https://www.rutlandcycling.com/content/sizing-guide.aspx). Acesso em: 18/06/2021.

[6] Giant Bicycles. Disponível em: [https://www.giant-bicycles.com/global](https://www.giant-bicycles.com/global). Acesso em: 18/06/2021.

[7] Groupset Shimano. Disponível em: [https://bike.shimano.com/en-EU/components/road.html](https://www.giant-bicycles.com/global) Acesso em: 18/06/2021.




