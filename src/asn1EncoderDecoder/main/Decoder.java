package asn1EncoderDecoder.main;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.encoders.Hex;

public class Decoder {
	private final StringBuffer buff = new StringBuffer();

	protected byte[] decode(byte[] encodedHexInput) {
		byte[] originalBytes = new byte[0];

		try {
			// ASN.1 parse
			ASN1Sequence sequence = ASN1Sequence.getInstance(encodedHexInput);
			ASN1OctetString octetString = ASN1OctetString.getInstance(sequence.getObjectAt(0));

			// get original byte array
			originalBytes = octetString.getOctets();

			// print decoded data at Hex format
			System.out.println(this.buff.append("ASN.1 Decoded Hex: ").append(Hex.toHexString(originalBytes)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.buff.delete(0, buff.length());
		}

		return originalBytes;
	}
}
