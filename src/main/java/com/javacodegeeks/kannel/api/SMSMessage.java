package com.javacodegeeks.kannel.api;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class SMSMessage implements Externalizable {

	private String host;
	private String port;
	private String username;
	private String password;
	private String anumber;
	private List<String> bnumbers;
	private String message;
	private String uhd;
	private String charset;
	private String coding;
	private String validity;
	private String deferred;
	private String dlrmask;
	private String dlrurl;
	private String pid;
	private String mclass;
	private String mwi;

	public SMSMessage() {
	}
	
	public SMSMessage(String host, String port, String username, String password,
			String anumber, List<String> bnumbers, String message,
			String uhd, String charset, String coding, String validity,
			String deferred, String dlrmask, String dlrurl, String pid,
			String mclass, String mwi) {

		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.anumber = anumber;
		this.bnumbers = bnumbers;
		this.message = message;
		this.uhd = uhd;
		this.charset = charset;
		this.coding = coding;
		this.validity = validity;
		this.deferred = deferred;
		this.dlrmask = dlrmask;
		this.dlrurl = dlrurl;
		this.pid = pid;
		this.mclass = mclass;
		this.mwi = mwi;
		
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAnumber() {
		return anumber;
	}

	public List<String> getBnumbers() {
		return bnumbers;
	}

	public String getMessage() {
		return message;
	}

	public String getUhd() {
		return uhd;
	}

	public String getCharset() {
		return charset;
	}

	public String getCoding() {
		return coding;
	}

	public String getValidity() {
		return validity;
	}

	public String getDeferred() {
		return deferred;
	}

	public String getDlrmask() {
		return dlrmask;
	}

	public String getDlrurl() {
		return dlrurl;
	}

	public String getPid() {
		return pid;
	}

	public String getMclass() {
		return mclass;
	}

	public String getMwi() {
		return mwi;
	}

	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput objectInput) throws IOException,
			ClassNotFoundException {
		
		this.host = (String) objectInput.readObject();
		this.port = (String) objectInput.readObject();
		this.username = (String) objectInput.readObject();
		this.password = (String) objectInput.readObject();
		this.anumber = (String) objectInput.readObject();
		this.bnumbers = (List<String>) objectInput.readObject();
		
		int attributeCount = objectInput.read();

		byte[] attributes = new byte[attributeCount];

		objectInput.readFully(attributes);
		
		for (int i = 0; i < attributeCount; i++) {
			byte attribute = attributes[i];

			switch (attribute) {
			case (byte) 0:
				this.uhd = (String) objectInput.readObject();
				break;
			case (byte) 1:
				this.charset = (String) objectInput.readObject();
				break;
			case (byte) 2:
				this.coding = (String) objectInput.readObject();
				break;
			case (byte) 3:
				this.validity = (String) objectInput.readObject();
				break;
			case (byte) 4:
				this.deferred = (String) objectInput.readObject();
				break;
			case (byte) 5:
				this.dlrmask = (String) objectInput.readObject();
				break;
			case (byte) 6:
				this.dlrurl = (String) objectInput.readObject();
				break;
			case (byte) 7:
				this.pid = (String) objectInput.readObject();
				break;
			case (byte) 8:
				this.mclass = (String) objectInput.readObject();
				break;
			case (byte) 9:
				this.mwi = (String) objectInput.readObject();
				break;
			case (byte) 10:
				this.message = (String) objectInput.readObject();
				break;
			}
		}
		
	}

	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		
		objectOutput.writeObject(host);
		objectOutput.writeObject(port);
		objectOutput.writeObject(username);
		objectOutput.writeObject(password);
		objectOutput.writeObject(anumber);
		objectOutput.writeObject(bnumbers);
		
		byte[] attributeFlags = new byte[11];
		
		int attributeCount = 0;
		
		if (uhd != null) {
			attributeFlags[0] = (byte) 1;
			attributeCount++;
		}
		if (charset != null) {
			attributeFlags[1] = (byte) 1;
			attributeCount++;
		}
		if (coding != null) {
			attributeFlags[2] = (byte) 1;
			attributeCount++;
		}
		if (validity != null) {
			attributeFlags[3] = (byte) 1;
			attributeCount++;
		}
		if (deferred != null) {
			attributeFlags[4] = (byte) 1;
			attributeCount++;
		}
		if (dlrmask != null) {
			attributeFlags[5] = (byte) 1;
			attributeCount++;
		}
		if (dlrurl != null) {
			attributeFlags[6] = (byte) 1;
			attributeCount++;
		}
		if (pid != null) {
			attributeFlags[7] = (byte) 1;
			attributeCount++;
		}
		if (mclass != null) {
			attributeFlags[8] = (byte) 1;
			attributeCount++;
		}
		if (mwi != null) {
			attributeFlags[9] = (byte) 1;
			attributeCount++;
		}
		if (message != null) {
			attributeFlags[10] = (byte) 1;
			attributeCount++;
		}
		
		objectOutput.write(attributeCount);
		
		byte[] attributes = new byte[attributeCount];

		int j = attributeCount;

		for (int i = 0; i < 11; i++)
			if (attributeFlags[i] == (byte) 1) {
				j--;
				attributes[j] = (byte) i;
			}

		objectOutput.write(attributes);
		
		for (int i = 0; i < attributeCount; i++) {
			byte attribute = attributes[i];

			switch (attribute) {
			case (byte) 0:
				objectOutput.writeObject(uhd);
				break;
			case (byte) 1:
				objectOutput.writeObject(charset);
				break;
			case (byte) 2:
				objectOutput.writeObject(coding);
				break;
			case (byte) 3:
				objectOutput.writeObject(validity);
				break;
			case (byte) 4:
				objectOutput.writeObject(deferred);
				break;
			case (byte) 5:
				objectOutput.writeObject(dlrmask);
				break;
			case (byte) 6:
				objectOutput.writeObject(dlrurl);
				break;
			case (byte) 7:
				objectOutput.writeObject(pid);
				break;
			case (byte) 8:
				objectOutput.writeObject(mclass);
				break;
			case (byte) 9:
				objectOutput.writeObject(mwi);
				break;
			case (byte) 10:
				objectOutput.writeObject(message);
				break;
			}
		}
		
	}
}
