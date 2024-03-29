## JLOX ##

JLOX interpreter where it leverages byetcode and JVM. 
- Faster Execution: Bytecode delivers efficient interpreteation.
- Using JVM, able to run JLOX programs on any machine.


## Lox Lexical Grammar ##

    NUMBER          → DIGIT+ ( "." DIGIT+ )? ;
    STRING          → '"' <any char except '"'>* '"' ;
    IDENTIFIER      → ALPHA ( ALPHA | DIGIT )* ;
    ALPHA           → 'a' ... 'z' | 'A' ... 'Z' | '_' ;
    DIGIT           → '0' ... '9' ;


## Lox Syntax Grammar ##

    program         → declaration* EOF ;
    
    declaration     → classDecl
                    | funDecl
                    | varDecl
                    | statement ;
    classDecl       → "class" IDENTIFIER ( "<" IDENTIFIER )?
                    "{" function* "}" ;
    funDecl         → "fun" function ;
    function        → IDENTIFIER "(" parameters? ")" block ;
    parameters      → IDENTIFIER ( "," IDENTIFIER )* ;
    varDecl         → "var" IDENTIFIER ( "=" expression )? ";" ;
    
    statement       → exprStmt
                    | forStmt
                    | ifStmt
                    | printStmt
                    | returnStmt
                    | whileStmt
                    | block ;
                    
    exprStmt        → expression ";" ;                    
    forStmt         → "for" "(" ( varDecl | exprStmt | ";" )
                                expression? ";"
                                expression? ")" statement ;
    ifStmt          → "if" "(" expression ")" statement ( "else" statement )? ;
    printStmt       → "print" expression ";" ;
    returnStmt      → "return" expression? ";" ;
    whileStmt       → "while" "(" expression ")" statement ; 
    block           → "{" declaration* "}" ;
    
    expression      → assignment ;
    
    assignment      → ( call "." )? IDENTIFIER "=" assignment
                    | logic_or ;
                    
    logic_or        → logic_and ( "or" logic_and )* ;
    logic_and       → equality ( "and" equality )* ;
    equality        → comparison ( ( "!=" | "==" ) comparison )* ;
    comparison      → addition ( ( ">" | ">=" | "<" | "<=" ) addition )* ;
    addition        → multiplication ( ( "-" | "+" ) multiplication )* ;
    multiplication  → unary ( ( "/" | "*" ) unary )* ;
    
    unary           → ( "!" | "-" ) unary | call ;
    call            → primary ( "(" arguments? ")" | "." IDENTIFIER )* ;
    arguments       → expression ( "," expression )* ;
    primary         → "true" | "false" | "nil" | "this"
                    | NUMBER | STRING | IDENTIFIER | "(" expression ")"
                    | "super" "." IDENTIFIER ;
                
## Lox Precedence Rules ##

Name            |       Operators       | Associates
:--------------:|:---------------------:|:---------:
Unary           |   `!` `-`             | Right
Multiplication  |   `/` `*`             | Left
Addition        |   `-` `+`             | Left
Comparison      |   `>` `>=` `<` `<=`   | Left
Equality        |   `==` `!=`           | Left
