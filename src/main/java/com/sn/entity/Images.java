package com.sn.entity;


public class Images  {
	 
	
		private String fuid;
		private java.util.Date modifydate;
		private byte[] content;
		private java.util.Date createdate;
		private String originalName;

		public void setFuid(String value) {
			this.fuid = value;
		}

		public String getFuid() {
			return this.fuid;
		}
		public void setModifydate(java.util.Date value) {
			this.modifydate = value;
		}

		public java.util.Date getModifydate() {
			return this.modifydate;
		}
		public void setContent(byte[] value) {
			this.content = value;
		}

		public byte[] getContent() {
			return this.content;
		}
		public void setCreatedate(java.util.Date value) {
			this.createdate = value;
		}

		public java.util.Date getCreatedate() {
			return this.createdate;
		}
		public void setOriginalName(String value) {
			this.originalName = value;
		}

		public String getOriginalName() {
			return this.originalName;
		}
	

}	 

