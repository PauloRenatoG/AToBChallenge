# A-To-Be Challenge

O desafio consiste em consumir a API DUMMY Json https://dummyjson.com/docs/products e desenvolver duas funcionalidades sendo elas:
+ listar os produtos e armazená-los localmente para evitar nova recolha
+ Mostrar detalhes do produto selecionado na lista

Nesse desafio foi utilizado as seguintes stacks:
+ [Kotlin](https://kotlinlang.org/docs/home.html)
+ [Room](https://developer.android.com/training/data-storage/room)
+ [Compose](https://developer.android.com/jetpack/compose/documentation)
+ [Retrofit](https://square.github.io/retrofit/)
+ [Coroutines](https://developer.android.com/kotlin/coroutines)
+ [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
+ [Compose navigation](https://developer.android.com/jetpack/compose/navigation)
+ MVVM
+ Clean architecture

### Funcionalidade 1 - Lista de Produtos

Ao abrir o app pela primeira vez faz a recolha da lista de produtos na API e armazena localmente para evitar de nova recolha.
Cada item da lista mostra as informações abaixo:

+ Ícone [thumbnail]
+ Título [title]
+ Rating [rating]

### Funcionalidade 2 - Detalhes do Produto

Ao selecionar um item da lista o app abre um novo ecrã que irá consultar o produto no armazenamento local e exibir mais informações relacionados ao produto, sendo elas:

+ Ícone [thumbnail]
+ Título [title]
+ Rating [rating]
+ Marca [brand]
+ Categoria [category]
+ Descrição [description]
+ Percentagem de desconto [discountPercentage]
+ Preço [price]
+ Estoque [stock]
+ Imagens [images]
