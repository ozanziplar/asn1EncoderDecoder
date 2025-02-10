package asn1EncoderDecoder.main;

import java.io.IOException;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.encoders.Hex;

public class Encoder {
	private final StringBuffer buff = new StringBuffer();

	protected byte[] encode(byte[] hexInput) {
		ASN1Sequence seq = new DERSequence(new ASN1Encodable[] {
					new DERSequence(
							new ASN1Encodable[] { new ASN1Integer(5), new ASN1Enumerated(1), new ASN1Enumerated(17) }),
					new DERSequence(new ASN1Encodable[] {}) });
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// PER unaligned kodlama
		PerEncoding perEncoding = new PerEncoding();
		baos.write(perEncoding.encode(seq, true).getBytes());

		return baos.toByteArray();
		
		byte[] encodedBytes = new byte[0];
		
		try {
			// ASN.1 structure
			ASN1EncodableVector vector = new ASN1EncodableVector();
			vector.add(new DEROctetString(hexInput)); // Convert Byte array to ASN.1 Octet String

			// ASN.1 encoding process
			encodedBytes = new DERSequence(vector).getEncoded();

			// print Encoded data at Hex format
			System.out.println(this.buff.append("ASN.1 Encoded Hex: ").append(Hex.toHexString(encodedBytes)));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.buff.delete(0, buff.length());
		}

		return encodedBytes;
	}
}
