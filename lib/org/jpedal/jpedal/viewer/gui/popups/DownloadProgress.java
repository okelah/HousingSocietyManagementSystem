/*
 * ===========================================
 * Java Pdf Extraction Decoding Access Library
 * ===========================================
 *
 * Project Info:  http://www.idrsolutions.com
 * Help section for developers at http://www.idrsolutions.com/support/
 *
 * (C) Copyright 1997-2015 IDRsolutions and Contributors.
 *
 * This file is part of JPedal/JPDF2HTML5
 *
 
 *
 * ---------------
 * DownloadProgress.java
 * ---------------
 */

package org.jpedal.examples.viewer.gui.popups;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.jpedal.utils.LogWriter;
import org.jpedal.io.ObjectStore;

public class DownloadProgress {
	//Load file from URL into file then open file
	File tempURLFile;

	boolean isDownloading=true;

	int progress;

    private final String pdfUrl;

	public DownloadProgress(final String pdfUrl){

		this.pdfUrl = pdfUrl;

	}

    public void startDownload() {
        
        final URL url;
        final InputStream is;

        try {
            final int fileLength;
            int fileLengthPercent = 0;

            progress = 0;

            String str= "file.pdf";
            if(pdfUrl.startsWith("jar:/")) {
                is=this.getClass().getResourceAsStream(pdfUrl.substring(4));
            }else{
                url = new URL(pdfUrl);

                is = url.openStream();

                str=url.getPath().substring(url.getPath().lastIndexOf('/')+1);
                fileLength = url.openConnection().getContentLength();
                fileLengthPercent = fileLength/100;
            }
            final String filename = str;

            tempURLFile=ObjectStore.createTempFile(filename);
            
            
            final FileOutputStream fos = new FileOutputStream(tempURLFile);

            // Download buffer
            final byte[] buffer = new byte[4096];

            // Download the PDF document
            int read;
            int current = 0;

            while ((read = is.read(buffer)) != -1) {
                current += read;
                progress = current/fileLengthPercent;
                fos.write(buffer, 0, read);
            }
            fos.flush();

            // Close streams
            is.close();
            fos.close();
            progress = 100;

        } catch (final Exception e) {
            LogWriter.writeLog("[PDF] Exception " + e + " opening URL "+ pdfUrl);
            e.printStackTrace();
            progress = 100;
        }

        isDownloading=false;

    }
	
	public File getFile(){
		return tempURLFile;
	}

	public boolean isDownloading() {
		return isDownloading; 
	}

	public int getProgress(){
		return progress;
	}
}
