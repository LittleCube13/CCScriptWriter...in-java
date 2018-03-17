import java.io.*;
import java.util.*;
import javax.xml.bind.*;

import JOING.*;

public class CCScriptWriter {

	public static JOING japp = new JOING();
	
	public static void main(String args[]) {
		try {
			if (args.length < 3) {
				System.err.println("~~~~ Error! Not enough arguments specified!");
				System.err.println("~~~~ usage: java CCScriptWriter [rom file] [int pointer] [output file]");
				System.exit(1);
			}
			if (args[0] != null && args.length == 3) {
				if (args[1].indexOf(File.separator) != -1) { System.err.println("~~~~ Error! Please do not place slashes in the filename!"); System.exit(1); }
				System.out.println("~~~~ Reading...");
				File f = new File(args[0]);
				int pointer = 0;
				if (args[1].trim().startsWith("0x")) {
					pointer = Integer.parseInt(args[1].substring(2, args[1].length()), 16);
				} else {
					System.err.println("~~~~ Error! Please place '0x' at the beginning of the pointer!");
					System.exit(1);
				}
				System.out.println(String.format("0x%08X", pointer - 0xBFFE00));
				String ccsfile = readROM(f, pointer);
				FileWriter fw = new FileWriter(args[2]);
				fw.write(ccsfile);
				fw.close();
				System.out.println("~~~~ Done! No errors to report!");
				System.exit(0);
			}
			if (args[0] != null && args.length > 3) {
				System.err.println("~~~~ Error! Too many arguments!");
				System.exit(1);
			}
		} catch (Exception e) { System.err.println("~~~~ Whoops! Error in function main: " + e.toString()); System.exit(1); }
	}
	
	public static String readROM(File f, int pointer) {
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] ROM = new byte[(int) f.length()];
			fis.read(ROM, 0, ROM.length);
			fis.close();
			String ccsfile = "// Outputted by CCScriptWriter.\n\ncommand e(label) { \"{long label}\" }\n\nl_" + String.format("0x%08X", pointer) + ":\n\t\"";
			System.out.println(String.format("0x%08X", ROM.length));
			for (int i = pointer - 0xBFFE00; i < ROM.length; i++) {
				System.out.println(ROM[i]);
				if (ROM[i] == 0x50) {
					ccsfile += " ";
				}
				if (ROM[i] == 0x51) {
					ccsfile += "!";
				}
//				if (ROM[i] == 0x52) {
//					ccsfile += "\"";
//				}
				if (ROM[i] == 0x53) {
					ccsfile += "#";
				}
				if (ROM[i] == 0x54) {
					ccsfile += "$";
				}
				if (ROM[i] == 0x55) {
					ccsfile += "%";
				}
				if (ROM[i] == 0x56) {
					ccsfile += "&";
				}
				if (ROM[i] == 0x57) {
					ccsfile += "\'";
				}
				if (ROM[i] == 0x58) {
					ccsfile += "(";
				}
				if (ROM[i] == 0x59) {
					ccsfile += ")";
				}
				if (ROM[i] == 0x5a) {
					ccsfile += "*";
				}
				if (ROM[i] == 0x5b) {
					ccsfile += "+";
				}
				if (ROM[i] == 0x5c) {
					ccsfile += ",";
				}
				if (ROM[i] == 0x5d) {
					ccsfile += "-";
				}
				if (ROM[i] == 0x5e) {
					ccsfile += ".";
				}
				if (ROM[i] == 0x5f) {
					ccsfile += "/";
				}
				if (ROM[i] == 0x60) {
					ccsfile += "0";
				}
				if (ROM[i] == 0x61) {
					ccsfile += "1";
				}
				if (ROM[i] == 0x62) {
					ccsfile += "2";
				}
				if (ROM[i] == 0x63) {
					ccsfile += "3";
				}
				if (ROM[i] == 0x64) {
					ccsfile += "4";
				}
				if (ROM[i] == 0x65) {
					ccsfile += "5";
				}
				if (ROM[i] == 0x66) {
					ccsfile += "6";
				}
				if (ROM[i] == 0x67) {
					ccsfile += "7";
				}
				if (ROM[i] == 0x68) {
					ccsfile += "8";
				}
				if (ROM[i] == 0x69) {
					ccsfile += "9";
				}
				if (ROM[i] == 0x6a) {
					ccsfile += ":";
				}
				if (ROM[i] == 0x6b) {
					ccsfile += ";";
				}
				if (ROM[i] == 0x6c) {
					ccsfile += "<";
				}
				if (ROM[i] == 0x6d) {
					ccsfile += "=";
				}
				if (ROM[i] == 0x6e) {
					ccsfile += ">";
				}
				if (ROM[i] == 0x6f) {
					ccsfile += "?";
				}
				if (ROM[i] == 0x70) {
					ccsfile += "@";
				}
				if (ROM[i] == 0x71) {
					ccsfile += "A";
				}
				if (ROM[i] == 0x72) {
					ccsfile += "B";
				}
				if (ROM[i] == 0x73) {
					ccsfile += "C";
				}
				if (ROM[i] == 0x74) {
					ccsfile += "D";
				}
				if (ROM[i] == 0x75) {
					ccsfile += "E";
				}
				if (ROM[i] == 0x76) {
					ccsfile += "F";
				}
				if (ROM[i] == 0x77) {
					ccsfile += "G";
				}
				if (ROM[i] == 0x78) {
					ccsfile += "H";
				}
				if (ROM[i] == 0x79) {
					ccsfile += "I";
				}
				if (ROM[i] == 0x7a) {
					ccsfile += "J";
				}
				if (ROM[i] == 0x7b) {
					ccsfile += "K";
				}
				if (ROM[i] == 0x7c) {
					ccsfile += "L";
				}
				if (ROM[i] == 0x7d) {
					ccsfile += "M";
				}
				if (ROM[i] == 0x7e) {
					ccsfile += "N";
				}
				if (ROM[i] == 0x7f) {
					ccsfile += "O";
				}
				if (ROM[i] == 0x80) {
					ccsfile += "P";
				}
				if (ROM[i] == -127) {
					ccsfile += "Q";
				}
				if (ROM[i] == -126) {
					ccsfile += "R";
				}
				if (ROM[i] == -125) {
					ccsfile += "S";
				}
				if (ROM[i] == -124) {
					ccsfile += "T";
				}
				if (ROM[i] == -123) {
					ccsfile += "U";
				}
				if (ROM[i] == -122) {
					ccsfile += "V";
				}
				if (ROM[i] == -121) {
					ccsfile += "W";
				}
				if (ROM[i] == -120) {
					ccsfile += "X";
				}
				if (ROM[i] == -119) {
					ccsfile += "Y";
				}
				if (ROM[i] == -118) {
					ccsfile += "Z";
				}
//				if (ROM[i] == -117) {
//					ccsfile += "[";
//				}
				if (ROM[i] == -116) {
					ccsfile += "\\";
				}
//				if (ROM[i] == -115) {
//					ccsfile += "]";
//				}
				if (ROM[i] == -114) {
					ccsfile += "^";
				}
				if (ROM[i] == -113) {
					ccsfile += "_";
				}
				if (ROM[i] == -112) {
					ccsfile += "`";
				}
				if (ROM[i] == -111) {
					ccsfile += "a";
				}
				if (ROM[i] == -110) {
					ccsfile += "b";
				}
				if (ROM[i] == -109) {
					ccsfile += "c";
				}
				if (ROM[i] == -108) {
					ccsfile += "d";
				}
				if (ROM[i] == -107) {
					ccsfile += "e";
				}
				if (ROM[i] == -106) {
					ccsfile += "f";
				}
				if (ROM[i] == -105) {
					ccsfile += "g";
				}
				if (ROM[i] == -104) {
					ccsfile += "h";
				}
				if (ROM[i] == -103) {
					ccsfile += "i";
				}
				if (ROM[i] == -102) {
					ccsfile += "j";
				}
				if (ROM[i] == -101) {
					ccsfile += "k";
				}
				if (ROM[i] == -100) {
					ccsfile += "l";
				}
				if (ROM[i] == -99) {
					ccsfile += "m";
				}
				if (ROM[i] == -98) {
					ccsfile += "n";
				}
				if (ROM[i] == -97) {
					ccsfile += "o";
				}
				if (ROM[i] == -96) {
					ccsfile += "p";
				}
				if (ROM[i] == -95) {
					ccsfile += "q";
				}
				if (ROM[i] == -94) {
					ccsfile += "r";
				}
				if (ROM[i] == -93) {
					ccsfile += "s";
				}
				if (ROM[i] == -92) {
					ccsfile += "t";
				}
				if (ROM[i] == -91) {
					ccsfile += "u";
				}
				if (ROM[i] == -90) {
					ccsfile += "v";
				}
				if (ROM[i] == -89) {
					ccsfile += "w";
				}
				if (ROM[i] == -88) {
					ccsfile += "x";
				}
				if (ROM[i] == -87) {
					ccsfile += "y";
				}
				if (ROM[i] == -86) {
					ccsfile += "z";
				}
//				if (ROM[i] == -85) {
//					ccsfile += "{";
//				}
				if (ROM[i] == -84) {
					ccsfile += "|";
				}
//				if (ROM[i] == -83) {
//					ccsfile += "}";
//				}
				if (ROM[i] == -82) {
					ccsfile += "~";
				}
				if ((ROM[i] < 0x50 && ROM[i] >= 0) || (ROM[i] > -82 && ROM[i] < 0)) {
					byte[] stupid = Arrays.copyOfRange(ROM, i, i + 1);
					String[] ret = controlCodeMode(ROM, i);
					if (ret[0] != "") {
						ccsfile += ret[0];
						i = Integer.parseInt(ret[1]);
					} else {
						if (ROM[i] == 0x15 || ROM[i] == 0x16 || ROM[i] == 0x17) {
							byte[] stupid2 = Arrays.copyOfRange(ROM, i + 1, i + 2);
							ccsfile += "[" + DatatypeConverter.printHexBinary(stupid) + " " + DatatypeConverter.printHexBinary(stupid2) + "]";
							i += 1;
						} else {
							ccsfile += "[" + DatatypeConverter.printHexBinary(stupid) + "]";
						}
					}
					if (ret[2] == "true") {
						break;
					}
				}
			}
			ccsfile = japp.decompress(ccsfile);
			return ccsfile;
		} catch (Exception e) { System.err.println("~~~~ Whoops! Error in function readROM: " + e.toString()); System.exit(1); }
		return null;
	}
	
	public static String[] controlCodeMode(byte[] ROM, int i) {
		String[] ret = { "", "", "false" };
		
		if (ROM[i] == (byte) 0x00) {
			ret[0] += "{linebreak}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x01) {
			ret[0] += "{newline}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x02) {
			ret[0] += "\" eob";
			ret[1] = Integer.toString(i);
			ret[2] = "true";
			return ret;
		}
		if (ROM[i] == (byte) 0x03) {
			i++;
			if (ROM[i] == (byte) 0x00) {
				ret[0] += "{next}";
				ret[1] = Integer.toString(i);
			}
			return ret;
		}
		if (ROM[i] == (byte) 0x04) {
			i++;
			byte[] stupid = { 0, ROM[i] };
			i++;
			stupid[0] = ROM[i];
			int value = Integer.parseInt(DatatypeConverter.printHexBinary(stupid), 16);
			ret[0] += "{set(" + value + ")}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x05) {
			i++;
			byte[] stupid = { 0, ROM[i] };
			i++;
			stupid[0] = ROM[i];
			int value = Integer.parseInt(DatatypeConverter.printHexBinary(stupid), 16);
			ret[0] = "{unset(" + value + ")}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x06) {
			i++;
			byte[] stupid = { 0, ROM[i] };
			i++;
			stupid[0] = ROM[i];
			i++;
			byte[] stupid2 = { 0, 0, 0, ROM[i] };
			i++;
			stupid2[2] = ROM[i];
			i++;
			stupid2[1] = ROM[i];
			i++;
			stupid2[0] = ROM[i];
			int value = Integer.parseInt(DatatypeConverter.printHexBinary(stupid), 16);
			String value2 = DatatypeConverter.printHexBinary(stupid2);
			ret[0] += "\" if isset("+ value + ") goto(0x" + value2 + ") \"";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x07) {
			i++;
			byte[] stupid = { 0, ROM[i] };
			i++;
			stupid[0] = ROM[i];
			int value = Integer.parseInt(DatatypeConverter.printHexBinary(stupid), 16);
			ret[0] += "{isset("+ value + ")}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x08) {
			i++;
			byte[] stupid = { 0, 0, 0, ROM[i] };
			i++;
			stupid[2] = ROM[i];
			i++;
			stupid[1] = ROM[i];
			i++;
			stupid[0] = ROM[i];
			String value = "0x" + DatatypeConverter.printHexBinary(stupid);
			ret[0] += "{call(" + value + ")}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x09) {
			// TODO menus
			ret[0] = "";
			ret[1] = Integer.toString(i);
			return ret;
		}
		if (ROM[i] == (byte) 0x0A) {
			i++;
			byte[] stupid = { 0, 0, 0, ROM[i] };
			i++;
			stupid[2] = ROM[i];
			i++;
			stupid[1] = ROM[i];
			i++;
			stupid[0] = ROM[i];
			String value = "0x" + DatatypeConverter.printHexBinary(stupid);
			ret[0] += "{goto(" + value + ")}";
			ret[1] = Integer.toString(i);
			return ret;
		}
		return ret;
	}
}
