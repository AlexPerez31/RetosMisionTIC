package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.Consultas;
import model.dto.LeaderInfoDTO;
import model.dto.ProjectsByClassDTO;
import model.dto.PurchasesByPorjectDTO;

public class Controller {
    private Consultas leaderInfoDAO;
    private Consultas projectsByClassDAO;
    private Consultas purchasesByProjectDAO;

    public Controller() {
        this.leaderInfoDAO = new Consultas();
        this.projectsByClassDAO = new Consultas();
        this.purchasesByProjectDAO = new Consultas();
    } 

    public ArrayList<LeaderInfoDTO> toQueryLeaderInfo() throws SQLException {
        return leaderInfoDAO.consul1();
    }

    public ArrayList<ProjectsByClassDTO> toQueryProjectsByClass() throws SQLException {
        return projectsByClassDAO.consul2();
    }

    public ArrayList<PurchasesByPorjectDTO> toQueryPurchasesByProject() throws SQLException {
        return purchasesByProjectDAO.consul3();
    }
}
