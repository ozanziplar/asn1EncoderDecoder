package asn1EncoderDecoder.main;

import java.util.Arrays;

public class App {
	private static final StringBuffer buff = new StringBuffer();

	public static void main(String[] args) {
		Encoder encoder = new Encoder();
		Decoder decoder = new Decoder();

		String hexData = "050111";
		byte[] rawArr = Converter.stringToHexArr(hexData);
		
		System.out.println(buff.append("Original Data: ").append(Arrays.toString(rawArr)).append(" in Decimal\n"));
		buff.delete(0, buff.length());
		
		byte[] encodedArr = encoder.encode(rawArr);
		
		System.out.println(buff.append("Encoded Data: ").append(Arrays.toString(encodedArr)).append(" in Decimal\n"));
		buff.delete(0, buff.length());
		
		byte[] decodedArr = decoder.decode(encodedArr);
		
		System.out.println(buff.append("Decoded Data: ").append(Arrays.toString(decodedArr)).append(" in Decimal"));
		buff.delete(0, buff.length());
	}

}
