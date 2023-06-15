grammar Arithmetic;

// Parser rules
root: expr EOF;

expr: INTEGER | expr OPERATOR expr;

// Lexer rules
INTEGER: [0-9]+;
OPERATOR: '+' | '-';

WS: [ \t\r\n]+ -> skip;
