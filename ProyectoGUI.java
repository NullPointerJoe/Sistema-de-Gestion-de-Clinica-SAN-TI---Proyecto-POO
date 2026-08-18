package ProyectoGUIGK;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ProyectoGUI extends JFrame implements ActionListener{
    ArrayList<Medico> ListaM = new ArrayList<>();
    ArrayList<Paciente> ListaP = new ArrayList<>();
    ArrayList<ingreso> ListaI = new ArrayList<>();
    
    private final JLabel L1;
    private final JPanel medico, paciente, ingreso;
    private final JTextField t1, t2, t3;
    private final JButton PI, PMs, PM, PE, MI, MMs, MM, ME, II, IMs, IM, IE, S;
    private JComboBox<String> LM, LP, LI;
    private final Font titulo = new Font("A", Font.ROMAN_BASELINE, 20);
    private final GridLayout La = new GridLayout(5, 1);
	
    public ProyectoGUI(){
        setLayout(null);
        setTitle("Clínica SAN TI");
        
        L1 = new JLabel("Gestión de la clínica");
        L1.setBounds(155,0,200,50);
        L1.setHorizontalAlignment(JLabel.CENTER);
        L1.setFont(titulo);
        add(L1);
        
        MI = new JButton("Ingresar");
        MI.addActionListener(this);
        
        MMs = new JButton("Mostrar");
        MMs.addActionListener(this);
        
        MM = new JButton("Modificar");
        MM.addActionListener(this);
        
        ME = new JButton("Eliminar");
        ME.addActionListener(this);

        PI = new JButton("Ingresar");
        PI.addActionListener(this);
        
        PMs = new JButton("Mostrar");
        PMs.addActionListener(this);

        PM = new JButton("Modificar");
        PM.addActionListener(this);

        PE = new JButton("Eliminar");
        PE.addActionListener(this);
        
        II = new JButton("Ingresar");
        II.addActionListener(this);
        
        IMs = new JButton("Mostrar");
        IMs.addActionListener(this);
        
        IM = new JButton("Modificar");
        IM.addActionListener(this);
        
        IE = new JButton("Eliminar");
        IE.addActionListener(this);
        
        S = new JButton("Salir");
        S.setBounds(180,265,150,40);
        S.addActionListener(this);
        add(S);
        
        t1 = new JTextField("Medico");
        t1.setEditable(false);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFocusable(false);
        t1.setFont(titulo);
        
        t2 = new JTextField("Paciente");
        t2.setEditable(false);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFocusable(false);
        t2.setFont(titulo);
        
        t3 = new JTextField("Ctrl. ingreso");
        t3.setEditable(false);
        t3.setHorizontalAlignment(JTextField.CENTER);
        t3.setFocusable(false);
        t3.setFont(titulo);
                
        medico = new JPanel();
        medico.setLayout(La);
        medico.setBackground(Color.GRAY);
        medico.setBounds(10, 50, 150, 200);
            medico.add(t1);
            medico.add(MI);
            medico.add(MMs);
            medico.add(MM);
            medico.add(ME);
        
        paciente = new JPanel();
        paciente.setLayout(La);
        paciente.setBackground(Color.GRAY);
        paciente.setBounds(180, 50, 150, 200);
            paciente.add(t2);
            paciente.add(PI);
            paciente.add(PMs);
            paciente.add(PM);
            paciente.add(PE);
        
        ingreso = new JPanel();
        ingreso.setLayout(La);
        ingreso.setBackground(Color.GRAY);
        ingreso.setBounds(350, 50, 150, 200);
            ingreso.add(t3);
            ingreso.add(II);
            ingreso.add(IMs);
            ingreso.add(IM);
            ingreso.add(IE);
        
        add(medico);
        add(paciente);
        add(ingreso);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        LM = new JComboBox<>(); LP = new JComboBox<>(); LI = new JComboBox<>();
        for(Medico m: ListaM){LM.addItem("Cod: "+m.MostrarCodM()+", "+m.MostrarLnM()+" "+m.MostrarNM());}
        for(Paciente p: ListaP){LP.addItem("Cod: "+p.MostrarCod()+", "+p.MostrarLn()+" "+p.MostrarN());}
        for(ingreso i: ListaI){LI.addItem("Cod: "+i.MostrarCodI()+", "+i.MostrarFI());}
        
        if (e.getSource() == S){
            System.exit(0);
        }
            // BOTONES MÉDICO
        if(e.getSource() == MI){
            setVisible(false);
            VMI MeI = new VMI();
            MeI.setBounds(0,0,450,270);
            MeI.setVisible(true);
            MeI.setResizable(false);
            MeI.setLocationRelativeTo(null);
            MeI.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    Medico Me = MeI.ObtenerD();
                    setVisible(true);
                    if(Me != null){
                        ListaM.add(Me);
                    }
                }
            });
        }else if(e.getSource() == MMs){
            if (ListaM.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos para mostrar", "Medico - Mostrar", JOptionPane.INFORMATION_MESSAGE);
            } else{
                int R = JOptionPane.showConfirmDialog(null, LM, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LM.getSelectedItem();
                    int codM = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    VMM VentanaMostrarM = new VMM(ListaM, codM);
                    VentanaMostrarM.setBounds(0,0,450,270);
                    VentanaMostrarM.setVisible(true);
                    VentanaMostrarM.setResizable(false);
                    VentanaMostrarM.setLocationRelativeTo(null);
                }
            }
        }else if(e.getSource()==MM){
            if(ListaM.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos para modificar", "Medico - Modificar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LM, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LM.getSelectedItem();
                    int codM = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    Medico me = null;
                    for(Medico m : ListaM){if(m.MostrarCodM() == codM){me = m; break;}}
                    if(me != null){
                        VMMO VentanaModM = new VMMO(ListaM, codM);
                        VentanaModM.setBounds(0,0,450,270);
                        VentanaModM.setVisible(true);
                        VentanaModM.setResizable(false);
                        VentanaModM.setLocationRelativeTo(null);
                        VentanaModM.addWindowListener(new WindowAdapter(){
                            @Override
                            public void windowClosed(WindowEvent e){
                                ListaM = VentanaModM.ObtenerD();
                            }
                        });
                    }
                }
            }
        }else if(e.getSource()==ME){
            if(ListaM.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos", "Medico - Eliminar", JOptionPane.CANCEL_OPTION);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LM, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LM.getSelectedItem();
                    int codM = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    Medico me = null;
                    for(Medico m : ListaM){if(m.MostrarCodM() == codM){me = m; break;}}
                    ListaM.removeIf(med -> med.MostrarCodM() == codM);
                }
            }
        }
            // BOTONES PACIENTE
        if(e.getSource() == PI){
            VPI PaI = new VPI();
            PaI.setBounds(0,0,470,290);
            PaI.setVisible(true);
            PaI.setResizable(false);
            PaI.setLocationRelativeTo(null);
            PaI.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    Paciente p = PaI.ObtenerDPA();
                    if(p != null){
                        ListaP.add(p);
                    }
                }
            });
        }else if(e.getSource()==PMs){
            if (ListaP.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay datos para mostrar", "Paciente - Mostrar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LP, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LP.getSelectedItem();
                    int codP = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    VPM PaM = new VPM(ListaP,codP);
                    PaM.setBounds(0,0,470,290);
                    PaM.setVisible(true);
                    PaM.setResizable(false);
                    PaM.setLocationRelativeTo(null);
                }
            }
        }else if(e.getSource()==PM){
            if(ListaP.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos para modificar", "Paciente - Modificar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LP, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LP.getSelectedItem();
                    int codP = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    VPMo PaM = new VPMo(ListaP, codP);
                    PaM.setBounds(0,0,470,290);
                    PaM.setVisible(true);
                    PaM.setResizable(false);
                    PaM.setLocationRelativeTo(null);
                    PaM.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosed(WindowEvent e){
                            ListaP = PaM.ObtenerLP();
                        }
                    });
                }
            }
        }else if(e.getSource()==PE){
            if(ListaP.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos", "Paciente - Eliminar", JOptionPane.CANCEL_OPTION);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LP, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LP.getSelectedItem();
                    int codP = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    Paciente Pa = null;
                    for(Paciente p : ListaP){if(p.MostrarCod() == codP){Pa = p; break;}}
                    ListaP.removeIf(Pac -> Pac.MostrarCod() == codP);
                }
            }
        }
            // BOTONES INGRESO
        if(e.getSource() == II){
            if(ListaP.isEmpty() || ListaM.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos en medicos/pacientes", "Ctrl. Ingresos - ingresar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                VII InI = new VII(ListaM, ListaP);
                InI.setBounds(0,0,470,375);
                InI.setVisible(true);
                InI.setResizable(false);
                InI.setLocationRelativeTo(null);
                InI.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e){
                        ingreso In = InI.ObtenerIn();
                        if(In != null){
                            ListaI.add(In);
                        }
                    }
                });
            }
        }else if(e.getSource()==IMs){
            if(ListaI.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos para mostrar", "Ctrl. Ingresos - Mostrar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LI, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LI.getSelectedItem();
                    int codI = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    VIM InM = new VIM(ListaI, ListaP, ListaM, codI);
                    InM.setBounds(0,0,470,375);
                    InM.setVisible(true);
                    InM.setResizable(false);
                    InM.setLocationRelativeTo(null);
                }
            }
        }else if(e.getSource()==IM){
            if (ListaI.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos para modificar", "Ctrl. Ingresos - Modificar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LI, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LI.getSelectedItem();
                    int codI = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    VIMO InMod = new VIMO(ListaI, ListaM, ListaP, codI);
                    InMod.setBounds(0,0,470,375);
                    InMod.setVisible(true);
                    InMod.setResizable(false);
                    InMod.setLocationRelativeTo(null);
                    InMod.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosed(WindowEvent e){
                            ListaI = InMod.ObtenerModLI();
                        }
                    });
                }
            }
        }else if(e.getSource()==IE){
            if(ListaI.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay datos", "Ctrl. Ingresos - Eliminar", JOptionPane.CANCEL_OPTION);
            }else{
                int R = JOptionPane.showConfirmDialog(null, LI, "Seleccione una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(R == JOptionPane.OK_OPTION){
                    String Cod = (String) LI.getSelectedItem();
                    int codI = Integer.parseInt(Cod.substring(Cod.indexOf(":") + 2, Cod.indexOf(",")));
                    ingreso In = null;
                    for(ingreso i: ListaI){if(i.MostrarCodI() == codI){In = i; break;}}
                    ListaI.removeIf(Ing -> Ing.MostrarCodI() == codI);
                }
            }
        }
    }
}