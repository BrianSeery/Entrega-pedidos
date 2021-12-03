package ar.edu.fie.undef.entrega_pedidos.Initializers;

import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.services.SucursalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SucursalInitializer implements InitializingBean {

    private final SucursalService sucursalService;
    private final Logger log = LoggerFactory.getLogger(SucursalInitializer.class);

    public SucursalInitializer(SucursalService sucursalService) {this.sucursalService = sucursalService;}

    @Override
    public void afterPropertiesSet() throws Exception {

        if (sucursalService.count() == 0L) {
            List<Sucursal> sucursalList = new ArrayList<>();

            sucursalList.add(new Sucursal("Pampa"));
            sucursalList.add(new Sucursal("Balbin"));
            sucursalList.add(new Sucursal("Soldado886"));
            sucursalList.add(new Sucursal("Pedraza"));
            sucursalList.add(new Sucursal("Cramer"));
            sucursalList.add(new Sucursal("Cabildo"));
            sucursalList.add(new Sucursal("Matias"));

            sucursalService.saveAll( sucursalList);
        }
    }
}
