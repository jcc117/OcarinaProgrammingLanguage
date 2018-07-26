/* The following code was generated by JFlex 1.6.1 */

import java_cup.runtime.*;
import java.math.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>./OcarinaLexer.flex</tt>
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
    "\11\0\1\17\1\14\2\0\1\17\23\0\1\56\1\20\1\13\1\0"+
    "\1\74\1\0\1\15\1\47\1\50\1\16\1\55\1\73\1\1\1\10"+
    "\1\60\1\3\7\7\2\2\1\71\1\70\1\63\1\62\1\61\1\12"+
    "\1\72\1\6\1\53\3\6\1\51\2\11\1\46\11\11\1\52\4\11"+
    "\1\5\2\11\1\64\1\0\1\65\1\57\1\11\1\0\1\23\1\33"+
    "\1\30\1\27\1\25\1\37\1\43\1\40\1\35\1\11\1\54\1\31"+
    "\1\41\1\26\1\34\1\42\1\45\1\24\1\21\1\22\1\32\1\36"+
    "\1\44\1\4\2\11\1\66\1\0\1\67\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\7"+
    "\1\1\1\10\1\1\23\5\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\4"+
    "\1\0\1\34\1\0\1\4\1\7\2\0\1\35\21\5"+
    "\1\36\10\5\1\37\1\5\1\40\12\5\1\41\1\42"+
    "\1\43\1\44\1\0\7\5\1\45\5\5\1\46\3\5"+
    "\1\47\1\50\11\5\1\51\3\5\1\52\7\5\1\0"+
    "\2\5\1\53\1\5\1\54\1\55\4\5\1\56\1\57"+
    "\1\60\1\5\1\61\12\5\1\62\13\5\1\63\1\5"+
    "\1\0\1\64\7\5\1\65\1\5\1\66\3\5\1\67"+
    "\1\70\1\71\1\5\1\72\1\73\2\5\1\74\6\5"+
    "\1\75\1\0\1\76\1\5\1\77\1\100\1\101\1\5"+
    "\1\102\1\103\2\5\1\104\4\5\1\105\4\5\1\7"+
    "\1\5\1\106\2\5\1\107\1\110\1\5\1\111\1\0"+
    "\3\5\1\7\2\5\1\112\1\5\1\113\5\5\1\114"+
    "\1\0\2\5\1\115\1\5\1\116\1\0\1\5\1\117"+
    "\1\120\1\0\1\121";

  private static int [] zzUnpackAction() {
    int [] result = new int[272];
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
    "\0\0\0\75\0\172\0\267\0\364\0\u0131\0\u016e\0\u01ab"+
    "\0\u01e8\0\u0225\0\75\0\u0262\0\u029f\0\u02dc\0\u0319\0\u0356"+
    "\0\u0393\0\u03d0\0\u040d\0\u044a\0\u0487\0\u04c4\0\u0501\0\u053e"+
    "\0\u057b\0\u05b8\0\u05f5\0\u0632\0\u066f\0\u06ac\0\u06e9\0\75"+
    "\0\75\0\u0726\0\75\0\75\0\75\0\u0763\0\75\0\u07a0"+
    "\0\75\0\75\0\75\0\75\0\75\0\75\0\75\0\75"+
    "\0\75\0\75\0\u07dd\0\u016e\0\u081a\0\u0857\0\u016e\0\75"+
    "\0\u0894\0\u0262\0\75\0\u08d1\0\u090e\0\u094b\0\u0988\0\u09c5"+
    "\0\u0a02\0\u0a3f\0\u0a7c\0\u0ab9\0\u0af6\0\u0b33\0\u0b70\0\u0bad"+
    "\0\u0bea\0\u0c27\0\u0c64\0\u0ca1\0\u0131\0\u0cde\0\u0d1b\0\u0d58"+
    "\0\u0d95\0\u0dd2\0\u0e0f\0\u0e4c\0\u0e89\0\u0131\0\u0ec6\0\u0131"+
    "\0\u0f03\0\u0f40\0\u0f7d\0\u0fba\0\u0ff7\0\u1034\0\u1071\0\u10ae"+
    "\0\u10eb\0\u1128\0\75\0\75\0\75\0\u0857\0\u1165\0\u11a2"+
    "\0\u11df\0\u121c\0\u1259\0\u1296\0\u12d3\0\u1310\0\u0131\0\u134d"+
    "\0\u138a\0\u13c7\0\u1404\0\u1441\0\u0131\0\u147e\0\u14bb\0\u14f8"+
    "\0\u0131\0\u0131\0\u1535\0\u1572\0\u15af\0\u15ec\0\u1629\0\u1666"+
    "\0\u16a3\0\u16e0\0\u171d\0\u0131\0\u175a\0\u1797\0\u17d4\0\u0131"+
    "\0\u1811\0\u184e\0\u188b\0\u18c8\0\u1905\0\u1942\0\u197f\0\u19bc"+
    "\0\u19f9\0\u1a36\0\u0131\0\u1a73\0\u0131\0\u0131\0\u1ab0\0\u1aed"+
    "\0\u1b2a\0\u1b67\0\u0131\0\u0131\0\u0131\0\u1ba4\0\u0131\0\u1be1"+
    "\0\u1c1e\0\u1c5b\0\u1c98\0\u1cd5\0\u1d12\0\u1d4f\0\u1d8c\0\u1dc9"+
    "\0\u1e06\0\u0131\0\u1e43\0\u1e80\0\u1ebd\0\u1efa\0\u1f37\0\u1f74"+
    "\0\u1fb1\0\u1fee\0\u202b\0\u2068\0\u20a5\0\u0131\0\u20e2\0\u211f"+
    "\0\u0131\0\u215c\0\u2199\0\u21d6\0\u2213\0\u2250\0\u228d\0\u22ca"+
    "\0\u0131\0\u2307\0\u0131\0\u2344\0\u2381\0\u23be\0\u0131\0\u0131"+
    "\0\u0131\0\u23fb\0\u0131\0\u0131\0\u2438\0\u2475\0\u0131\0\u24b2"+
    "\0\u24ef\0\u252c\0\u2569\0\u25a6\0\u25e3\0\u0131\0\u2620\0\u0131"+
    "\0\u265d\0\u0131\0\u0131\0\u0131\0\u269a\0\u0131\0\u0131\0\u26d7"+
    "\0\u2714\0\u0131\0\u2751\0\u278e\0\u27cb\0\u2808\0\u0131\0\u2845"+
    "\0\u2882\0\u28bf\0\u28fc\0\u2939\0\u2976\0\u0131\0\u29b3\0\u29f0"+
    "\0\u0131\0\u0131\0\u2a2d\0\u0131\0\u2a6a\0\u2aa7\0\u2ae4\0\u2b21"+
    "\0\u2b5e\0\u2b9b\0\u2bd8\0\u0131\0\u2c15\0\75\0\u2c52\0\u2c8f"+
    "\0\u2ccc\0\u2d09\0\u2d46\0\u0131\0\u2d83\0\u2dc0\0\u2dfd\0\u0131"+
    "\0\u2e3a\0\75\0\u2e77\0\u2eb4\0\u0131\0\75\0\u2ef1\0\75";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[272];
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
    "\1\2\1\3\1\4\1\5\3\6\1\4\1\7\1\6"+
    "\1\2\1\10\1\11\1\12\1\13\1\11\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\6"+
    "\1\35\1\36\1\37\2\6\1\40\1\41\4\6\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\1\57\1\60\1\61\76\0"+
    "\1\62\1\4\1\63\3\0\1\4\1\64\66\0\2\4"+
    "\3\0\1\4\1\64\66\0\1\63\1\65\2\66\1\0"+
    "\1\65\1\64\66\0\6\6\1\0\2\6\6\0\26\6"+
    "\2\0\4\6\22\0\2\67\3\0\1\67\65\0\14\10"+
    "\1\70\60\10\14\0\1\11\2\0\1\11\72\0\1\71"+
    "\57\0\20\72\1\73\54\72\2\0\6\6\1\0\2\6"+
    "\6\0\1\6\1\74\1\75\6\6\1\76\14\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\3\6\1\77"+
    "\13\6\1\100\6\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\101\4\6\1\102\20\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\2\6\1\103\1\6"+
    "\1\104\21\6\2\0\4\6\22\0\2\6\1\105\3\6"+
    "\1\0\2\6\6\0\5\6\1\106\2\6\1\107\13\6"+
    "\1\110\1\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\2\6\1\111\10\6\1\112\1\113\11\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\4\6\1\114"+
    "\6\6\1\115\12\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\3\6\1\116\4\6\1\117\2\6\1\120"+
    "\12\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\4\6\1\121\21\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\122\25\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\3\6\1\123\1\124\6\6\1\125"+
    "\12\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\3\6\1\126\22\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\5\6\1\127\10\6\1\130\7\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\13\6\1\131"+
    "\12\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\2\6\1\132\5\6\1\133\2\6\1\134\12\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\2\6\1\135"+
    "\23\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\3\6\1\136\5\6\1\137\14\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\4\6\1\140\21\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\14\6\1\141"+
    "\2\6\1\142\6\6\2\0\4\6\22\0\1\4\1\63"+
    "\3\0\1\4\1\64\44\0\1\143\101\0\1\144\74\0"+
    "\1\145\14\0\2\63\3\0\1\63\1\64\66\0\1\63"+
    "\1\65\3\0\1\65\1\64\66\0\2\146\2\0\2\146"+
    "\13\0\1\146\1\0\1\146\1\0\2\146\2\0\1\146"+
    "\3\0\1\146\11\0\1\146\1\0\1\146\36\0\1\147"+
    "\61\0\6\6\1\0\2\6\6\0\2\6\1\150\1\151"+
    "\22\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\22\6\1\152\3\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\12\6\1\153\13\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\11\6\1\154\14\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\14\6\1\155"+
    "\11\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\1\156\25\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\6\6\1\157\17\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\1\6\1\160\24\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\1\6\1\161\24\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\1\6"+
    "\1\162\2\6\1\163\7\6\1\164\11\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\6\6\1\165\17\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\1\166"+
    "\25\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\11\6\1\167\14\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\5\6\1\170\20\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\3\6\1\171\22\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\10\6\1\172"+
    "\15\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\12\6\1\173\13\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\4\6\1\174\21\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\2\6\1\175\23\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\5\6\1\176"+
    "\20\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\5\6\1\177\20\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\14\6\1\200\11\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\4\6\1\201\21\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\22\6\1\202"+
    "\3\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\13\6\1\203\12\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\6\1\204\24\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\14\6\1\205\11\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\10\6\1\206"+
    "\15\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\13\6\1\207\12\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\3\6\1\210\22\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\1\211\25\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\13\6\1\212\1\213"+
    "\11\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\12\6\1\214\13\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\6\1\215\24\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\1\6\1\216\24\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\14\6\1\217"+
    "\11\6\2\0\4\6\20\0\16\220\1\0\56\220\2\0"+
    "\6\6\1\0\2\6\6\0\3\6\1\221\22\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\14\6\1\222"+
    "\11\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\4\6\1\223\21\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\3\6\1\224\22\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\4\6\1\225\21\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\1\226\25\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\4\6"+
    "\1\227\21\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\17\6\1\230\6\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\11\6\1\231\14\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\4\6\1\232\21\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\7\6"+
    "\1\233\16\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\1\6\1\234\24\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\4\6\1\235\21\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\2\6\1\236\23\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\6\6"+
    "\1\237\17\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\11\6\1\240\14\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\2\6\1\241\23\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\1\242\25\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\1\243\1\244"+
    "\24\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\22\6\1\245\3\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\5\6\1\246\20\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\2\6\1\247\23\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\14\6\1\250"+
    "\11\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\10\6\1\251\15\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\6\6\1\252\17\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\1\253\25\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\2\6\1\254\23\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\17\6"+
    "\1\255\6\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\1\6\1\256\24\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\5\6\1\257\7\6\1\260\10\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\10\6"+
    "\1\261\15\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\25\6\1\262\2\0\1\263\1\264\1\265\1\6"+
    "\22\0\6\6\1\0\2\6\6\0\17\6\1\266\6\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\10\6"+
    "\1\267\15\6\2\0\4\6\20\0\15\220\1\270\57\220"+
    "\2\0\6\6\1\0\2\6\6\0\1\6\1\271\24\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\5\6"+
    "\1\272\20\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\13\6\1\273\12\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\3\6\1\274\22\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\4\6\1\275\21\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\3\6"+
    "\1\276\22\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\5\6\1\277\20\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\10\6\1\300\15\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\22\6\1\301\3\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\1\6"+
    "\1\302\24\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\1\303\25\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\6\1\304\24\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\14\6\1\305\11\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\1\6\1\306"+
    "\24\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\22\6\1\307\3\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\26\6\2\0\3\6\1\310\22\0\6\6"+
    "\1\0\2\6\6\0\5\6\1\311\20\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\4\6\1\312\21\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\4\6"+
    "\1\313\21\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\1\6\1\314\24\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\20\6\1\315\5\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\4\6\1\316\21\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\1\6"+
    "\1\317\24\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\2\6\1\320\23\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\14\6\1\321\11\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\5\6\1\322\20\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\10\6"+
    "\1\323\15\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\1\6\1\324\24\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\13\6\1\325\12\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\4\6\1\326\21\6"+
    "\2\0\4\6\20\0\15\220\1\327\57\220\2\0\6\6"+
    "\1\0\2\6\6\0\22\6\1\330\3\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\11\6\1\331\14\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\1\6"+
    "\1\332\24\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\3\6\1\333\22\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\5\6\1\334\20\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\6\6\1\335\17\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\1\336"+
    "\25\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\4\6\1\337\21\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\3\6\1\340\22\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\5\6\1\341\20\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\17\6\1\342"+
    "\6\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\2\6\1\343\23\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\2\6\1\344\23\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\7\6\1\345\16\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\1\6\1\346"+
    "\24\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\7\6\1\347\16\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\6\1\350\24\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\13\6\1\351\12\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\3\6\1\352"+
    "\22\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\13\6\1\353\12\6\2\0\4\6\20\0\15\220\1\354"+
    "\57\220\2\0\6\6\1\0\2\6\6\0\1\6\1\355"+
    "\24\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\1\356\25\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\11\6\1\357\14\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\11\6\1\360\14\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\5\6\1\361\20\6"+
    "\2\0\4\6\22\0\6\6\1\0\2\6\6\0\21\6"+
    "\1\362\4\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\1\6\1\363\24\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\4\6\1\364\21\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\26\6\1\365\1\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\2\6\1\366"+
    "\23\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\14\6\1\367\11\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\10\6\1\370\15\6\2\0\4\6\35\0"+
    "\1\371\61\0\6\6\1\0\2\6\6\0\14\6\1\372"+
    "\11\6\2\0\4\6\22\0\6\6\1\0\2\6\6\0"+
    "\7\6\1\373\16\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\4\6\1\374\21\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\4\6\1\375\21\6\2\0"+
    "\4\6\70\0\1\376\26\0\6\6\1\0\2\6\6\0"+
    "\1\6\1\377\24\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\5\6\1\u0100\20\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\4\6\1\u0101\21\6\2\0"+
    "\4\6\35\0\1\70\61\0\6\6\1\0\2\6\6\0"+
    "\5\6\1\u0102\20\6\2\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\1\6\1\u0103\24\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\6\6\1\u0104\17\6\2\0"+
    "\4\6\22\0\6\6\1\0\2\6\6\0\26\6\1\u0105"+
    "\1\0\4\6\22\0\6\6\1\0\2\6\6\0\22\6"+
    "\1\u0106\3\6\2\0\4\6\22\0\6\6\1\0\2\6"+
    "\6\0\2\6\1\u0107\23\6\2\0\4\6\22\0\6\6"+
    "\1\0\2\6\6\0\4\6\1\u0108\21\6\2\0\4\6"+
    "\22\0\6\6\1\0\2\6\6\0\13\6\1\u0109\12\6"+
    "\2\0\4\6\70\0\1\u010a\26\0\6\6\1\0\2\6"+
    "\6\0\26\6\1\u010b\1\0\4\6\22\0\6\6\1\0"+
    "\2\6\6\0\5\6\1\u010c\20\6\2\0\4\6\22\0"+
    "\6\6\1\0\2\6\6\0\3\6\1\u010d\22\6\2\0"+
    "\4\6\70\0\1\u010e\26\0\6\6\1\0\2\6\6\0"+
    "\26\6\1\u010f\1\0\4\6\70\0\1\u0110\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12078];
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
    "\1\0\1\11\10\1\1\11\24\1\2\11\1\1\3\11"+
    "\1\1\1\11\1\1\12\11\1\1\1\0\1\1\1\0"+
    "\1\1\1\11\2\0\1\11\47\1\3\11\1\1\1\0"+
    "\50\1\1\0\47\1\1\0\36\1\1\0\35\1\1\0"+
    "\10\1\1\11\6\1\1\0\4\1\1\11\1\0\2\1"+
    "\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[272];
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
    	return new Symbol(type, yyline, yycolumn);
    }

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
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
    while (i < 186) {
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
            { return symbol(MINUS);
            }
          case 83: break;
          case 3: 
            { return symbol(INTLITERAL, new BigInteger(yytext()));
            }
          case 84: break;
          case 4: 
            { return symbol(FLOATLITERAL, new BigDecimal(yytext()));
            }
          case 85: break;
          case 5: 
            { return symbol(IDENTIFIER, yytext());
            }
          case 86: break;
          case 6: 
            { return symbol(DOT);
            }
          case 87: break;
          case 7: 
            { /*Do nothing*/
            }
          case 88: break;
          case 8: 
            { return symbol(MULT);
            }
          case 89: break;
          case 9: 
            { return symbol(LPAREN);
            }
          case 90: break;
          case 10: 
            { return symbol(RPAREN);
            }
          case 91: break;
          case 11: 
            { return symbol(PLUS);
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
            { return symbol(GTHAN);
            }
          case 96: break;
          case 16: 
            { return symbol(EQUAL);
            }
          case 97: break;
          case 17: 
            { return symbol(LTHAN);
            }
          case 98: break;
          case 18: 
            { return symbol(LBRACKET);
            }
          case 99: break;
          case 19: 
            { return symbol(RBRACKET);
            }
          case 100: break;
          case 20: 
            { return symbol(LBRACE);
            }
          case 101: break;
          case 21: 
            { return symbol(RBRACE);
            }
          case 102: break;
          case 22: 
            { return symbol(SEMICOLON);
            }
          case 103: break;
          case 23: 
            { return symbol(COLON);
            }
          case 104: break;
          case 24: 
            { return symbol(AT);
            }
          case 105: break;
          case 25: 
            { return symbol(COMMA);
            }
          case 106: break;
          case 26: 
            { return symbol(MOD);
            }
          case 107: break;
          case 27: 
            { return symbol(DECREMENT);
            }
          case 108: break;
          case 28: 
            { return symbol(INTLITERAL, new BigInteger(yytext(), 8));
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
            { return symbol(INTLITERAL, new BigInteger(yytext().substring(2), 16));
            }
          case 117: break;
          case 37: 
            { return symbol(AND);
            }
          case 118: break;
          case 38: 
            { return symbol(END);
            }
          case 119: break;
          case 39: 
            { return symbol(NOR);
            }
          case 120: break;
          case 40: 
            { return symbol(NIL);
            }
          case 121: break;
          case 41: 
            { return symbol(INT);
            }
          case 122: break;
          case 42: 
            { return symbol(FOR);
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
            { return symbol(EXEC);
            }
          case 127: break;
          case 47: 
            { return symbol(EXIT);
            }
          case 128: break;
          case 48: 
            { return symbol(ELSE);
            }
          case 129: break;
          case 49: 
            { return symbol(NAND);
            }
          case 130: break;
          case 50: 
            { return symbol(VOID);
            }
          case 131: break;
          case 51: 
            { return symbol(WITH);
            }
          case 132: break;
          case 52: 
            { return symbol(START);
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
