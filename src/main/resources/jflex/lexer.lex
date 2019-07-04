package uy.edu.ucu.jsonql2019.parser;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%
%class Lexer 
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

LineTerminator=\r|\n|\r\n
WhiteSpace={LineTerminator}|[ \t\f]
Boolean=true|false
Double=(0|[1-9][0-9]*)(\.[0-9]+)?((e|E)(\+|-)?[0-9]+)?

%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%%  

<YYINITIAL> {    

   ","     			{ return symbolFactory.newSymbol("COMA",COMA); }  
   "*"     			{ return symbolFactory.newSymbol("MULT",MULT); }  
   "/"     			{ return symbolFactory.newSymbol("DIV",DIV); }
   "//"     		{ return symbolFactory.newSymbol("INTDIV",INTDIV); }
   "%"     			{ return symbolFactory.newSymbol("MOD",MOD); }
   "+"     			{ return symbolFactory.newSymbol("PLUS",PLUS); }
   "-"     			{ return symbolFactory.newSymbol("MINUS",MINUS); }
   "("     			{ return symbolFactory.newSymbol("LPAREN",LPAREN); }
   ")"     			{ return symbolFactory.newSymbol("RPAREN",RPAREN); }
   	"=="			{ return symbolFactory.newSymbol("EQUAL",EQUAL);}
	"!="  		    { return symbolFactory.newSymbol("NOT_EQUAL",NOT_EQUAL);}
	"<"				{ return symbolFactory.newSymbol("LESS",LESS); }
	">"				{ return symbolFactory.newSymbol("GREATER",GREATER); }
	"<="			{ return symbolFactory.newSymbol("LESS_EQUAL",LESS_EQUAL); }
	">="			{ return symbolFactory.newSymbol("GREATER_EQUAL",GREATER_EQUAL); }
	"!"				{ return symbolFactory.newSymbol("NOT",NOT); }
	"&&"			{ return symbolFactory.newSymbol("AND",AND); }
	"||"			{ return symbolFactory.newSymbol("OR",OR); }
	"\""			{ return symbolFactory.newSymbol("QUOT",QUOT); }
	"~"				{ return symbolFactory.newSymbol("ENC",ENC); }
	"~="			{ return symbolFactory.newSymbol("ENCA",ENCA); }
	"!~"			{ return symbolFactory.newSymbol("NENCA",NENCA); }
	"{"     		{ return symbolFactory.newSymbol("LBRACES",LBRACES); }
   	"}"     		{ return symbolFactory.newSymbol("RBRACES",RBRACES); }
   	"["     		{ return symbolFactory.newSymbol("LBRACKETS",LBRACKETS); }
   	"]"     		{ return symbolFactory.newSymbol("RBRACKETS",RBRACKETS); }
   	"."     		{ return symbolFactory.newSymbol("PERIOD",PERIOD); }
   	"."     		{ return symbolFactory.newSymbol("PERIOD",PERIOD); }
   	"$"     		{ return symbolFactory.newSymbol("DOLAR",DOLAR); }
   	"<-"     		{ return symbolFactory.newSymbol("ARROW",ARROW); }
   	"/\"     		{ return symbolFactory.newSymbol("INTER",INTER); }
   	"\/"     		{ return symbolFactory.newSymbol("UNION",UNION); }
	
     
   {Boolean}   		{ return symbolFactory.newSymbol("BOOLEAN",BOOLEAN,Boolean.parseBoolean(yytext())); } 
   {Double}      { return symbolFactory.newSymbol("NUMBER",NUMBER,Double.parseDouble(yytext())); }
   {WhiteSpace} 	{            /* nop */                  }
   
}     
   
// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }