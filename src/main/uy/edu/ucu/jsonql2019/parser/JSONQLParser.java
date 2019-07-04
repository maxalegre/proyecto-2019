
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
    "\000\003\000\002\002\004\000\002\002\003\000\002\002" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\005\000\006\004\005\005\004\001\002\000\004\002" +
    "\uffff\001\002\000\004\002\000\001\002\000\004\002\007" +
    "\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\005\000\004\002\005\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

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
          case 2: // exp ::= TRUE 
            {
              JSONQLExpression RESULT =null;
		 RESULT = true; 
              CUP$JSONQLParser$result = parser.getSymbolFactory().newSymbol("exp",0, ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONQLParser$stack.peek()), RESULT);
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
