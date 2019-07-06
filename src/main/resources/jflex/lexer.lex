package uy.edu.ucu.jsonql2019.parser;

import java_cup.runtime.Symbol;
import java.util.*;

%%

%public
%unicode
%line
%column
%class JSONQLLexer
%cupsym JSONQLTokens
%cup
%implements JSONQLTokens

%{
	/* Embedded lexer class code */
%}


String=(\"([^\\'\n\"]|\\[bfnrt'\\\/])*\")
Number=[+-]?(([0-9]\.)?[0-9]+)([eE][+-]?[0-9]+)?
Hexa=[+-]?0[xX][0-9a-fA-F]+
Regex=\/[^\/]*\/
Identifier=([a-zA-Z_])+([0-9a-zA-Z])*



%%


[ \r\n\t]					{ /* Ignore whitespaces */ }

\$							{ return new Symbol(ROOT, yyline, yycolumn); }

true|false     		{ return new Symbol(BOOL, yyline, yycolumn, new Boolean(yytext())); }
null   				{ return new Symbol(NULL, yyline, yycolumn); }
   
"{"     			{ return new Symbol(LBRACE, yyline, yycolumn); }  
"}"     			{ return new Symbol(RBRACE, yyline, yycolumn); }
":"     			{ return new Symbol(COLON, yyline, yycolumn); }
"."					{ return new Symbol(DOT, yyline, yycolumn); }
","     			{ return new Symbol(COMMA, yyline, yycolumn); }
"["     			{ return new Symbol(LBRACK, yyline, yycolumn); }
"]"     			{ return new Symbol(RBRACK, yyline, yycolumn); }
   
"*"     			{ return new Symbol(MULT, yyline, yycolumn); }
"/"     			{ return new Symbol(DIV, yyline, yycolumn); }
"+"     			{ return new Symbol(PLUS, yyline, yycolumn); }
"-"     			{ return new Symbol(MINUS, yyline, yycolumn); }

"("     			{ return new Symbol(LPARENT, yyline, yycolumn); }  
")"     			{ return new Symbol(RPARENT, yyline, yycolumn); }

"=="			{ return new Symbol(EQUAL, yyline, yycolumn);}
"!="  		    { return new Symbol(NOT_EQUAL, yyline, yycolumn);}
"<"				{ return new Symbol(LESS, yyline, yycolumn); }
">"				{ return new Symbol(GREATER, yyline, yycolumn); }
"<="			{ return new Symbol(LESS_EQUAL, yyline, yycolumn); }
">="			{ return new Symbol(GREATER_EQUAL, yyline, yycolumn); }
"!"				{ return new Symbol(NOT, yyline, yycolumn); }
"&&"			{ return new Symbol(AND, yyline, yycolumn); }
"||"			{ return new Symbol(OR, yyline, yycolumn); }

"~"				{ return new Symbol(ENC, yyline, yycolumn); }
"~="			{ return new Symbol(ENCA, yyline, yycolumn); }
"!~"			{ return new Symbol(NENCA, yyline, yycolumn); }

"<-"			{ return new Symbol(OPASIGN, yyline, yycolumn); }
"\\"			{ return new Symbol(BSLASH, yyline, yycolumn); }
     
{String}     		{ System.out.println("STRING: " + yytext()); return new Symbol(STRING, yyline, yycolumn, new String(yytext())); }
{Hexa}				{ return new Symbol(NUMBER, yyline, yycolumn, Double.valueOf(Integer.parseInt(yytext().split("x")[1], 16))); }           	
{Number}   			{ System.out.println("NUMBER: " + yytext()); return new Symbol(NUMBER, yyline, yycolumn, Double.parseDouble(yytext())); }
[+-]?NaN+  			{ return new Symbol(NUMBER, yyline, yycolumn, Double.NaN); }	
\+?Infinity+ 		{ return new Symbol(NUMBER, yyline, yycolumn, Double.POSITIVE_INFINITY); }
\-Infinity+ 		{ return new Symbol(NUMBER, yyline, yycolumn, Double.NEGATIVE_INFINITY); }
{Regex}     		{ System.out.println("REGEX: " + yytext());return new Symbol(REGEX, yyline, yycolumn, new String(yytext())); }
"else"          	{ return new Symbol(ELSE, yyline, yycolumn); }
"if"   		     	{ return new Symbol(IF, yyline, yycolumn); }
"let"   		    { return new Symbol(LET, yyline, yycolumn); }
"in"   		    	{ return new Symbol(IN, yyline, yycolumn); }
{Identifier}     	{ return new Symbol(ID, yyline, yycolumn); }

