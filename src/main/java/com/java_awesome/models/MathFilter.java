package com.java_awesome.models;

import javax.swing.text.DocumentFilter;

import static com.java_awesome.models.MathRuler.isMathCharacter;

public class MathFilter extends DocumentFilter {
    
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
        fb.insertString(offset, getMathString(string), attr);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
        fb.replace(offset, length, getMathString(text), attrs);
    }
    
    private String getMathString(String text) {
        if(text == null || text.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            if (isMathCharacter(text.charAt(i))) {
                sb.append(MathConverter.convertBack(text.charAt(i)));
            }
        }
        
        return sb.toString();
    }

}
