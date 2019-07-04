package uy.edu.ucu.jsonql2019.parser;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%
%class JSONQLLexer 
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{

	public JSONQLLexer(ComplexSymbolFactory sf, java.io.Reader reader){
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
String=(\"([^\\'\n]|\\[bfnrt'\\\/])*\")|(\'([^\\'\n]|\\[bfnrt'\\\/])*\')
Number=[+-]?(([0-9].)?[0-9]+)([eE][+-]?[0-9]+)?
Hexa=[+-]?0[xX][0-9a-fA-F]+

%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%%  

<YYINITIAL> {    

   true     		{ return symbolFactory.newSymbol("TRUE",TRUE); }
   false     		{ return symbolFactory.newSymbol("FALSE",FALSE); }  
   null   			{ return symbolFactory.newSymbol("NULL",NULL); }
   
   "{"     			{ return symbolFactory.newSymbol("LBRACE",LBRACE); }  
   "}"     			{ return symbolFactory.newSymbol("RBRACE",RBRACE); }
   ":"     			{ return symbolFactory.newSymbol("COLON",COLON); }
   ","     			{ return symbolFactory.newSymbol("COMMA",COMMA); }
   "["     			{ return symbolFactory.newSymbol("LBRACK",LBRACK); }
   "]"     			{ return symbolFactory.newSymbol("RBRACK",RBRACK); }
   
   "*"     			{ return symbolFactory.newSymbol("MULT",MULT); }
   "/"     			{ return symbolFactory.newSymbol("DIV",DIV); }
   "//"     		{ return symbolFactory.newSymbol("INTDIV",INTDIV); }
     
   {String}     	{ return symbolFactory.newSymbol("STRING",STRING,new String(yytext())); }
   {Hexa}			{ return symbolFactory.newSymbol("NUMBER",NUMBER,Double.valueOf(Integer.parseInt(yytext().split("x")[1], 16))); }           	
   {Number}   		{ return symbolFactory.newSymbol("NUMBER",NUMBER,Double.parseDouble(yytext())); }
   [+-]?NaN+  		{ return symbolFactory.newSymbol("NUMBER",NUMBER,Double.NaN); }	
   \+?Infinity+ 	{ return symbolFactory.newSymbol("NUMBER",NUMBER,Double.POSITIVE_INFINITY); }
   \-Infinity+ 		{ return symbolFactory.newSymbol("NUMBER",NUMBER,Double.NEGATIVE_INFINITY); }
   {WhiteSpace} 	{                              }
   
}     
   
// error fallback

[^]          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }