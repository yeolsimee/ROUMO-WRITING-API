package com.yeolsimee.writing.infra;

import lombok.Data;

@Data
public class UploadFile {
	private String originalFileName;
	private String uploadFileName;
	private String uploadFilePath;
	private String uploadFileUrl;

	public UploadFile(String originalFileName, String uploadFileName, String uploadFilePath, String uploadFileUrl) {
		this.originalFileName = originalFileName;
		this.uploadFileName = uploadFileName;
		this.uploadFilePath = uploadFilePath;
		this.uploadFileUrl = uploadFileUrl;
	}
}
