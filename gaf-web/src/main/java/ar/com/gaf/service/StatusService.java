package ar.com.gaf.service;

import ar.com.gaf.entity.Status;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "statusService", eager = true)
@ApplicationScoped
public class StatusService {

    private List<Status> statusList;

    @PostConstruct
    public void init() {
        statusList = new ArrayList<Status>();
        statusList.add(new Status((long) 0, "DISPONIBLE", "DISPONIBLE.png"));
        statusList.add(new Status((long) 1, "NO DISPONIBLE", "NO DISPONIBLE.png"));
        statusList.add(new Status((long) 2, "TRABAJANDO", "TRABAJANDO.png"));
    }

    public List<Status> getStatusList() {
        return statusList;
    }

}
