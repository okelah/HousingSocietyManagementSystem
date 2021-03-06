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
 * SaveImage.java
 * ---------------
 */
package org.jpedal.examples.viewer.gui.popups;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

import org.jpedal.PdfDecoderInt;
import org.jpedal.utils.Messages;
public class SaveImage extends Save{
	
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	
	private final JToggleButton jToggleButton2 = new JToggleButton();
	private final JToggleButton jToggleButton3 = new JToggleButton();
	
	private final JLabel OutputLabel = new JLabel();
	private final JRadioButton isPNG = new JRadioButton();
	private final JRadioButton isTiff = new JRadioButton();
	private final JRadioButton isJPEG = new JRadioButton();
	
	private final JRadioButton isHires= new JRadioButton();
	private final JRadioButton isNormal= new JRadioButton();
	private final JRadioButton isDownsampled= new JRadioButton();
	
	private final ButtonGroup buttonGroup2= new ButtonGroup();

    public SaveImage( final String root_dir, final int end_page, final int currentPage ) {

        super(root_dir, end_page,currentPage);

        try{
            jbInit();
        }catch( final Exception e ){
            e.printStackTrace();
        }
    }
	
	/**
	 * get root dir
	 */
    public final String getPrefix(){
		String prefix = "png";
		if( isTiff.isSelected() ) {
            prefix = "tif";
        }
		if( isJPEG.isSelected() ) {
            prefix = "jpg";
        }
		return prefix;
	}
	
	/**
	 * get root dir
	 */
    public final int getImageType(){
		int prefix = PdfDecoderInt.CLIPPEDIMAGES;
		
		if( isNormal.isSelected() ) {
            prefix = PdfDecoderInt.RAWIMAGES;
        }
		if( isDownsampled.isSelected() ) {
            prefix = PdfDecoderInt.FINALIMAGES;
        }
		
		return prefix;
	}
	

	private void jbInit() throws Exception{
		
		rootFilesLabel.setBounds( new Rectangle( 13, 12, 400, 26 ) );
		
		rootDir.setBounds( new Rectangle( 23, 39, 232, 23 ) );
		
		changeButton.setBounds( new Rectangle( 272, 39, 101, 23 ) );
		
		startPage.setBounds( new Rectangle( 125, 99, 75, 22 ) );
		
		pageRangeLabel.setBounds( new Rectangle( 13, 70, 400, 26 ) );
		
		startLabel.setBounds( new Rectangle( 23, 100, 100, 22 ) );
		
		endLabel.setBounds( new Rectangle( 220, 99, 75, 22 ) );
		
		endPage.setBounds( new Rectangle( 285, 99, 75, 22 ) );
		
		
		optionsForFilesLabel.setBounds( new Rectangle( 13, 133, 600, 26 ) );
		
		OutputLabel.setText(Messages.getMessage("PdfViewerMessage.OutputType"));
		OutputLabel.setBounds( new Rectangle( 23, 173, 900, 24 ) );
		isTiff.setText( "Tiff" );
		isTiff.setBounds( new Rectangle( 180, 175, 50, 19 ) );
		isJPEG.setBounds( new Rectangle( 290, 174, 67, 19 ) );
		isJPEG.setSelected( true );
		isJPEG.setText( "JPEG" );
		isPNG.setBounds( new Rectangle( 360, 174, 62, 19 ) );
		isPNG.setText( "PNG" );
		
		isHires.setText(Messages.getMessage("PdfViewerOption.Hires"));
		isHires.setBounds( new Rectangle( 180, 200, 112, 19 ) );
		isHires.setSelected( true );
		isNormal.setBounds( new Rectangle( 290, 200, 73, 19 ) );
		isNormal.setText(Messages.getMessage("PdfViewerOption.Normal"));
		isDownsampled.setBounds( new Rectangle( 360, 200, 200, 19 ) );
		isDownsampled.setText(Messages.getMessage("PdfViewerOption.Downsampled"));
		
		//common
		this.add( startPage, null );
		this.add( endPage, null );
		this.add( rootDir, null );
		this.add( scaling, null );
		this.add( scalingLabel, null );
		this.add( rootFilesLabel, null );
		this.add( changeButton, null );
		this.add( endLabel, null );
		this.add( startLabel, null );
		this.add( pageRangeLabel, null );
		
		this.add( optionsForFilesLabel, null );
		this.add( jToggleButton2, null );
		this.add( jToggleButton3, null );
		this.add( OutputLabel, null );
		this.add( isTiff, null );
		this.add( isJPEG, null );
		this.add( isPNG, null );
		buttonGroup1.add( isTiff );
		buttonGroup1.add( isJPEG );
		buttonGroup1.add( isPNG );
		
		this.add( isHires, null );
		this.add( isNormal, null );
		this.add( isDownsampled, null );
		buttonGroup2.add( isHires );
		buttonGroup2.add( isNormal );
		buttonGroup2.add( isDownsampled );
		
	}
	
	@Override
    public final Dimension getPreferredSize(){
		return new Dimension( 500, 250 );
	}
	
}
