/* Generated By:JavaCC: Do not edit this line. FtanML.java */
package ftanml;
import ftanml.objects.*;

public class FtanML implements FtanMLConstants {
  public static void main(String args []) throws ParseException
  {
    FtanML parser = new FtanML(System.in);
    while (true)
    {
      System.out.println(parser.Value().toFtanML());
    }
  }

  final public FtanValue Value() throws ParseException {
  FtanValue result;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case NULL:
    case BOOLEAN:
    case SQ_STRING_START:
    case DQ_STRING_START:
      result = Literal();
      break;
    case ARRAY_START:
      result = Array();
      break;
    case ELEMENT_START:
      result = Element();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public FtanNull Null() throws ParseException {
    jj_consume_token(NULL);
    {if (true) return new FtanNull();}
    throw new Error("Missing return statement in function");
  }

  final public FtanValue Literal() throws ParseException {
  FtanValue result;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      result = Number();
      break;
    case BOOLEAN:
      result = Boolean();
      break;
    case SQ_STRING_START:
    case DQ_STRING_START:
      result = String();
      break;
    case NULL:
      result = Null();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public FtanNumber Number() throws ParseException {
    jj_consume_token(NUMBER);
    {if (true) return new FtanNumber(Double.parseDouble(token.image));}
    throw new Error("Missing return statement in function");
  }

  final public FtanBoolean Boolean() throws ParseException {
    jj_consume_token(BOOLEAN);
    {if (true) return new FtanBoolean(Boolean.parseBoolean(token.image));}
    throw new Error("Missing return statement in function");
  }

  final public FtanString Name() throws ParseException {
    jj_consume_token(NAME);
    {if (true) return new FtanString(token.image);}
    throw new Error("Missing return statement in function");
  }

  final public FtanString String() throws ParseException {
  Token t;
  String result = new String();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SQ_STRING_START:
      jj_consume_token(SQ_STRING_START);
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SQ_CHARACTER:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_1;
        }
        t = jj_consume_token(SQ_CHARACTER);
        result = result + FtanString.deescapeChar(t.image);
      }
      jj_consume_token(SQ_STRING_END);
      break;
    case DQ_STRING_START:
      jj_consume_token(DQ_STRING_START);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DQ_CHARACTER:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
        t = jj_consume_token(DQ_CHARACTER);
        result = result + FtanString.deescapeChar(t.image);
      }
      jj_consume_token(DQ_STRING_END);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return new FtanString(result);}
    throw new Error("Missing return statement in function");
  }

  final public FtanArray Array() throws ParseException {
  java.util.List < FtanValue > values = new java.util.ArrayList < FtanValue > ();
  FtanValue current;
    jj_consume_token(ARRAY_START);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case NULL:
    case BOOLEAN:
    case SQ_STRING_START:
    case DQ_STRING_START:
    case ARRAY_START:
    case ELEMENT_START:
      current = Value();
      values.add(current);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ARRAY_SEPARATOR:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_3;
        }
        jj_consume_token(ARRAY_SEPARATOR);
        current = Value();
        values.add(current);
      }
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(ARRAY_END);
    {if (true) return new FtanArray(values);}
    throw new Error("Missing return statement in function");
  }

  final public java.util.Map.Entry < FtanString, FtanValue > KeyValuePair() throws ParseException {
  FtanString key;
  FtanValue value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SQ_STRING_START:
    case DQ_STRING_START:
      key = String();
      break;
    case NAME:
      key = Name();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ELEMENT_KEYVALUESEPARATOR);
    value = Value();
    {if (true) return new java.util.AbstractMap.SimpleImmutableEntry < FtanString, FtanValue > (key, value);}
    throw new Error("Missing return statement in function");
  }

  final public java.util.Map.Entry < FtanString, FtanValue > FirstKeyValuePair() throws ParseException {
  FtanString key;
  FtanValue value = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SQ_STRING_START:
    case DQ_STRING_START:
      key = String();
      break;
    case NAME:
      key = Name();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELEMENT_KEYVALUESEPARATOR:
      jj_consume_token(ELEMENT_KEYVALUESEPARATOR);
      value = Value();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    {if (true) return new java.util.AbstractMap.SimpleImmutableEntry < FtanString, FtanValue > (key, value);}
    throw new Error("Missing return statement in function");
  }

  final public FtanArray Content() throws ParseException {
  java.util.ArrayList < FtanValue > values = new java.util.ArrayList < FtanValue > ();
  FtanValue current;
  String currentStr = new String();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELEMENT_START:
      case CONTENTCHAR:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONTENTCHAR:
        jj_consume_token(CONTENTCHAR);
        currentStr = currentStr + FtanString.deescapeChar(token.image);
        break;
      case ELEMENT_START:
        current = Element();
      if (currentStr.length() > 0)
      {
        values.add(new FtanString(currentStr));
        currentStr = new String();
      }
      values.add(current);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    if (currentStr.length() > 0)
    {
      values.add(new FtanString(currentStr));
      currentStr = new String();
    }
    {if (true) return new FtanArray(values);}
    throw new Error("Missing return statement in function");
  }

  final public FtanElement Element() throws ParseException {
  java.util.LinkedHashMap < FtanString, FtanValue > attributes = new java.util.LinkedHashMap < FtanString, FtanValue > ();
  java.util.Map.Entry < FtanString, FtanValue > currentAttribute;
  FtanArray content;
    jj_consume_token(ELEMENT_START);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SQ_STRING_START:
    case DQ_STRING_START:
    case NAME:
      currentAttribute = FirstKeyValuePair();
        if (currentAttribute.getValue() == null) attributes.put(FtanElement.NAME_KEY, currentAttribute.getKey());
        else attributes.put(currentAttribute.getKey(), currentAttribute.getValue());
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SQ_STRING_START:
        case DQ_STRING_START:
        case NAME:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_5;
        }
        currentAttribute = KeyValuePair();
        attributes.put(currentAttribute.getKey(), currentAttribute.getValue());
      }
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELEMENT_CONTENTSEPARATOR:
      jj_consume_token(ELEMENT_CONTENTSEPARATOR);
      content = Content();
      attributes.put(FtanElement.CONTENT_KEY, content);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    jj_consume_token(ELEMENT_END);
    {if (true) return new FtanElement(attributes);}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public FtanMLTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1207a0,0x7a0,0x2000,0x8000,0x600,0x40000,0x1207a0,0x800600,0x800600,0x400000,0x20100000,0x20100000,0x800600,0x800600,0x4000000,};
   }

  /** Constructor with InputStream. */
  public FtanML(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public FtanML(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new FtanMLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public FtanML(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new FtanMLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public FtanML(FtanMLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(FtanMLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
