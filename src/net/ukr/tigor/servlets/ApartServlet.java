package net.ukr.tigor.servlets;

import net.ukr.tigor.daoService.ConnectionFactory;
import net.ukr.tigor.daoService.FlatDAOImlp;
import net.ukr.tigor.entity.Flat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ApartServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Kiev";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private FlatDAOImlp fdi;

    @Override
    public void init() throws ServletException {
        super.init();
        fdi = new FlatDAOImlp(new ConnectionFactory(URL, USER, PASSWORD).getConnection(), "apartments");
        fdi.initBD();
        Flat f = new Flat("Днепровский","ул. Пушкина, д. 1, кв 18",45.5,36,1);
        fdi.add(f);

        f = new Flat("Днепровский","ул. Лермонтова,  д. 5, кв 10",80,56,2);
        fdi.add(f);

        f = new Flat("Деснянский","ул. Ломоносова,  д. 3, кв 50",70,60,3);
        fdi.add(f);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String command = req.getParameter("command");
        String auto = req.getParameter("auto");

        switch (command) {
            case "Add": {
                String district = req.getParameter("district");
                String address = req.getParameter("address");
                String price = req.getParameter("price");
                String area = req.getParameter("area");
                String roomsCount = req.getParameter("roomsCount");

                fdi.add(new Flat(district, address, Double.parseDouble(price), Double.parseDouble(area), Integer.parseInt(roomsCount)));
                if (auto != null) {
                    sendList(req, resp, auto);
                } else {
                    resp.sendRedirect("index.jsp");
                }
                break;
            }
            case "Delete": {
                String id = req.getParameter("id");
                fdi.delete(Integer.parseInt(id));
                if (auto != null) {
                    sendList(req, resp, auto);
                } else {
                    resp.sendRedirect("index.jsp");
                }
                break;
            }
            case "Get all": {
                String params = req.getParameter("params");
                List<Flat> ap = fdi.getAll(Flat.class);
                req.setAttribute("apartments", ap);
                req.setAttribute("auto", auto);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(req, resp);
                break;
            }
            case "Get by params": {
                String params = req.getParameter("params");
                List<Flat> ap = fdi.getAll(Flat.class,params);
                req.setAttribute("apartments", ap);
                req.setAttribute("auto", auto);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(req, resp);
                break;
            }
        }
    }

    private void sendList(HttpServletRequest req, HttpServletResponse resp, String auto) {
        List<Flat> ap = fdi.getAll(Flat.class);
        req.setAttribute("apartments", ap);
        req.setAttribute("auto", auto);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
