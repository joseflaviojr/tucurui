# Tucuruí

**Tucuruí** é uma linguagem textual para organização hierárquica de informação, semanticamente similar à [XML](https://pt.wikipedia.org/wiki/XML).

O nome *Tucuruí* é proveniente da língua Tupi (Brasil) e significa *"rio dos gafanhotos"*.

Translation to **English**: [http://joseflavio.com/tucurui/en](http://joseflavio.com/tucurui/en)

> **Versão atual:** 1.0
> **Repositório:** [https://github.com/joseflaviojr/tucurui](https://github.com/joseflaviojr/tucurui)
> **Autores:**
> [José Flávio de Souza Dias Júnior](http://joseflavio.com) - contato@joseflavio.com

## 1. Documento Tucuruí

### 1.1. Elementos

Principais elementos de um documento Tucuruí:

 - Objeto
 - Valor
 - Comentário

Os elementos são organizados hierarquicamente através de **indentação** (tabulação ou 4 espaços).

### 1.2. Objeto e Valor

O principal elemento de um documento Tucuruí é o **objeto**, o qual pode agregar um **valor**:

``` no-highlight
html
    head
        title: Alô mundo!
    body
```

Conceituamente, **objetos** Tucuruí são equivalentes a **tags** [XML](https://pt.wikipedia.org/wiki/XML), e **valores** são **conteúdos**. Observe o exemplo anterior na sintaxe [HTML](https://pt.wikipedia.org/wiki/HTML):

``` no-highlight
<html>
    <head>
        <title>Alô mundo!</title>
    </head>
    <body>
    </body>
</html>
```

O objeto `title` contém o valor `Alô mundo!` e foi precedido por 2 indentações, estando hierarquicamente subordinado ao objeto `head`, que com 1 indentação está subordinado ao objeto raiz `html`. Todo valor contido na mesma linha do seu referido objeto deve ser precedido por dois pontos e um espaço, tal como em `title: Alô mundo!`.

> Um documento Tucuruí pode conter mais de um objeto raiz, inclusive homônimos.

### 1.3. Objeto Anônimo

O valor de um objeto pode ser também definido através da concatenação de **objetos anônimos**:

``` no-highlight
html
    body
        p
            : Oi! Meu nome é
            :  Tucuruí.
        p: Rio dos gafanhotos.
```

``` no-highlight
<html>
    <body>
        <p>Oi! Meu nome é Tucuruí.</p>
        <p>Rio dos gafanhotos.</p>
    </body>
</html>
```

### 1.4. Valor Livre

**Valor livre** é a declaração contínua de um valor **multilinha**:

``` no-highlight
html
    body
        div
            ---
            Oi! Meu nome é Tucuruí.
            Rio dos gafanhotos.
            ---
```

``` no-highlight
<html>
    <body>
        <div>
            Oi! Meu nome é Tucuruí.
            Rio dos gafanhotos.
        </div>
    </body>
</html>
```

### 1.5. Concatenação

A sequência de elementos estabelece um fluxo de **concatenação**:

``` no-highlight
html
    body
        div
            : Meu nome é 
            strong: Tucuruí
            : . Rio dos gafanhotos.
```

``` no-highlight
<html>
    <body>
        <div>
            Meu nome é <strong>Tucuruí</strong>. Rio dos gafanhotos.
        </div>
    </body>
</html>
```

Elementos podem ser intercalados, independente de ordem:

``` no-highlight
html
    body
        div
            h1: Tucuruí
            : Meu nome é 
            strong: Tucuruí
            ---
            . Rio dos gafanhotos.
            ---
```

``` no-highlight
<html>
    <body>
        <div>
            <h1>Tucuruí</h1>
            Meu nome é <strong>Tucuruí</strong>. Rio dos gafanhotos.
        </div>
    </body>
</html>
```

### 1.6. Codificador de Caractere

É possível utilizar **codificadores de caracteres** através de números hexadecimais da tabela [Unicode](https://unicode-table.com/pt/). Exemplo que define a frase `Tucuruí = Rio + Gafanhotos`:

``` no-highlight
html
    body
        : Tucuruí{20}{3D}{20}
        : Rio {2B} Gafanhotos
```

``` no-highlight
<html>
    <body>
        Tucuruí&nbsp;&#61;&nbsp;Rio &#43; Gafanhotos
    </body>
</html>
```

Há **codificadores especiais** que não estão relacionados à tabela [Unicode](https://unicode-table.com/pt/):

 - `{n}`  : nova linha
 - `{t}`  : tabulação

### 1.7. Objeto Privado

**Objeto privado** é equivalente ao conceito de **atributo** da [XML](https://pt.wikipedia.org/wiki/XML). Todo objeto privado é prefixado com `-`:

``` no-highlight
html
    body
        div: Meu nome é Tucuruí
            -id: foo
            -class: bar
            
```

``` no-highlight
<html>
    <body>
        <div id="foo" class="bar">
            Meu nome é Tucuruí
        </div>
    </body>
</html>
```

A ideia central acerca do objeto privado é estabelecer uma ligação de dependência entre objetos. Objetos privados possuem um forte vínculo com o elemento imediatamente superior na hierarquia.

> Objetos privados também podem conter outros elementos, como por exemplo os valores livres, o que difere fortemente a Tucuruí da [XML](https://pt.wikipedia.org/wiki/XML).

### 1.8. Comentário

Uma linha de comentário pode ser definida com o prefixo `//`:

``` no-highlight
html
    body
        //Exemplo de comentário
        p: Meu nome é Tucuruí
```

``` no-highlight
<html>
    <body>
        <!--Exemplo de comentário-->
        <p>Meu nome é Tucuruí</p>
    </body>
</html>
```

> Só existem comentários de uma linha, e eles devem ser exclusivos na linha, jamais após objetos ou valores.

### 1.9. Cabeçalho

Documentos Tucuruí podem conter os seguintes **cabeçalhos**:

``` no-highlight
# 1.0 UTF-8
@ http://foo/bar/HTML5.tuc

html
    body
        p: Meu nome é Tucuruí
```

O cabeçalho `# 1.0 UTF-8` especifica a versão da Tucuruí utilizada e a codificação do texto. A linha `@ http://foo/bar/HTML5.tuc` especifica a [URL](https://pt.wikipedia.org/wiki/URL) do modelo de documento Tucuruí, que neste caso consiste num modelo hipotético de conteúdo HTML5.

### 1.10. Arquivamento e Intercâmbio

O arquivamento e o intercâmbio de documentos Tucuruí é feito através de arquivos de texto puro com **extensão** `.tuc`. Exemplos:

 - `Documento.tuc`
 - `Lista de Pessoas.tuc`
 - `index.tuc`

> A **codificação padrão** de documentos Tucuruí é a `UTF-8`.
> **MIME type**: `text/tucurui`

## 2. Modelo Tucuruí

**Modelo Tucuruí** é um documento Tucuruí que especifica a estrutura hierárquica desejada, não obrigatória, para os documentos que apontam para ele.

> Modelos Tucuruí não devem conter *valores*.

Exemplo de modelo de [HTML](https://pt.wikipedia.org/wiki/HTML) resumido:

``` no-highlight
# 1.0 UTF-8
@ Tucuruí

html
    head
        title
        meta
        style
        script
    body
        !fluxo
        
!fluxo
    div
        !fluxo
    strong
    img
```

### 2.1. Herança

Objeto com prefixo `!` representa um grupo de objetos permitidos na descendência direta, recurso este denominado **herança**. A herança é definida na raiz do modelo e, toda vez que ocorre ao longo da estrutura, indica o conjunto possível de objetos naquele local.

``` no-highlight
# 1.0 UTF-8
@ Tucuruí

html
    head
        title
    body
        !global
        !fluxo

!fluxo
    div
        !global
        !fluxo
    strong
        !global
    img
        !global

!global
    !identificacao
    !estilo

!identificacao
    -id
    
!estilo
    -class
    -style
```

> O modelo de todo modelo deve ser `@ Tucuruí`.

### 2.2. Negação

Outro recurso disponível para os modelos é a **negação**, que consiste na indicação de um objeto ou de um grupo de objetos (através de herança) que será excluído da descendência.

**Negação direta** é a exclusão limitada ao primeiro nível de descendência. Ela é determinada através da inclusão do nome do objeto (ou grupo, por herança) indesejado entre *parênteses*.

**Negação total** é a exclusão em todos os níveis de descendência. Ela é determinada através da inclusão do nome do objeto (ou grupo, por herança) indesejado entre *duplo parênteses*.

Exemplo:

``` no-highlight
# 1.0 UTF-8
@ Tucuruí

html
    head
        title
        !tags
    body
        !tags
        ((style))

!tags
    style
    script
```

No exemplo acima, o objeto `style` será rejeitado dentro do escopo do objeto `body`.

## 3. Implementação

A biblioteca Java [Urucum](https://github.com/joseflaviojr/urucum) implementa Tucuruí.

Como exemplo, considere o arquivo `/temp/teste.tuc`:

``` no-highlight
html
    head
        title: Tucuruí
```

Executando em Java, utilizando [Urucum](https://github.com/joseflaviojr/urucum):

``` java
Tucurui tuc = TucuruiUtil.abrir("/temp/teste.tuc" );
String html = tuc.gerarHTML();
System.out.println( html );
```

Saída:

``` html
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tucuru&iacute;</title>
</head>
</html>
```

Executando:

``` java
Tucurui tuc = TucuruiUtil.abrir("/temp/teste.tuc" );
String xml = tuc.gerarXML();
System.out.println( xml );
```

Saída:

``` xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<html>
<head>
<title>Tucuruí</title>
</head>
</html>
```

Outro exemplo:

``` java
Tucurui tuc = TucuruiUtil.abrir("/temp/teste.tuc" );
String titulo = tuc.obj( "html" ).obj( "head" ).obj( "title" ).valor().texto();
System.out.println( titulo );
```

O código acima terá como saída o valor `Tucuruí`.

> A biblioteca [Urucum](https://github.com/joseflaviojr/urucum) possibilita a conversão de documentos Tucuruí para `org.w3c.dom.Document` (XML/DOM), ampliando seu escopo de aplicação.
