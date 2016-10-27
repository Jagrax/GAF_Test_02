package ar.com.gaf.controller;

import ar.com.gaf.entity.Corte;
import ar.com.gaf.entity.HojaDeCorte;
import ar.com.gaf.entity.Status;
import ar.com.gaf.entity.Taller;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean(name = "cortesEditController")
@ViewScoped
public class CortesEditController {

    private static final Logger logger = Logger.getLogger(CortesEditController.class);

    private Corte corte;
    private List<Corte> cortes;

    private enum ScreenMode {
        LIST, EDIT
    }

    private ScreenMode screenMode;

    @PostConstruct
    public void init() {
        Random rand = new Random();
        int[] talles = {30, 35, 40, 45, 50};

        // Genero unos talleres random como para poder settear algo en 'tallerId'
        List<Taller> talleres = new ArrayList<>();
        Taller taller;
        for (int n = 0; n < 10; n++) {
            taller = new Taller();
            taller.setId((long) n);
            taller.setName("Taller #" + (n + 1));
            taller.setAddress("Calle false 123");
            taller.setPhone("15-5555-5555");
            taller.setStatus(new Status((long) n, "TRABAJANDO", "TRABAJANDO.png"));
            taller.setEmployeesQuantity(75);
            taller.setScore(10);
            talleres.add(taller);
        }

        cortes = new ArrayList<>();
        for (int n = 0; n < 10; n++) {
            corte = new Corte();
            corte.setId((long) n);
            corte.setTitulo((rand.nextInt(8999) + 1000) + "/" + (rand.nextInt(9999) + 10000) + " | NMD | * | EN PROCESO");
            corte.setCantPrendas(500);
            GregorianCalendar calendar = new GregorianCalendar(2016, 10, 1);
            corte.setFechaEntrega(calendar.getTime());
            calendar.set(GregorianCalendar.MONTH, 9);
            calendar.set(GregorianCalendar.DAY_OF_MONTH, 30);
            corte.setPrimerVencimiento(calendar.getTime());
            corte.setPrecio(100.0);
            corte.setTallerId(talleres.get(n)); // Id del taller en el que se esta operando con este corte
            corte.setFromSize(talles[rand.nextInt(talles.length)]);
            corte.setToSize(corte.getFromSize() + 5);
            corte.setHojaDeCorte(null);
            corte.setStatus(new Status((long) 4, "EN PROCESO", "EN PROCESO.png"));
            cortes.add(corte);
        }
        screenMode = ScreenMode.LIST;
    }

    public Corte getCorte() {
        return corte;
    }

    public void setCorte(Corte corte) {
        this.corte = corte;
    }

    public List<Corte> getCortes() {
        return cortes;
    }

    public void setCortes(List<Corte> cortes) {
        this.cortes = cortes;
    }

    public ScreenMode getScreenMode() {
        return screenMode;
    }

    public void setScreenMode(ScreenMode screenMode) {
        this.screenMode = screenMode;
    }
}
