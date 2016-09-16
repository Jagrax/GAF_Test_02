package ar.com.gaf.controller;

import ar.com.gaf.entity.Status;
import ar.com.gaf.entity.Taller;
import ar.com.gaf.service.StatusService;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ManagedBean(name = "talleresEditController")
@ViewScoped
public class TalleresEditController {

    private static final Logger logger = Logger.getLogger(TalleresEditController.class);

    private Taller taller;
    private List<Taller> talleres;

    private Status status;
    private List<Status> statusList;

    @ManagedProperty("#{statusService}")
    private StatusService service;

    private enum ScreenMode {
        LIST, EDIT
    }

    private ScreenMode screenMode;

    @PostConstruct
    public void init() {
        Random rand = new Random();

        List<String> address = new ArrayList<>();
        address.add("Av. Cabildo ");
        address.add("Av. Santa Fe ");
        address.add("Av. Maipu ");

        statusList = service.getStatusList();

        talleres = new ArrayList<>();
        for (int n = 0; n < 99; n++) {
            taller = new Taller();
            taller.setId((long) n);
            taller.setName("Taller #" + (n+1));
            taller.setAddress(address.get(rand.nextInt(3)) + rand.nextInt(1000));
            taller.setPhone("15-" + (rand.nextInt(8999) + 1000) + "-" + (rand.nextInt(8999) + 1000));
            taller.setStatus(statusList.get(rand.nextInt(3)));
            taller.setEmployeesQuantity(rand.nextInt(50) + 50);
            taller.setScore(rand.nextInt(9) + 1);

            talleres.add(taller);
        }

        screenMode = ScreenMode.LIST;
    }

    public void nuevo() {
        taller = new Taller();
        editar(taller);
    }

    public void eliminar(Taller taller) {
        if (talleres.contains(taller)) {
            talleres.remove(taller);
        }
    }

    public void editar(Taller taller) {
        setTaller(taller);
        setStatus(taller.getStatus());
        screenMode = ScreenMode.EDIT;
    }

    public void cancelar() {
        taller = null;
        screenMode = ScreenMode.LIST;
    }

    public void guardar() {
        taller.setStatus(status);
        Long id = taller.getId();
        if (id != null && talleres.contains(taller)) {
            int pos = 0;
            while (!taller.getId().equals(talleres.get(pos).getId())) {
                pos++;
            }
            talleres.remove(pos);
            talleres.add(pos, taller);
        } else {
            talleres.add(taller);
            logger.debug("Es nuevo");
        }
        taller = null;
        screenMode = ScreenMode.LIST;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public List<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(List<Taller> talleres) {
        this.talleres = talleres;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    public StatusService getService() {
        return service;
    }

    public void setService(StatusService service) {
        this.service = service;
    }

    public ScreenMode getScreenMode() {
        return screenMode;
    }

    public void setScreenMode(ScreenMode screenMode) {
        this.screenMode = screenMode;
    }
}
