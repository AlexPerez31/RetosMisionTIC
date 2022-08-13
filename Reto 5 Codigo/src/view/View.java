package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.dto.LeaderInfoDTO;
import model.dto.ProjectsByClassDTO;
import model.dto.PurchasesByPorjectDTO;

public class View extends JFrame {
    private Controller controller = new Controller();
    private JLabel lblBusqueda;
    private JTable table;
    private DefaultTableModel tableModel;

    public View() {
        setTitle("Consultas RETO 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLayout(null);

        lblBusqueda = new JLabel("Que consulta queire hacer?");
        lblBusqueda.setBounds(20, 10, 600, 20);
        getContentPane().add(lblBusqueda);

        table = new JTable();
        
        DefaultTableCellRenderer centeredTable = new DefaultTableCellRenderer();
        centeredTable.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);

        JScrollPane spOrganizador = new JScrollPane(table);
        spOrganizador.setBounds(240, 30, 600, 700);
        getContentPane().add(spOrganizador);
        
        JButton btnPBP = new JButton("Consulta de las compras");
        btnPBP.setBounds(20, 200, 200, 50);
        btnPBP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toViewPBP();
                
            }
            
        });
        getContentPane().add(btnPBP);

        JButton btnPBC = new JButton("Consulta de los proyectos");
        btnPBC.setBounds(20, 270, 200, 50);
        btnPBC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toViewPBC();
                
            }
            
        });
        getContentPane().add(btnPBC);

        JButton btnLI = new JButton("Consulta de los líderes");
        btnLI.setBounds(20, 340, 200, 50);
        btnLI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toViewLI();
                
            }
            
        });
        getContentPane().add(btnLI);
    }
    
    public void toViewLI() {
        try {
            ArrayList<LeaderInfoDTO> leaderInfoList = controller.toQueryLeaderInfo();
            lblBusqueda.setText("");
            tableModel = new DefaultTableModel(new String[] {"ID de Líder", "Nombre de Líder", "Primer Apellido de Líder", "Residencia de Líder"}, 0);
            
            for(LeaderInfoDTO leaderInfo : leaderInfoList) {
                tableModel.addRow(new Object[] {leaderInfo.getId(), leaderInfo.getName(), leaderInfo.getFirstLastName(), leaderInfo.getResidence()});
            }
            table.setModel(tableModel);
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void toViewPBC() {
        try {
            ArrayList<ProjectsByClassDTO> projectsByClassDTOList = controller.toQueryProjectsByClass();
            lblBusqueda.setText("");
            lblBusqueda.setBounds(20, 0, 700, 30);
            tableModel = new DefaultTableModel(new String[] {"ID de Proyecto", "Constructora", "N° de Habitatciones", "Ciudad"}, 0);
            for(ProjectsByClassDTO projectsByClassDTO : projectsByClassDTOList) {
                tableModel.addRow(new Object[] {projectsByClassDTO.getId(), projectsByClassDTO.getBuilder(), projectsByClassDTO.getRoomsNumber(), projectsByClassDTO.getCity()});
            }
            table.setModel(tableModel);
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void toViewPBP() {
        try {
            ArrayList<PurchasesByPorjectDTO> purchasesByPorjectDTOList = controller.toQueryPurchasesByProject();
            lblBusqueda.setText("");
            lblBusqueda.setBounds(20, 0, 700, 30);
            tableModel = new DefaultTableModel(new String[] {"ID de Compra", "Constructora", "Bancos Vinculados"}, 0);
            for(PurchasesByPorjectDTO purchasesByPorjectDTO : purchasesByPorjectDTOList) {
                tableModel.addRow(new Object[] {purchasesByPorjectDTO.getId(), purchasesByPorjectDTO.getBuilder(), purchasesByPorjectDTO.getLinkedBank()});
            }
            table.setModel(tableModel);
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
