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

%%

[ \r\n\t]					{ /* Ignore whitespaces */ }

\$							{ return new Symbol(ROOT, yyline, yycolumn); }

.                           { System.out.println("Error in Lexer! at line " + yyline + " column " + yycolumn); }
