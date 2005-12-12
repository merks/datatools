/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqleditor.internal.sql;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * 
 * This class represents a completion proposal generated by content assist
 * processor. The completion proposal contains information used to present the
 * proposed completion to the user, to insert the completion should the user
 * select it, and to present context information for the chosen completion once
 * it has been inserted.
 * 
 * @author Hetty Dougherty
 *  
 */
public class SQLCompletionProposal implements ICompletionProposal, ICompletionProposalExtension {

    private String fDisplayString;
    private String fReplacementString;
    private int fReplacementOffset;
    private int fDocumentOffset = -1;
    private int fReplacementLength;
    private int fCursorPosition;
    private Image fImage;
    private IContextInformation fContextInformation;
    private int fContextInformationPosition;
    private char[] fTriggerCharacters;
    private String fAdditionalProposalInfo;

    /**
     * Creates a new completion proposal. All fields are initialized based on
     * the provided information.
     * 
     * @param additionalInfo additional information about the completion proposal
     * @param replacementString the actual string to be inserted into the document
     * @param replacementOffset offset of the text to be replaced
     * @param documentOffset offset of the document
     * @param replacementLength length of the text to be replaced
     * @param image the image to display for this proposal
     * @param displayString the string to be displayed for the proposal If set
     *            to <code>null</code>, the replacement string will be taken
     *            as display string.
     */
    public SQLCompletionProposal( String additionalInfo, String replacementString, int replacementOffset,
            int documentOffset, int replacementLength, Image image, String displayString,
            IContextInformation contextInformation ) {

        fReplacementString = replacementString;
        fReplacementOffset = replacementOffset;
        fDocumentOffset = documentOffset;
        fReplacementLength = replacementLength;
        fImage = image;
        fDisplayString = displayString != null ? displayString : replacementString;

        fCursorPosition = replacementString.length();

        fContextInformation = contextInformation;

        fTriggerCharacters = null;
        fAdditionalProposalInfo = additionalInfo;
    }

    /**
     * Creates a new completion proposal. All fields are initialized based on
     * the provided information.
     * 
     * @param replacementString the actual string to be inserted into the document
     * @param replacementOffset the offset of the text to be replaced
     * @param replacementLength the length of the text to be replaced
     * @param cursorPosition the position of the cursor following the insert
     *            relative to replacementOffset
     * @param image the image to display for this proposal
     * @param displayString the string to be displayed for the proposal
     * @param contentInformation the context information associated with this proposal
     * @param additionalProposalInfo the additional information associated with
     *            this proposal
     */
    public SQLCompletionProposal( String replacementString, int replacementOffset, int replacementLength,
            int cursorPosition, Image image, String displayString, IContextInformation contextInformation,
            String additionalProposalInfo ) {

        fReplacementString = replacementString;
        fReplacementOffset = replacementOffset;
        fDocumentOffset = fReplacementOffset;
        fReplacementLength = replacementLength;
        fCursorPosition = cursorPosition;
        fImage = image;
        fDisplayString = displayString;
        fContextInformation = contextInformation;
        fAdditionalProposalInfo = additionalProposalInfo;

    }

    /**
     * Sets the context information.
     * 
     * @param contentInformation The context information associated with this
     *            proposal
     */
    public void setContextInformation( IContextInformation contextInformation ) {
        fContextInformation = contextInformation;
        fContextInformationPosition = (fContextInformation != null ? fCursorPosition : -1);
    }

    /**
     * Sets the trigger characters.
     * 
     * @param triggerCharacters The set of characters which can trigger the
     *            application of this completion proposal
     */
    public void setTriggerCharacters( char[] triggerCharacters ) {
        fTriggerCharacters = triggerCharacters;
    }

    /**
     * Sets the cursor position relative to the insertion offset. By default
     * this is the length of the completion string (Cursor positioned after the
     * completion)
     * 
     * @param cursorPosition The cursorPosition to set
     */
    public void setCursorPosition( int cursorPosition ) {

        if (cursorPosition >= 0) {
            fCursorPosition = cursorPosition;
            fContextInformationPosition = (fContextInformation != null ? fCursorPosition : -1);
        }
    }

    /*
     * @see ICompletionProposalExtension#apply(IDocument, char, int)
     */
    public void apply( IDocument document, char trigger, int offset ) {
        try {
            // patch replacement length

            int delta = offset - (fDocumentOffset + fReplacementLength);
            if (delta > 0)
                fReplacementLength += delta;

            if (trigger == (char) 0) {
                replace( document, fDocumentOffset, fReplacementLength, fReplacementString );
            }
            else {
                StringBuffer buffer = new StringBuffer( fReplacementString );

                if ((fReplacementLength < buffer.length() && buffer.charAt( fReplacementLength ) != trigger)) {
                    buffer.insert( fCursorPosition, trigger );
                    ++fCursorPosition;
                }

                replace( document, fDocumentOffset, fReplacementLength, buffer.toString() );
            }

            int oldLen = document.getLength();
            fDocumentOffset += document.getLength() - oldLen;
        }
        catch (BadLocationException x) {
            //Hetty 
            x.printStackTrace();
        }
    }

    /**
     * Replaces the document content at the specified offset and length with the
     * specified string.
     * 
     * @param document the document opened in the editor
     * @param offset offset to the document content to be replaced
     * @param length length of text to be replaced
     * @param string replacement string
     * @throws BadLocationException
     */
    private void replace( IDocument document, int offset, int length, String string ) throws BadLocationException {
        if (document != null && string != null && offset >= 0 && length >= 0) {
            if (!document.get( offset, length ).equals( string ))
                document.replace( offset, length, string );
        }
    }

    /*
     * @see ICompletionProposal#apply
     */
    public void apply( IDocument document ) {

        apply( document, (char) 0, fDocumentOffset + fReplacementLength );
    }

    /*
     * @see ICompletionProposal#getSelection
     */
    public Point getSelection( IDocument document ) {

        return new Point( fDocumentOffset + fCursorPosition, 0 );
    }

    /*
     * @see ICompletionProposal#getContextInformation()
     */
    public IContextInformation getContextInformation() {
        return fContextInformation;
    }

    /*
     * @see ICompletionProposal#getImage()
     */
    public Image getImage() {
        return fImage;
    }

    /*
     * @see ICompletionProposal#getDisplayString()
     */
    public String getDisplayString() {
        return fDisplayString;
    }

    /*
     * @see ICompletionProposal#getAdditionalProposalInfo()
     */
    public String getAdditionalProposalInfo() {
        return fAdditionalProposalInfo;
    }

    /*
     * @see ICompletionProposalExtension#getTriggerCharacters()
     */
    public char[] getTriggerCharacters() {
        return fTriggerCharacters;
    }

    /*
     * @see ICompletionProposalExtension#getContextInformationPosition()
     */
    public int getContextInformationPosition() {
        return fReplacementOffset + fContextInformationPosition;
    }

    /**
     * Gets the replacement offset.
     * 
     * @return the replacement offset
     */
    public int getReplacementOffset() {
        return fReplacementOffset;
    }

    /**
     * Sets the replacement offset.
     * 
     * @param replacementOffset the replacement offset to set
     */
    public void setReplacementOffset( int replacementOffset ) {

        if (replacementOffset >= 0) {
            fReplacementOffset = replacementOffset;
        }
    }

    /**
     * Gets the replacement length.
     * 
     * @return the replacement length
     */
    public int getReplacementLength() {
        return fReplacementLength;
    }

    /**
     * Sets the replacement length.
     * 
     * @param replacementLength the replacement length to set
     */
    public void setReplacementLength( int replacementLength ) {

        if (replacementLength >= 0) {
            fReplacementLength = replacementLength;
        }
    }

    /**
     * Gets the replacement string.
     * 
     * @return the replacement string
     */
    public String getReplacementString() {
        return fReplacementString;
    }

    /**
     * Sets the replacement string.
     * 
     * @param replacementString the replacement string to set
     */
    public void setReplacementString( String replacementString ) {
        fReplacementString = replacementString;
    }

    /**
     * Sets the image.
     * 
     * @param image the image to set
     */
    public void setImage( Image image ) {
        fImage = image;
    }

    /*
     * @see ICompletionProposalExtension#isValidFor(IDocument, int)
     */
    public boolean isValidFor( IDocument document, int offset ) {
        if (offset < fReplacementOffset)
            return false;

        int replacementLength = fReplacementString == null ? 0 : fReplacementString.length();
        if (offset >= fReplacementOffset + replacementLength)
            return false;

        try {
            int length = offset - fReplacementOffset;
            String start = document.get( fReplacementOffset, length );
            return fReplacementString.substring( 0, length ).equalsIgnoreCase( start );
        }
        catch (BadLocationException x) {
        }

        return false;
    }

}