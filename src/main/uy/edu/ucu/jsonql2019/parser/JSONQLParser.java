
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package uy.edu.ucu.jsonql2019.parser;

import uy.edu.ucu.jsonql2019.ast.*;
import java.io.*;
import java.util.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class JSONQLParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public JSONQLParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public JSONQLParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public JSONQLParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\004\000\002\002\003\000\002\002" +
    "\003\000\002\003\003\000\002\003\003\000\002\003\003" +
    "\000\002\010\002\000\002\003\005\000\002\003\003\000" +
    "\002\003\003\000\002\004\004\000\002\004\005\000\002" +
    "\007\005\000\002\007\007\000\002\005\004\000\002\005" +
    "\005\000\002\006\003\000\002\006\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\020\004\015\005\004\007\016\013\011\014" +
    "\014\016\005\017\012\001\002\000\006\006\031\017\030" +
    "\001\002\000\012\002\ufffe\006\ufffe\010\ufffe\012\ufffe\001" +
    "\002\000\012\002\ufff8\006\ufff8\010\ufff8\012\ufff8\001\002" +
    "\000\012\002\ufff9\006\ufff9\010\ufff9\012\ufff9\001\002\000" +
    "\004\002\027\001\002\000\012\002\ufffc\006\ufffc\010\ufffc" +
    "\012\ufffc\001\002\000\012\002\ufffd\006\ufffd\010\ufffd\012" +
    "\ufffd\001\002\000\004\002\uffff\001\002\000\004\015\ufffb" +
    "\001\002\000\004\002\000\001\002\000\020\005\004\007" +
    "\016\010\020\013\011\014\014\016\005\017\012\001\002" +
    "\000\006\010\ufff1\012\ufff1\001\002\000\012\002\ufff3\006" +
    "\ufff3\010\ufff3\012\ufff3\001\002\000\006\010\023\012\022" +
    "\001\002\000\016\005\004\007\016\013\011\014\014\016" +
    "\005\017\012\001\002\000\012\002\ufff2\006\ufff2\010\ufff2" +
    "\012\ufff2\001\002\000\006\010\ufff0\012\ufff0\001\002\000" +
    "\004\015\026\001\002\000\012\002\ufffa\006\ufffa\010\ufffa" +
    "\012\ufffa\001\002\000\004\002\001\001\002\000\004\011" +
    "\040\001\002\000\012\002\ufff7\006\ufff7\010\ufff7\012\ufff7" +
    "\001\002\000\006\006\034\012\033\001\002\000\004\017" +
    "\035\001\002\000\012\002\ufff6\006\ufff6\010\ufff6\012\ufff6" +
    "\001\002\000\004\011\036\001\002\000\016\005\004\007" +
    "\016\013\011\014\014\016\005\017\012\001\002\000\006" +
    "\006\ufff4\012\ufff4\001\002\000\016\005\004\007\016\013" +
    "\011\014\014\016\005\017\012\001\002\000\006\006\ufff5" +
    "\012\ufff5\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\012\002\007\003\012\004\006\005\005\001" +
    "\001\000\004\007\031\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\010\024" +
    "\001\001\000\002\001\001\000\012\003\016\004\006\005" +
    "\005\006\020\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\003\023\004\006\005\005\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\003\036\004\006\005" +
    "\005\001\001\000\002\001\001\000\010\003\040\004\006" +
    "\005\005\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$JSONQLParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$JSONQLParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$JSONQLParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	public void syntax_error(Symbol currentToken) {
		report_error("Syntax error at [" + (currentToken.left+1) +"," + (currentToken.right+1) +"]", null);
	}

	public static Symbol parse(Reader input) throws Exception {
		return (new JSONQLParser(new JSONQLLexer(input))).parse();
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println(parse(new InputStreamReader(System.in, "UTF8")).value);
		} else for (int i = 0; i < args.length; ++i) {
			System.out.println(parse(new InputStreamReader(new FileInputStream(args[i]), "UTF8")).value);
		}
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$JSONQLParser$actions {
  private final JSONQLParser parser;

  /** Constructor */
  CUP$JSONQLParser$actions(JSONQLParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$JSONQLParser$do_action_part00000000(
    int                        CUP$JSONQLParser$act_num,
    java_cup.runtime.lr_parser CUP$JSONQLParser$parser,
    java.util.Stack            CUP$JSONQLParser$stack,
    int                        CUP$JSONQLParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$JSONQLParser$result;

      /* select the action based on the action number */
      switch (CUP$JSONQLParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= exp EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).right;
		JSONQLExpression start_val = (JSONQLExpression)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).value;
		RESULT = start_val;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$JSONQLParser$parser.done_parsing();
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // exp ::= ROOT 
            {
              JSONQLExpression RESULT =null;
		 RESULT = JSONQLRoot.ROOT; 
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // exp ::= VALUE 
            {
              JSONQLExpression RESULT =null;
		 RESULT = JSONQLRoot.ROOT; 
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // VALUE ::= NUMBER 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		Double i = (Double)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		RESULT=i;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUE",1, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // VALUE ::= STRING 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		RESULT=s;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUE",1, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // VALUE ::= TRUE 
            {
              Object RESULT =null;
		 RESULT=true; 
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUE",1, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // NT$0 ::= 
            {
              Object RESULT =null;
 RESULT=false; 
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("NT$0",6, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // VALUE ::= FALSE NT$0 NULL 
            {
              Object RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).value;
		RESULT=null;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUE",1, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // VALUE ::= OBJECT 
            {
              Object RESULT =null;
		int oleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int oright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		Map<String,Object> o = (Map<String,Object>)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		RESULT=o;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUE",1, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // VALUE ::= ARRAY 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		List<Object> a = (List<Object>)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		RESULT=a;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUE",1, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // OBJECT ::= LBRACE RBRACE 
            {
              Map<String,Object> RESULT =null;
		RESULT= new HashMap<String,Object>();
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("OBJECT",2, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // OBJECT ::= LBRACE PAIRS RBRACE 
            {
              Map<String,Object> RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).right;
		Map<String,Object> p = (Map<String,Object>)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).value;
		 RESULT=p; 
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("OBJECT",2, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // PAIRS ::= STRING COLON VALUE 
            {
              Map<String,Object> RESULT =null;
		int kleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).left;
		int kright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).right;
		String k = (String)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		RESULT=new HashMap<String,Object>(); RESULT.put(k,v);
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("PAIRS",5, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // PAIRS ::= PAIRS COMMA STRING COLON VALUE 
            {
              Map<String,Object> RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-4)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-4)).right;
		Map<String,Object> p = (Map<String,Object>)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-4)).value;
		int kleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).left;
		int kright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).right;
		String k = (String)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		p.put(k,v); System.out.println("p: "+p); RESULT=p;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("PAIRS",5, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-4)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // ARRAY ::= LBRACK RBRACK 
            {
              List<Object> RESULT =null;
		RESULT=new ArrayList();
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("ARRAY",3, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ARRAY ::= LBRACK VALUES RBRACK 
            {
              List<Object> RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).right;
		List<Object> v = (List<Object>)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-1)).value;
		System.out.println("array: " + v); RESULT=v;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("ARRAY",3, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // VALUES ::= VALUE 
            {
              List<Object> RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		RESULT=new ArrayList(); RESULT.add(v);
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUES",4, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // VALUES ::= VALUES COMMA VALUE 
            {
              List<Object> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).right;
		List<Object> a = (List<Object>)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$JSONQLParser$stack.peek()).value;
		a.add(v); RESULT=a;
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("VALUES",4, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.elementAt(CUP$JSONQLParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
            }
          return CUP$JSONQLParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$JSONQLParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$JSONQLParser$do_action(
    int                        CUP$JSONQLParser$act_num,
    java_cup.runtime.lr_parser CUP$JSONQLParser$parser,
    java.util.Stack            CUP$JSONQLParser$stack,
    int                        CUP$JSONQLParser$top)
    throws java.lang.Exception
    {
              return CUP$JSONQLParser$do_action_part00000000(
                               CUP$JSONQLParser$act_num,
                               CUP$JSONQLParser$parser,
                               CUP$JSONQLParser$stack,
                               CUP$JSONQLParser$top);
    }
}

}