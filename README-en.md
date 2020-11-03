# Tucuruí

**Tucuruí** is a textual language for hierarchical organization of information, semantically similar to [XML](https://en.wikipedia.org/wiki/XML).

The name *Tucuruí* comes from the Tupi language (Brazil) and means *"grasshopper river"*.

Tradução para **Português/Brasil**: [http://joseflavio.com/tucurui/pt](http://joseflavio.com/tucurui/pt)

> **Current version:** 1.0<br>
> **Repository:** [https://github.com/joseflaviojr/tucurui](https://github.com/joseflaviojr/tucurui)<br>
> **License:** GNU Lesser General Public License, version 3 (LGPLv3)<br>
> **Authors:**<br>
> [José Flávio de Souza Dias Júnior](http://joseflavio.com) - contato@joseflavio.com

## 1. Tucuruí Document

### 1.1. Elements

Main elements of a Tucuruí document:

 - Object
 - Value
 - Comment

The elements are organized hierarchically by **indentation** (tab or 4 spaces).

### 1.2. Object and Value

The main element of a Tucuruí document is the **object**, which can aggregate a **value**:

``` no-highlight
html
    head
        title: Hello world!
    body
```

Conceptually, Tucuruí **objects** are equivalent to [XML](https://en.wikipedia.org/wiki/XML) **tags**, and **values** are **contents**. Notice the previous example in the [HTML](https://en.wikipedia.org/wiki/HTML) syntax:

``` no-highlight
<html>
    <head>
        <title>Hello world!</title>
    </head>
    <body>
    </body>
</html>
```

> The indentation of the HTML examples in this documentation do not match the actual results of the automatic conversion, thus only to improve understanding.

The `title` object contains the `Hello world!` value and was preceded by 2 indents, being hierarchically subordinate to the `head` object, which with 1 indentation is subordinate to the `html` root object. Every value contained in the same line of its object must be preceded by a colon and a space, as in `title: Hello world!`.

> A Tucuruí document can contain more than one root object, including homonyms.

### 1.3. Anonymous Object

The value of an object can also be defined through the concatenation of **anonymous objects**:

``` no-highlight
html
    body
        p
            : Hi! My name is
            :  Tucuruí.
        p: Grasshopper river.
```

``` no-highlight
<html>
    <body>
        <p>Hi! My name is Tucuruí.</p>
        <p>Grasshopper river.</p>
    </body>
</html>
```

### 1.4. Free Value

**Free value** is the continuous declaration of a **multi-line** value:

``` no-highlight
html
    body
        div
            ---
            Hi! My name is Tucuruí.
            Grasshopper river.
            ---
```

``` no-highlight
<html>
    <body>
        <div>
            Hi! My name is Tucuruí.
            Grasshopper river.
        </div>
    </body>
</html>
```

In fact, a free value is a set of values, with the inclusion of `{n}` line break being automatic at the end of all lines except the last one. Descending objects of a free value will be subordinated only to the last value (last line). Equivalence example:

``` no-highlight
obj
    ---
    Line 1
    Line 2
    Line 3
    ---
        -id: 000
```

``` no-highlight
obj
    : Line 1{n}
    : Line 2{n}
    : Line 3
        -id: 000
```

### 1.5. Concatenation

The sequence of elements establishes a **concatenation** stream:

``` no-highlight
html
    body
        div
            : My name is 
            strong: Tucuruí
            : . Grasshopper river.
```

``` no-highlight
<html>
    <body>
        <div>
            My name is <strong>Tucuruí</strong>. Grasshopper river.
        </div>
    </body>
</html>
```

Elements can be interleaved, regardless of order:

``` no-highlight
html
    body
        div
            h1: Tucuruí
            : My name is 
            strong: Tucuruí
            ---
            . Grasshopper river.
            ---
```

``` no-highlight
<html>
    <body>
        <div>
            <h1>Tucuruí</h1>
            My name is <strong>Tucuruí</strong>. Grasshopper river.
        </div>
    </body>
</html>
```

### 1.6. Character Encoder

It's possible use **character encoders** through hexadecimal numbers from the [Unicode](https://unicode-table.com/en/) table. Example that defines the phrase `Tucuruí = River + Grasshoppers`:

``` no-highlight
html
    body
        : Tucuruí{20}{3D}{20}
        : River {2B} Grasshoppers
```

``` no-highlight
<html>
    <body>
        Tucuruí&nbsp;&#61;&nbsp;River &#43; Grasshoppers
    </body>
</html>
```

There are **special encoders** that are not related to the [Unicode](https://unicode-table.com/en/) table:

 - `{n}`  : new line
 - `{t}`  : tab

### 1.7. Private Object

**Private object** is equivalent to the **attribute** concept of the [XML](https://en.wikipedia.org/wiki/XML). Every private object is prefixed with `-`:

``` no-highlight
html
    body
        div: My name is Tucuruí
            -id: foo
            -class: bar
            
```

``` no-highlight
<html>
    <body>
        <div id="foo" class="bar">
            My name is Tucuruí
        </div>
    </body>
</html>
```

The central idea about the private object is to establish a dependency binding between objects. Private objects have a strong link to the next higher element in the hierarchy.

> Private objects may also contain other elements, such as free values, which makes the Tucuruí strongly different from the [XML](https://en.wikipedia.org/wiki/XML).

### 1.8. Comment

A comment line can be defined with the prefix `//`:

``` no-highlight
html
    body
        //Example of comment
        p: My name is Tucuruí
```

``` no-highlight
<html>
    <body>
        <!--Example of comment-->
        <p>My name is Tucuruí</p>
    </body>
</html>
```

> There are only single-line comments, and they must be unique in the line, never after objects or values.

### 1.9. Header

Tucuruí documents may contain the following **headers**:

``` no-highlight
# 1.0 UTF-8
@ http://foo/bar/HTML5.tuc

html
    body
        p: My name is Tucuruí
```

The `# 1.0 UTF-8` header specifies the Tucuruí version used and the character encoding. The `@ http://foo/bar/HTML5.tuc` line specifies the [URL](https://en.wikipedia.org/wiki/URL) of the Tucuruí document template, which in this case consists of a hypothetical template of HTML5 content.

### 1.10. Archiving and Exchange

The archiving and exchange of Tucuruí documents is done through raw text files with `.tuc` **extension**. Examples:

 - `Document.tuc`
 - `List of People.tuc`
 - `index.tuc`

> The **standard character encoding** of Tucuruí documents is the `UTF-8`.<br>
> **MIME type**: `text/tucurui`

## 2. Tucuruí Document Template

**Tucuruí Document Template** is a Tucuruí document that specifies the desired hierarchical structure, not mandatory, for the documents that point to it.

> Templates should not contain *values*.

Short [HTML](https://en.wikipedia.org/wiki/HTML) template example:

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
        !flow
        
!flow
    div
        !flow
    strong
    img
```

### 2.1. Inheritance

Object with prefix `!` represents a group of objects allowed in direct descent, a feature called **inheritance**. Inheritance is defined at the root of the template, and every time it occurs along the structure, it indicates the possible set of objects at that location.

``` no-highlight
# 1.0 UTF-8
@ Tucuruí

html
    head
        title
    body
        !global
        !flow

!flow
    div
        !global
        !flow
    strong
        !global
    img
        !global

!global
    !identification
    !style

!identification
    -id
    
!style
    -class
    -style
```

> The template of any template should be `@ Tucuruí`.

### 2.2. Denial

Another feature available for templates is the **denial**, which is the indication of an object or a group of objects (through inheritance) that will be excluded from the offspring.

**Direct denial** is the exclusion limited to the first level of offspring. It is determined by including the unwanted object name (or group, by inheritance) between *parentheses*.

**Total denial** is the exclusion at all levels of offspring. It is determined by including the unwanted object name (or group, by inheritance) between *double parentheses*.

Example:

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

In the above example, the `style` object will be rejected within the scope of the `body` object.

## 3. Implementation

The [Urucum](https://github.com/joseflaviojr/urucum) Java library implements Tucuruí.

As an example, consider the `/temp/teste.tuc` file:

``` no-highlight
html
    head
        title: Tucuruí
```

Running in Java, using [Urucum](https://github.com/joseflaviojr/urucum):

``` java
Tucurui tuc = TucuruiUtil.abrir("/temp/teste.tuc" );
String html = tuc.gerarHTML();
System.out.println( html );
```

Output:

``` html
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tucuru&iacute;</title>
</head>
</html>
```

Running:

``` java
Tucurui tuc = TucuruiUtil.abrir("/temp/teste.tuc" );
String xml = tuc.gerarXML();
System.out.println( xml );
```

Output:

``` xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<html>
<head>
<title>Tucuruí</title>
</head>
</html>
```

Another example:

``` java
Tucurui tuc = TucuruiUtil.abrir("/temp/teste.tuc" );
String title = tuc.obj( "html" ).obj( "head" ).obj( "title" ).valor().texto();
System.out.println( title );
```

The above code will have as output the `Tucuruí` value.

> The [Urucum](https://github.com/joseflaviojr/urucum) library enables the conversion of Tucuruí documents to [XML](https://en.wikipedia.org/wiki/XML) and vice versa, expanding its scope of application.

### 3.1 Groovy Script

This project includes basic implementation of script in [Groovy](https://www.groovy-lang.org/syntax.html) language that uses [Urucum](https://github.com/joseflaviojr/urucum) to perform, in the command terminal, quick conversion of Tucuruí to XML or HTML.

``` groovy
./tuc-html.groovy Exemplo.tuc
./tuc-xml.groovy Exemplo.tuc
```

Or:

``` groovy
groovy tuc-html.groovy Exemplo.tuc
groovy tuc-xml.groovy Exemplo.tuc
```

HTML output:

``` html
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tucuru&iacute;</title>
</head>
<body>
<p>Meu nome &eacute; <strong>Tucuru&iacute;</strong>. Rio dos gafanhotos.</p>
</body>
</html>
```
