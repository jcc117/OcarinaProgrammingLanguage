/* The following code was generated by JFlex 1.6.1 */

import java_cup.runtime.*;
import java.math.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>OcarinaLexer.flex</tt>
 */
class OcarinaLexer extends sym implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\16\1\13\2\0\1\16\23\0\1\60\1\17\1\12\1\0"+
    "\1\75\1\0\1\14\1\50\1\51\1\15\1\56\1\74\1\6\1\7"+
    "\1\62\1\2\7\5\2\1\1\72\1\71\1\64\1\63\1\57\1\11"+
    "\1\73\1\4\1\54\3\4\1\52\2\10\1\47\11\10\1\53\4\10"+
    "\1\3\2\10\1\65\1\0\1\66\1\61\1\10\1\0\1\22\1\33"+
    "\1\27\1\26\1\24\1\41\1\44\1\42\1\35\1\10\1\37\1\30"+
    "\1\36\1\25\1\34\1\43\1\46\1\23\1\20\1\21\1\32\1\40"+
    "\1\45\1\31\1\55\1\10\1\67\1\0\1\70\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\2\6\1\1"+
    "\1\7\1\1\24\3\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\0\1\32\2\2"+
    "\1\33\1\34\1\32\1\6\2\0\1\35\22\3\1\36"+
    "\10\3\1\37\1\3\1\40\12\3\1\41\1\42\1\43"+
    "\1\0\11\3\1\44\2\3\1\45\5\3\1\46\1\47"+
    "\11\3\1\50\4\3\1\51\6\3\1\0\2\3\1\52"+
    "\1\53\1\3\1\54\1\55\4\3\1\56\1\3\1\57"+
    "\1\3\1\60\12\3\1\61\1\62\14\3\1\0\1\63"+
    "\3\3\1\64\4\3\1\65\1\3\1\66\3\3\1\67"+
    "\1\70\1\71\1\3\1\72\1\73\2\3\1\74\6\3"+
    "\1\75\1\0\1\76\1\3\1\77\1\100\1\101\1\3"+
    "\1\102\1\103\2\3\1\104\4\3\1\105\4\3\1\6"+
    "\1\3\1\106\2\3\1\107\1\110\1\3\1\111\1\0"+
    "\3\3\1\6\2\3\1\112\1\3\1\113\5\3\1\114"+
    "\1\0\2\3\1\115\1\3\1\116\1\0\1\3\1\117"+
    "\1\120\1\0\1\121";

  private static int [] zzUnpackAction() {
    int [] result = new int[277];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\76\0\174\0\272\0\370\0\u0136\0\u0174\0\u01b2"+
    "\0\u01f0\0\u022e\0\76\0\u026c\0\u02aa\0\u02e8\0\u0326\0\u0364"+
    "\0\u03a2\0\u03e0\0\u041e\0\u045c\0\u049a\0\u04d8\0\u0516\0\u0554"+
    "\0\u0592\0\u05d0\0\u060e\0\u064c\0\u068a\0\u06c8\0\u0706\0\u0744"+
    "\0\76\0\76\0\u0782\0\u07c0\0\76\0\76\0\76\0\76"+
    "\0\u07fe\0\76\0\76\0\76\0\76\0\76\0\76\0\76"+
    "\0\76\0\76\0\u0174\0\u083c\0\u087a\0\u08b8\0\76\0\76"+
    "\0\u0174\0\76\0\u08f6\0\u026c\0\76\0\u0934\0\u0972\0\u09b0"+
    "\0\u09ee\0\u0a2c\0\u0a6a\0\u0aa8\0\u0ae6\0\u0b24\0\u0b62\0\u0ba0"+
    "\0\u0bde\0\u0c1c\0\u0c5a\0\u0c98\0\u0cd6\0\u0d14\0\u0d52\0\370"+
    "\0\u0d90\0\u0dce\0\u0e0c\0\u0e4a\0\u0e88\0\u0ec6\0\u0f04\0\u0f42"+
    "\0\370\0\u0f80\0\370\0\u0fbe\0\u0ffc\0\u103a\0\u1078\0\u10b6"+
    "\0\u10f4\0\u1132\0\u1170\0\u11ae\0\u11ec\0\76\0\76\0\76"+
    "\0\u122a\0\u1268\0\u12a6\0\u12e4\0\u1322\0\u1360\0\u139e\0\u13dc"+
    "\0\u141a\0\u1458\0\370\0\u1496\0\u14d4\0\370\0\u1512\0\u1550"+
    "\0\u158e\0\u15cc\0\u160a\0\370\0\370\0\u1648\0\u1686\0\u16c4"+
    "\0\u1702\0\u1740\0\u177e\0\u17bc\0\u17fa\0\u1838\0\370\0\u1876"+
    "\0\u18b4\0\u18f2\0\u1930\0\370\0\u196e\0\u19ac\0\u19ea\0\u1a28"+
    "\0\u1a66\0\u1aa4\0\u1ae2\0\u1b20\0\u1b5e\0\370\0\370\0\u1b9c"+
    "\0\370\0\370\0\u1bda\0\u1c18\0\u1c56\0\u1c94\0\370\0\u1cd2"+
    "\0\370\0\u1d10\0\370\0\u1d4e\0\u1d8c\0\u1dca\0\u1e08\0\u1e46"+
    "\0\u1e84\0\u1ec2\0\u1f00\0\u1f3e\0\u1f7c\0\370\0\370\0\u1fba"+
    "\0\u1ff8\0\u2036\0\u2074\0\u20b2\0\u20f0\0\u212e\0\u216c\0\u21aa"+
    "\0\u21e8\0\u2226\0\u2264\0\u22a2\0\370\0\u22e0\0\u231e\0\u235c"+
    "\0\370\0\u239a\0\u23d8\0\u2416\0\u2454\0\370\0\u2492\0\370"+
    "\0\u24d0\0\u250e\0\u254c\0\370\0\370\0\370\0\u258a\0\370"+
    "\0\370\0\u25c8\0\u2606\0\370\0\u2644\0\u2682\0\u26c0\0\u26fe"+
    "\0\u273c\0\u277a\0\370\0\u27b8\0\370\0\u27f6\0\370\0\370"+
    "\0\370\0\u2834\0\370\0\370\0\u2872\0\u28b0\0\370\0\u28ee"+
    "\0\u292c\0\u296a\0\u29a8\0\370\0\u29e6\0\u2a24\0\u2a62\0\u2aa0"+
    "\0\u2ade\0\u2b1c\0\370\0\u2b5a\0\u2b98\0\370\0\370\0\u2bd6"+
    "\0\370\0\u2c14\0\u2c52\0\u2c90\0\u2cce\0\u2d0c\0\u2d4a\0\u2d88"+
    "\0\370\0\u2dc6\0\76\0\u2e04\0\u2e42\0\u2e80\0\u2ebe\0\u2efc"+
    "\0\370\0\u2f3a\0\u2f78\0\u2fb6\0\370\0\u2ff4\0\76\0\u3032"+
    "\0\u3070\0\370\0\76\0\u30ae\0\76";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[277];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\2\5\1\3\1\6\1\7\1\5"+
    "\1\2\1\10\1\11\1\12\1\13\1\11\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\5\1\26\1\27\1\30\1\31\1\32\1\5\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\2\5\1\41\1\42"+
    "\4\5\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\1\62\77\0\2\3\2\0\1\3\1\0\1\63\67\0"+
    "\1\64\1\65\1\66\1\0\1\65\1\0\1\63\21\0"+
    "\1\66\45\0\5\5\2\0\2\5\6\0\30\5\2\0"+
    "\4\5\21\0\2\64\2\0\1\64\1\67\1\63\47\0"+
    "\1\70\17\0\2\71\2\0\1\71\70\0\13\10\1\72"+
    "\62\10\13\0\1\11\2\0\1\11\73\0\1\73\70\0"+
    "\1\74\7\0\1\75\57\0\5\5\2\0\2\5\6\0"+
    "\1\5\1\76\1\77\7\5\1\100\15\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\3\5\1\101\16\5"+
    "\1\102\5\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\103\2\5\1\104\1\5\1\105\22\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\2\5\1\106"+
    "\1\5\1\107\23\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\5\5\1\110\2\5\1\111\1\112\14\5"+
    "\1\113\1\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\2\5\1\114\11\5\1\115\1\116\12\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\4\5\1\117"+
    "\7\5\1\120\13\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\3\5\1\121\4\5\1\122\3\5\1\123"+
    "\13\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\4\5\1\124\23\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\1\125\27\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\3\5\1\126\1\127\7\5\1\130"+
    "\13\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\3\5\1\131\24\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\5\5\1\132\13\5\1\133\6\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\14\5\1\134"+
    "\13\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\14\5\1\135\13\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\2\5\1\136\5\5\1\137\3\5\1\140"+
    "\13\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\2\5\1\141\25\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\3\5\1\142\6\5\1\143\15\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\4\5\1\144"+
    "\23\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\22\5\1\145\5\5\2\0\4\5\21\0\2\64\2\0"+
    "\1\64\1\0\1\63\46\0\1\146\102\0\1\147\75\0"+
    "\1\150\13\0\2\64\2\0\1\64\1\0\1\63\67\0"+
    "\1\64\1\65\2\0\1\65\1\0\1\63\67\0\2\66"+
    "\1\0\2\66\14\0\1\66\1\0\1\66\1\0\2\66"+
    "\3\0\1\66\5\0\1\66\10\0\1\66\1\0\1\66"+
    "\35\0\1\151\62\0\5\5\2\0\2\5\6\0\2\5"+
    "\1\152\1\153\6\5\1\154\15\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\24\5\1\155\3\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\13\5\1\156"+
    "\14\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\12\5\1\157\15\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\15\5\1\160\12\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\1\161\27\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\3\5\1\162\24\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\6\5"+
    "\1\163\21\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\164\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\1\5\1\165\26\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\6\5\1\166\21\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\1\167"+
    "\27\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\1\5\1\170\13\5\1\171\12\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\12\5\1\172\15\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\5\5\1\173"+
    "\22\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\3\5\1\174\24\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\10\5\1\175\17\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\13\5\1\176\14\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\4\5\1\177"+
    "\23\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\2\5\1\200\25\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\5\5\1\201\22\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\5\5\1\202\22\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\15\5\1\203"+
    "\12\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\4\5\1\204\23\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\24\5\1\205\3\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\14\5\1\206\13\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\1\5\1\207"+
    "\26\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\7\5\1\210\20\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\15\5\1\211\12\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\10\5\1\212\17\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\14\5\1\213"+
    "\13\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\3\5\1\214\24\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\1\215\27\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\14\5\1\216\1\217\12\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\13\5\1\220"+
    "\14\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\1\5\1\221\26\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\15\5\1\222\12\5\2\0\4\5\20\0"+
    "\15\223\1\0\60\223\1\0\5\5\2\0\2\5\6\0"+
    "\3\5\1\224\24\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\15\5\1\225\12\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\13\5\1\226\14\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\4\5\1\227"+
    "\23\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\3\5\1\230\24\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\4\5\1\231\23\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\1\232\27\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\4\5\1\233\23\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\2\5"+
    "\1\234\25\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\22\5\1\235\5\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\12\5\1\236\15\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\4\5\1\237\23\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\4\5"+
    "\1\240\23\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\241\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\2\5\1\242\25\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\6\5\1\243\21\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\12\5"+
    "\1\244\15\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\2\5\1\245\25\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\1\246\27\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\1\247\1\250\26\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\24\5\1\251"+
    "\3\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\5\5\1\252\22\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\2\5\1\253\25\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\15\5\1\254\12\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\10\5\1\255"+
    "\17\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\17\5\1\256\10\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\6\5\1\257\21\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\1\260\27\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\2\5\1\261\25\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\22\5"+
    "\1\262\5\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\263\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\5\5\1\264\12\5\1\265\7\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\10\5"+
    "\1\266\17\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\27\5\1\267\2\0\1\270\1\271\1\272\1\5"+
    "\21\0\5\5\2\0\2\5\6\0\10\5\1\273\17\5"+
    "\2\0\4\5\20\0\14\223\1\274\61\223\1\0\5\5"+
    "\2\0\2\5\6\0\1\5\1\275\26\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\5\5\1\276\22\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\14\5"+
    "\1\277\13\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\3\5\1\300\24\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\30\5\2\0\3\5\1\301\21\0"+
    "\5\5\2\0\2\5\6\0\4\5\1\302\23\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\3\5\1\303"+
    "\24\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\5\5\1\304\22\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\10\5\1\305\17\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\24\5\1\306\3\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\1\5\1\307"+
    "\26\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\1\310\27\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\311\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\15\5\1\312\12\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\1\5\1\313\26\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\24\5"+
    "\1\314\3\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\17\5\1\315\10\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\5\5\1\316\22\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\4\5\1\317\23\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\4\5"+
    "\1\320\23\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\321\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\16\5\1\322\11\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\4\5\1\323\23\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\1\5"+
    "\1\324\26\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\2\5\1\325\25\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\15\5\1\326\12\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\5\5\1\327\22\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\10\5"+
    "\1\330\17\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\331\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\14\5\1\332\13\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\4\5\1\333\23\5"+
    "\2\0\4\5\20\0\14\223\1\334\61\223\1\0\5\5"+
    "\2\0\2\5\6\0\24\5\1\335\3\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\12\5\1\336\15\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\1\5"+
    "\1\337\26\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\3\5\1\340\24\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\5\5\1\341\22\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\6\5\1\342\21\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\1\343"+
    "\27\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\4\5\1\344\23\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\3\5\1\345\24\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\5\5\1\346\22\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\22\5\1\347"+
    "\5\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\2\5\1\350\25\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\2\5\1\351\25\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\7\5\1\352\20\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\1\5\1\353"+
    "\26\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\7\5\1\354\20\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\1\5\1\355\26\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\14\5\1\356\13\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\3\5\1\357"+
    "\24\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\14\5\1\360\13\5\2\0\4\5\20\0\14\223\1\361"+
    "\61\223\1\0\5\5\2\0\2\5\6\0\1\5\1\362"+
    "\26\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\1\363\27\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\12\5\1\364\15\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\12\5\1\365\15\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\5\5\1\366\22\5"+
    "\2\0\4\5\21\0\5\5\2\0\2\5\6\0\23\5"+
    "\1\367\4\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\1\5\1\370\26\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\4\5\1\371\23\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\30\5\1\372\1\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\2\5\1\373"+
    "\25\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\15\5\1\374\12\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\10\5\1\375\17\5\2\0\4\5\34\0"+
    "\1\376\62\0\5\5\2\0\2\5\6\0\15\5\1\377"+
    "\12\5\2\0\4\5\21\0\5\5\2\0\2\5\6\0"+
    "\7\5\1\u0100\20\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\4\5\1\u0101\23\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\4\5\1\u0102\23\5\2\0"+
    "\4\5\71\0\1\u0103\25\0\5\5\2\0\2\5\6\0"+
    "\1\5\1\u0104\26\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\5\5\1\u0105\22\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\4\5\1\u0106\23\5\2\0"+
    "\4\5\34\0\1\72\62\0\5\5\2\0\2\5\6\0"+
    "\5\5\1\u0107\22\5\2\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\1\5\1\u0108\26\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\6\5\1\u0109\21\5\2\0"+
    "\4\5\21\0\5\5\2\0\2\5\6\0\30\5\1\u010a"+
    "\1\0\4\5\21\0\5\5\2\0\2\5\6\0\24\5"+
    "\1\u010b\3\5\2\0\4\5\21\0\5\5\2\0\2\5"+
    "\6\0\2\5\1\u010c\25\5\2\0\4\5\21\0\5\5"+
    "\2\0\2\5\6\0\4\5\1\u010d\23\5\2\0\4\5"+
    "\21\0\5\5\2\0\2\5\6\0\14\5\1\u010e\13\5"+
    "\2\0\4\5\71\0\1\u010f\25\0\5\5\2\0\2\5"+
    "\6\0\30\5\1\u0110\1\0\4\5\21\0\5\5\2\0"+
    "\2\5\6\0\5\5\1\u0111\22\5\2\0\4\5\21\0"+
    "\5\5\2\0\2\5\6\0\3\5\1\u0112\24\5\2\0"+
    "\4\5\71\0\1\u0113\25\0\5\5\2\0\2\5\6\0"+
    "\30\5\1\u0114\1\0\4\5\71\0\1\u0115\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12524];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\10\1\1\11\25\1\2\11\2\1\4\11"+
    "\1\1\11\11\1\0\3\1\2\11\1\1\1\11\2\0"+
    "\1\11\50\1\3\11\1\0\51\1\1\0\50\1\1\0"+
    "\37\1\1\0\35\1\1\0\10\1\1\11\6\1\1\0"+
    "\4\1\1\11\1\0\2\1\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[277];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	private Symbol symbol(int type) {
    	return new Symbol(type, yyline + 1, yycolumn + 1);
    }

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn + 1, value);
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  OcarinaLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 188) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { 	return symbol(EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { /*Return an error message*/
            }
          case 82: break;
          case 2: 
            { return symbol(INTLITERAL, new BigInteger(yytext()));
            }
          case 83: break;
          case 3: 
            { return symbol(IDENTIFIER, yytext());
            }
          case 84: break;
          case 4: 
            { return symbol(MINUS);
            }
          case 85: break;
          case 5: 
            { return symbol(DOT);
            }
          case 86: break;
          case 6: 
            { /*Do nothing*/
            }
          case 87: break;
          case 7: 
            { return symbol(MULT);
            }
          case 88: break;
          case 8: 
            { return symbol(LPAREN);
            }
          case 89: break;
          case 9: 
            { return symbol(RPAREN);
            }
          case 90: break;
          case 10: 
            { return symbol(PLUS);
            }
          case 91: break;
          case 11: 
            { return symbol(GTHAN);
            }
          case 92: break;
          case 12: 
            { return symbol(BANG);
            }
          case 93: break;
          case 13: 
            { return symbol(POWER);
            }
          case 94: break;
          case 14: 
            { return symbol(DIV);
            }
          case 95: break;
          case 15: 
            { return symbol(EQUAL);
            }
          case 96: break;
          case 16: 
            { return symbol(LTHAN);
            }
          case 97: break;
          case 17: 
            { return symbol(LBRACKET);
            }
          case 98: break;
          case 18: 
            { return symbol(RBRACKET);
            }
          case 99: break;
          case 19: 
            { return symbol(LBRACE);
            }
          case 100: break;
          case 20: 
            { return symbol(RBRACE);
            }
          case 101: break;
          case 21: 
            { return symbol(SEMICOLON);
            }
          case 102: break;
          case 22: 
            { return symbol(COLON);
            }
          case 103: break;
          case 23: 
            { return symbol(AT);
            }
          case 104: break;
          case 24: 
            { return symbol(COMMA);
            }
          case 105: break;
          case 25: 
            { return symbol(MOD);
            }
          case 106: break;
          case 26: 
            { return symbol(FLOATLITERAL, new BigDecimal(yytext()));
            }
          case 107: break;
          case 27: 
            { return symbol(DECREMENT);
            }
          case 108: break;
          case 28: 
            { return symbol(POINTER);
            }
          case 109: break;
          case 29: 
            { return symbol(STRINGLITERAL, yytext());
            }
          case 110: break;
          case 30: 
            { return symbol(DO);
            }
          case 111: break;
          case 31: 
            { return symbol(OR);
            }
          case 112: break;
          case 32: 
            { return symbol(IF);
            }
          case 113: break;
          case 33: 
            { return symbol(INCREMENT);
            }
          case 114: break;
          case 34: 
            { return symbol(GTHANE);
            }
          case 115: break;
          case 35: 
            { return symbol(LTHANE);
            }
          case 116: break;
          case 36: 
            { return symbol(AND);
            }
          case 117: break;
          case 37: 
            { return symbol(END);
            }
          case 118: break;
          case 38: 
            { return symbol(NOR);
            }
          case 119: break;
          case 39: 
            { return symbol(NIL);
            }
          case 120: break;
          case 40: 
            { return symbol(INT);
            }
          case 121: break;
          case 41: 
            { return symbol(FOR);
            }
          case 122: break;
          case 42: 
            { return symbol(STUB);
            }
          case 123: break;
          case 43: 
            { return symbol(SAGE);
            }
          case 124: break;
          case 44: 
            { return symbol(TRUE);
            }
          case 125: break;
          case 45: 
            { return symbol(THIS);
            }
          case 126: break;
          case 46: 
            { return symbol(ELSE);
            }
          case 127: break;
          case 47: 
            { return symbol(EXIT);
            }
          case 128: break;
          case 48: 
            { return symbol(NAND);
            }
          case 129: break;
          case 49: 
            { return symbol(MOCK);
            }
          case 130: break;
          case 50: 
            { return symbol(VOID);
            }
          case 131: break;
          case 51: 
            { return symbol(START);
            }
          case 132: break;
          case 52: 
            { return symbol(ARRAY);
            }
          case 133: break;
          case 53: 
            { return symbol(DEBUG);
            }
          case 134: break;
          case 54: 
            { return symbol(CLASS);
            }
          case 135: break;
          case 55: 
            { return symbol(USING);
            }
          case 136: break;
          case 56: 
            { return symbol(BREAK);
            }
          case 137: break;
          case 57: 
            { return symbol(BEGIN);
            }
          case 138: break;
          case 58: 
            { return symbol(FALSE);
            }
          case 139: break;
          case 59: 
            { return symbol(FLOAT);
            }
          case 140: break;
          case 60: 
            { return symbol(PRINT);
            }
          case 141: break;
          case 61: 
            { return symbol(WHILE);
            }
          case 142: break;
          case 62: 
            { return symbol(STRING);
            }
          case 143: break;
          case 63: 
            { return symbol(ASSERT);
            }
          case 144: break;
          case 64: 
            { return symbol(RATHER);
            }
          case 145: break;
          case 65: 
            { return symbol(RETURN);
            }
          case 146: break;
          case 66: 
            { return symbol(EQUALS);
            }
          case 147: break;
          case 67: 
            { return symbol(CREATE);
            }
          case 148: break;
          case 68: 
            { return symbol(LENGTH);
            }
          case 149: break;
          case 69: 
            { return symbol(PUBLIC);
            }
          case 150: break;
          case 70: 
            { return symbol(EXTENDS);
            }
          case 151: break;
          case 71: 
            { return symbol(BOOLEAN);
            }
          case 152: break;
          case 72: 
            { return symbol(HASHMAP);
            }
          case 153: break;
          case 73: 
            { return symbol(PRIVATE);
            }
          case 154: break;
          case 74: 
            { return symbol(CONTINUE);
            }
          case 155: break;
          case 75: 
            { return symbol(GETINT);
            }
          case 156: break;
          case 76: 
            { return symbol(PROTECTED);
            }
          case 157: break;
          case 77: 
            { return symbol(SUBROUTINE);
            }
          case 158: break;
          case 78: 
            { return symbol(GETFLOAT);
            }
          case 159: break;
          case 79: 
            { return symbol(CONSTRUCTOR);
            }
          case 160: break;
          case 80: 
            { return symbol(GETSTRING);
            }
          case 161: break;
          case 81: 
            { return symbol(GETBOOLEAN);
            }
          case 162: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
