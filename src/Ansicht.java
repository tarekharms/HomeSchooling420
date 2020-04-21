/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tarek.harms
 */
public class Ansicht {
    private IDatenhaltung datenhaltung;
    private JFrame mainFrame;
    private JTable table;
    private DefaultTableModel tablemodel;
    private JTextField field1;
    private JTextField field2;
    
    public Ansicht(IDatenhaltung datenhaltung)
    {
        this.datenhaltung = datenhaltung;
    }
    
    public void setDatenhaltung(IDatenhaltung datenhaltung)
    {
    	this.datenhaltung = datenhaltung;
    }
    
    public void open()
    {
        mainFrame = new JFrame();
        mainFrame.setLayout(null);

        this.field1 = new JTextField("Feld 1");
        addComponent(field1, 10, 10, 150, 30);
        this.field2 = new JTextField("Feld 2");
        addComponent(field2, 190, 10, 150, 30);
        
        JButton speicherButton = new JButton("Speichern");
        
        speicherButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e)
        	{
        		saveButtonClicked();
        	}
        });
        addComponent(speicherButton, 50, 50, 120, 30);
        
        try
        {
        	String[]  colnames = {"Textfeld 1", "Textfeld 2"};
        	this.tablemodel = new DefaultTableModel(this.datenhaltung.dateiLesen(), colnames);
        	this.table = new JTable(this.tablemodel);
        	JScrollPane pane = new JScrollPane(table);
            addComponent(pane, 10, 100, 200, 150);
        }
        catch (Exception e)
        {
        	System.out.println("Whoopsiedaisy");
        	System.out.println(e);
        }
        
        ButtonGroup group = new ButtonGroup();

        JRadioButton csvButton = new JRadioButton("csv");
        csvButton.setActionCommand("csv");
        csvButton.setSelected(true);
        JRadioButton xmlButton = new JRadioButton("xml");
        csvButton.setActionCommand("xml");
        
        group.add(csvButton);
        group.add(xmlButton);

        addComponent(csvButton, 10, 260, 50, 20);
        addComponent(xmlButton, 90, 260, 50, 20);
        
        mainFrame.setSize(400, 500);
        mainFrame.setVisible(true);
    }
    
    private void saveButtonClicked()
    {
    	try
    	{
    		this.datenhaltung.speichern(this.field1.getText(), this.field2.getText());
    		this.tablemodel.addRow(new Object[] {this.field1.getText(), this.field2.getText()});
    		this.table.repaint();
    	}
    	catch (Exception ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    private void addComponent(Component comp, int x, int y, int width, int height)
    {
    	comp.setBounds(x, y, width, height);
    	this.mainFrame.add(comp);
    }
}
