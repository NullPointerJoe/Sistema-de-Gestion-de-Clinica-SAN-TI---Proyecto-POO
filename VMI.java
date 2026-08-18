package ProyectoGUIGK;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VMI extends JFrame implements ActionListener{
    private Medico Me;
    private final JButton C, G;
    private JLabel l1;
    private final JTextField TN, TLN, TT, TE;
    private final JTextArea TA;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VMI(){
        setLayout(null);
        setTitle("Medico - Ingresar");
        
        l1 = new JLabel("Datos del médico");
        l1.setBounds(165,10,120,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(25,55,100,30);
        add(l1);
        
        TN = new JTextField();
        TN.setBounds(105,60,100,20);
        add(TN);

        l1 = new JLabel("Apellido:");
        l1.setBounds(240,55,100,30);
        add(l1);
		
        TLN = new JTextField();
        TLN.setBounds(300,60,100,20);
        add(TLN);
                
        l1 = new JLabel("Especialidad:");
        l1.setBounds(25,95,100,30);
        add(l1);
		
        TE = new JTextField();
        TE.setBounds(105,100,100,20);
        add(TE);

        l1 = new JLabel("Teléfono:");
        l1.setBounds(240,95,100,30);
        add(l1);
		
        TT = new JTextField();
        TT.setBounds(300,100,100,20);
        add(TT);
                
        l1 = new JLabel("Dirección");
        l1.setBounds(25,135,100,30);
        add(l1);
        
        TA = new JTextArea();
        TA.setBounds(105,140,295,40);
        add(TA);
                
        G = new JButton("Guardar");
        G.setBounds(105,190,100,30);
        add(G);
        G.addActionListener(this);

        C = new JButton("Cancelar");
        C.setBounds(245,190,100,30);
        add(C);
        C.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C){
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(res == 0){
                dispose();
            }
        }else if(e.getSource() == G){
            if(TN.getText().isEmpty() & TLN.getText().isEmpty() & TA.getText().isEmpty() & TT.getText().isEmpty() & TE.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun dato.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String n = TN.getText();
                String ln = TLN.getText();
                String a = TA.getText();
                int t = Integer.parseInt(TT.getText());
                String es = TE.getText();
                Me = new Medico(n, ln, a,t,es);
                JOptionPane.showMessageDialog(null, "Datos Guardados.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } 
    }
    
    public Medico ObtenerD(){
        return Me;
    }   
}

class VMM extends JFrame implements ActionListener{
    private final JButton C;
    private JLabel l1;
    private final JTextField TN, TLN, TT, TE;
    private final JTextArea TA;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VMM(ArrayList<Medico> M, int cod){
        setLayout(null);
        setTitle("Medico - Mostrar");
        
        Medico Me = null;
        for(Medico Med: M){if(Med.MostrarCodM() == cod){Me = Med; break;}}
        
        l1 = new JLabel("Datos del médico");
        l1.setBounds(165,10,120,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(25,55,100,30);
        add(l1);
        
        TN = new JTextField(Me.MostrarNM());
        TN.setBounds(105,60,100,20);
        TN.setEditable(false);
        TN.setFocusable(false);
        add(TN);

        l1 = new JLabel("Apellido:");
        l1.setBounds(240,55,100,30);
        add(l1);
		
        TLN = new JTextField(Me.MostrarLnM());
        TLN.setBounds(300,60,100,20);
        TLN.setEditable(false);
        TLN.setFocusable(false);
        add(TLN);
                
        l1 = new JLabel("Especialidad:");
        l1.setBounds(25,95,100,30);
        add(l1);
		
        TE = new JTextField(Me.MostrarEM());
        TE.setBounds(105,100,100,20);
        TE.setEditable(false);
        TE.setFocusable(false);
        add(TE);

        l1 = new JLabel("Teléfono:");
        l1.setBounds(240,95,100,30);
        add(l1);
		
        TT = new JTextField(String.valueOf(Me.MostrarCM()));
        TT.setBounds(300,100,100,20);
        TT.setEditable(false);
        TT.setFocusable(false);
        add(TT);
                
        l1 = new JLabel("Direción:");
        l1.setBounds(25,135,100,30);
        add(l1);
        
        TA = new JTextArea(Me.MostrarAM());
        TA.setBounds(105,140,295,40);
        TA.setEditable(false);
        TA.setFocusable(false);
        add(TA);

        C = new JButton("Atras");
        C.setBounds(175,190,100,30);
        add(C);
        C.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C ){
            dispose();
        }
    }
}

class VMMO extends JFrame implements ActionListener{
    private Medico Me;
    private int Con=0;
    private ArrayList<Medico> LMe;
    private final JButton C, G;
    private JLabel l1;
    private final JTextField TN, TLN, TT, TE;
    private final JTextArea TA;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VMMO(ArrayList<Medico> LM, int cod){
        setLayout(null);
        setTitle("Medico - Modificar");
        
        LMe = LM;
        Me = null;
        for(Medico M: LMe){
            if(M.MostrarCodM()==cod){
                Me = M; break;
            }
            Con++;
        }
        
        l1 = new JLabel("Datos del médico");
        l1.setBounds(165,10,120,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(25,55,100,30);
        add(l1);
        
        TN = new JTextField();
        TN.setBounds(105,60,100,20);
        add(TN);

        l1 = new JLabel("Apellido:");
        l1.setBounds(240,55,100,30);
        add(l1);
		
        TLN = new JTextField();
        TLN.setBounds(300,60,100,20);
        add(TLN);
                
        l1 = new JLabel("Especialidad:");
        l1.setBounds(25,95,100,30);
        add(l1);
		
        TE = new JTextField();
        TE.setBounds(105,100,100,20);
        add(TE);

        l1 = new JLabel("Teléfono:");
        l1.setBounds(240,95,100,30);
        add(l1);
		
        TT = new JTextField();
        TT.setBounds(300,100,100,20);
        add(TT);
                
        l1 = new JLabel("Dirección");
        l1.setBounds(25,135,100,30);
        add(l1);
        
        TA = new JTextArea();
        TA.setBounds(105,140,295,40);
        add(TA);
                
        G = new JButton("Guardar");
        G.setBounds(105,190,100,30);
        add(G);
        G.addActionListener(this);

        C = new JButton("Cancelar");
        C.setBounds(245,190,100,30);
        add(C);
        C.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C ){
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(res == 0){
                dispose();
            }
        }else if(e.getSource() == G){
            if(TN.getText().isEmpty() & TLN.getText().isEmpty() & TA.getText().isEmpty() & TT.getText().isEmpty() & TE.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun dato.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String n = TN.getText();
                String ln = TLN.getText();
                String a = TA.getText();
                int t = Integer.parseInt(TT.getText());
                String es = TE.getText();
                Me.ModNM(n);
                Me.ModLnM(ln);
                Me.ModAM(a);
                Me.ModCM(t);
                Me.ModE(es);
                LMe.set(Con,Me);
                JOptionPane.showMessageDialog(null, "Datos Guardados.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } 
    }
    
    public ArrayList<Medico> ObtenerD(){
        return LMe;
    }   
}
