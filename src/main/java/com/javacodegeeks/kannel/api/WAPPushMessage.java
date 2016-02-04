package com.javacodegeeks.kannel.api;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class WAPPushMessage implements Externalizable {

	private String host;
	private String port;
	private List<String> bnumbers;
	private String type;
	private String message;
	private String contenturl;
	private int expirationDays;
	private String dlrmask;
	private String dlrurl;

	public WAPPushMessage() {
	}
	
	public WAPPushMessage(String host, String port,
			List<String> bnumbers, String type, String message,
			String contenturl, int expirationDays, String dlrmask,
			String dlrurl) {

		this.host = host;
		this.port = port;
		this.bnumbers = bnumbers;
		this.type = type;
		this.message = message;
		this.contenturl = contenturl;
		this.expirationDays = expirationDays;
		this.dlrmask = dlrmask;
		this.dlrurl = dlrurl;
		
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public List<String> getBnumbers() {
		return bnumbers;
	}

	public void setBnumbers(List<String> bnumbers) {
		this.bnumbers = bnumbers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContenturl() {
		return contenturl;
	}

	public void setContenturl(String contenturl) {
		this.contenturl = contenturl;
	}

	public int getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(int expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getDlrmask() {
		return dlrmask;
	}

	public void setDlrmask(String dlrmask) {
		this.dlrmask = dlrmask;
	}

	public String getDlrurl() {
		return dlrurl;
	}

	public void setDlrurl(String dlrurl) {
		this.dlrurl = dlrurl;
	}

	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput objectInput) throws IOException,
			ClassNotFoundException {
		
		this.host = (String) objectInput.readObject();
		this.port = (String) objectInput.readObject();
		this.bnumbers = (List<String>) objectInput.readObject();
		this.type = (String) objectInput.readObject();
		this.message = (String) objectInput.readObject();
		this.contenturl = (String) objectInput.readObject();
		this.expirationDays = objectInput.readInt();
		
		int attributeCount = objectInput.read();

		byte[] attributes = new byte[attributeCount];

		objectInput.readFully(attributes);
		
		for (int i = 0; i < attributeCount; i++) {
			byte attribute = attributes[i];

			switch (attribute) {
			case (byte) 0:
				this.dlrmask = (String) objectInput.readObject();
				break;
			case (byte) 1:
				this.dlrurl = (String) objectInput.readObject();
				break;
			}
			
		}
		
	}

	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		
		objectOutput.writeObject(host);
		objectOutput.writeObject(port);
		objectOutput.writeObject(bnumbers);
		objectOutput.writeObject(type);
		objectOutput.writeObject(message);
		objectOutput.writeObject(contenturl);
		objectOutput.writeInt(expirationDays);
		
		byte[] attributeFlags = new byte[2];
		
		int attributeCount = 0;
		
		if (dlrmask != null) {
			attributeFlags[0] = (byte) 1;
			attributeCount++;
		}
		if (dlrurl != null) {
			attributeFlags[1] = (byte) 1;
			attributeCount++;
		}
		
		objectOutput.write(attributeCount);
		
		byte[] attributes = new byte[attributeCount];

		int j = attributeCount;

		for (int i = 0; i < 2; i++)
			if (attributeFlags[i] == (byte) 1) {
				j--;
				attributes[j] = (byte) i;
			}

		objectOutput.write(attributes);
		
		for (int i = 0; i < attributeCount; i++) {
			byte attribute = attributes[i];

			switch (attribute) {
			case (byte) 0:
				objectOutput.writeObject(dlrmask);
				break;
			case (byte) 1:
				objectOutput.writeObject(dlrurl);
				break;
			}
			
		}
		
	}
	
}
