package com.java_awesome.views;

import com.java_awesome.extensions.IView;
import com.java_awesome.models.CalculatorViewModel;
import com.java_awesome.models.MathParseTable;
import com.java_awesome.models.MathRuler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.function.Consumer;

public class MainView extends ViewBase implements IView {
    private JPanel mainPanel;
    private JButton sevenBtn;
    private JPanel keysPanel;
    private JButton fourBtn;
    private JButton eightBtn;
    private JButton fiveBtn;
    private JButton nineBtn;
    private JButton sixBtn;
    private JButton divBtn;
    private JButton multipleBtn;
    private JButton oneBtn;
    private JButton twoBtn;
    private JButton threeBtn;
    private JButton subBtn;
    private JButton zeroBtn;
    private JButton pointBtn;
    private JButton equalBtn;
    private JButton addBtn;
    private JTextField inpTextField;
    private JPanel editorPanel;
    private JLabel outLabel;
    private JButton leftOpenBtn;
    private JButton rightOpenBtn;
    private JButton clearBtn;

    private CalculatorViewModel calculatorViewModel;
    private final DocumentFilter mathFilter;
    private Consumer<Runnable> calculateAction;
    private  boolean initialized; 

    public MainView(DocumentFilter mathFilter) {
        this.initialized = false;
        this.mathFilter = mathFilter;
    }
        
    
    public void initialize(CalculatorViewModel calculatorViewModel, Consumer<Runnable> calculateAction) {
        
        if(initialized) {
            return;
        }
        
        this.calculatorViewModel = calculatorViewModel;
        this.calculateAction = calculateAction;
        
        initUI();
        
    }
    
    private void initUI() {
        
        inpTextField.setText("");
        outLabel.setText("");


        getView().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                inpTextField.requestFocusInWindow();
            }
        });

        this.calculatorViewModel.addPropertyChangeListener("output", evt -> {
            outLabel.setText(calculatorViewModel.getOutput());
        });
        
        this.inpTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                outLabel.setVisible(false);
            }
        });
        
        this.zeroBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_0), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.oneBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_1), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.twoBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_2), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.threeBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_3), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.fourBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_4), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.fiveBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_5), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.sixBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_6), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.sevenBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_7), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.eightBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_8), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.nineBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), KeyEvent.getKeyText(KeyEvent.VK_9), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.pointBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.DECIMAL_POINT), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        
        
        this.addBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.PLUS_SIGN), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.subBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.MINUS_SIGN), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.multipleBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.MULTIPLICATION_SIGN), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.divBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.DIVISION_SIGN), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        
        this.equalBtn.addActionListener(e -> {
            calculateAction.accept(() -> {
                outLabel.setVisible(true);
            });
        });
        
        this.clearBtn.addActionListener(e -> {
            inpTextField.setText("");
            outLabel.setText("");
        });
        
        this.leftOpenBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.LEFT_PARENTHESIS), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.rightOpenBtn.addActionListener(e -> {
            try {
                inpTextField.getDocument().insertString(inpTextField.getCaretPosition(), MathParseTable.RawTable.get(MathRuler.RIGHT_PARENTHESIS), null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        this.outLabel.addPropertyChangeListener("text", evt -> {
            if(outLabel.getText().isEmpty()) {
                outLabel.setVisible(false);
            }
        });
        

        this.inpTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyChar() == KeyEvent.VK_EQUALS) {
                    calculateAction.accept(() -> {
                        outLabel.setVisible(true);
                    });
                }
            }
            
        });


        this.inpTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculatorViewModel.setInput(inpTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculatorViewModel.setInput(inpTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
    }
    
    @Override
    public JComponent getView() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(mathFilter);
        inpTextField = new JTextField(doc, null, 0);
    }
    
}
