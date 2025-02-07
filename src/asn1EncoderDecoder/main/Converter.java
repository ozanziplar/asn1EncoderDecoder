package asn1EncoderDecoder.main;

import org.bouncycastle.util.encoders.Hex;

public class Converter {
	private final static StringBuffer buff = new StringBuffer();

	public static byte[] stringToHexArr(String inputStr) {
		buff.append(inputStr);
		byte[] rawBytes = Hex.decode(buff.toString());
		System.out.println(buff.append(" String converted to [").append(rawBytes).append(" - ").append(Hex.toHexString(rawBytes)).append("] HEX!"));
		buff.delete(0, buff.length());
		return rawBytes;
	}
}
