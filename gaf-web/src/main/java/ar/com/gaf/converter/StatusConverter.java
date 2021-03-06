package ar.com.gaf.converter;

import ar.com.gaf.entity.Status;
import ar.com.gaf.service.StatusService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("statusConverter")
public class StatusConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null && s.trim().length() > 0) {
            try {
                StatusService service = (StatusService) facesContext.getExternalContext().getApplicationMap().get("statusService");
                return service.getStatusList().get(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversion", "No es un estado valido."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null) {
            return String.valueOf(((Status) o).getId());
        } else {
            return null;
        }
    }
}
